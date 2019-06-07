package com.hz.controller;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.ISet;

/**
 * 
 * @author harshul.varshney
 *
 */
@RestController
public class DemoController {
	
	@Autowired ISet<String> memberCache;
	
	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@PostMapping("/hzDistMap/add/{member}")
	public void addMember(@PathVariable("member") String member) {
		logger.info("Adding: {}" + member);
		memberCache.add(member);
	}
	
	@DeleteMapping("/hzDistMap/delete/{member}")
	public ResponseEntity<Boolean> removeMember(@PathVariable("member") String member) {
		logger.info("Removing: {}" + member);
		if(memberCache.remove(member)) {
			ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
		}
		return ResponseEntity.status(HttpStatus.OK).body(Boolean.FALSE);
	}
	
	@GetMapping("/hzDistMap/get/{member}")
	public void getMember(@PathVariable("member") String member) {
		logger.info("Get: {}" + member);
	}

}
