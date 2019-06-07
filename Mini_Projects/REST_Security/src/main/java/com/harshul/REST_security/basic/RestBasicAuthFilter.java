package com.harshul.REST_security.basic;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Custom filter to authenticate incoming request on rest controller.
 * Authentication via Basic strategy.
 * 
 * @author harshul.varshney
 */
@Component
@Configurable
public class RestBasicAuthFilter extends OncePerRequestFilter {

	public static final String AUTHENTICATION_HEADER = "Authorization";
	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		String authCredentials = request.getHeader(AUTHENTICATION_HEADER);

		boolean authenticationStatus = authenticate(authCredentials);

		if (authenticationStatus) {
			filter.doFilter(request, response);
		} else {
			if (response instanceof HttpServletResponse) {
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;
				httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
	}
	
	private boolean authenticate(String authCredentials) {
		if (null == authCredentials)
			return false;
		
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		//doing in-memory auth for demo purpose.
		boolean authenticationStatus = "admin".equals(username) && "admin".equals(password);
		return authenticationStatus;
	}


	@Override
	public void destroy() {
		
	}

}
