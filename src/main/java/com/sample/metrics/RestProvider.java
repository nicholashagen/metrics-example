package com.sample.metrics;

import java.net.URI;

import javax.inject.Inject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Timed;

public class RestProvider {
	
	@Inject private HttpClient httpClient;
	@Inject private MetricRegistry registry;
	
	@Timed
	public HttpResponse get(URI uri) {
		try {
			registry.counter(MetricRegistry.name(RestProvider.class, "counter")).inc();
			
			HttpGet httpget = new HttpGet(uri.toURL().toExternalForm());
			HttpResponse response = this.httpClient.execute(httpget);
			if (response.getStatusLine().getStatusCode() != 200) {
		    	throw new IllegalStateException("invalid response: " + 
				    response.getStatusLine().getStatusCode() + ": " + 
				   	response.getStatusLine().getReasonPhrase()
				);
		    }
		    
		    return response;
		}
		catch (Exception exception) {
			throw new IllegalStateException(exception);
		}
	}
}
