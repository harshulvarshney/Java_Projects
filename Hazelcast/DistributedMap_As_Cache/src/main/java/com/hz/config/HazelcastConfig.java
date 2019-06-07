package com.hz.config;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;

/**
 * 
 * @author harshul.varshney
 *
 */
@Configuration
@ConditionalOnExpression("${hz.use_hazelcast}")
public class HazelcastConfig {
	
	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private Environment env;

	@Bean
	public Config config() {

		Config config = new Config();

		// mgmt config
		config.setManagementCenterConfig(
				new ManagementCenterConfig().setEnabled(true).setUrl(env.getProperty("hz.management.center.url")));

		// logging
		config.setProperty("hazelcast.logging.type", "log4j2");

		JoinConfig joinConfig = config.getNetworkConfig().getJoin();

		joinConfig.getMulticastConfig().setEnabled(false);
		joinConfig.getAwsConfig().setEnabled(false);

		joinConfig.getTcpIpConfig().setMembers(getServerList()).setConnectionTimeoutSeconds(10).setEnabled(true);

		MapConfig mapConfig = new MapConfig();
		mapConfig.setName("hzCache").setEvictionPolicy(EvictionPolicy.LRU)
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizePolicy.FREE_HEAP_SIZE));

		return config;
	}

	@Bean
	public HazelcastInstance instance(Config config) {
		return Hazelcast.newHazelcastInstance(config);
	}

	@Bean("memberCache")
	public ISet<String> cache(HazelcastInstance instance) {
		return instance.getSet("memberCache");
	}

	private List<String> getServerList() {
		List<String> nodes = new ArrayList<>(2);
		int numOfNodes = Integer.parseInt(env.getProperty("hz.numOfNodes"));
		for (int count = 1; count <= numOfNodes; count++) {
			String key = "hz.node" + count;
			nodes.add(env.getProperty(key));
		}
		return nodes;
	}
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    loggingFilter.setAfterMessagePrefix("REQUEST ## ");
	    return loggingFilter;
	}


}
