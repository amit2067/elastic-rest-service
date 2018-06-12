package uk.elastic.rest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

@Component	
public class ElasticRestClientBuilder {

	
	RestClientBuilder builder = null;
	RestHighLevelClient restHighLevelClient = null;
	@PostConstruct
	public void init() {
		builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
		restHighLevelClient = new RestHighLevelClient(builder);
	}
	
	public RestClientBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(RestClientBuilder builder) {
		this.builder = builder;
	}

	public RestHighLevelClient getRestHighLevelClient() {
		return restHighLevelClient;
	}

	public void setRestHighLevelClient(RestHighLevelClient restHighLevelClient) {
		this.restHighLevelClient = restHighLevelClient;
	}

	@PreDestroy
	public void teraDown() {
		try{
			if(restHighLevelClient != null) {
				restHighLevelClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
