package uk.elastic.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElasticService {
	
	@Autowired
	private ElasticRestClientBuilder elasticRestClientBuilder;
	
	public void sendRequest(ConsumerFailure consumerFailure) throws IOException {
		
		 Map<String, Object> message = new HashMap<>();
         String id = consumerFailure.getId();
         message.put("messageType",consumerFailure.getMessageType());
         message.put("topic", consumerFailure.getTopic());
         message.put("groupId",consumerFailure.getGroupId());
         message.put("offset", consumerFailure.getOffset());
         message.put("value",consumerFailure.getValue());
         message.put("timestamp", consumerFailure.getTimestamp());

         IndexRequest request = new IndexRequest("kafkamsgfailures", "kfailures",id).source(message);
         IndexResponse response = elasticRestClientBuilder.getRestHighLevelClient().index(request);
         System.out.println(response);
	}

	public void sendRequest(Customer customer) throws IOException {
		Map<String, Object> message = new HashMap<>();
        String id = customer.getId().toString();
        message.put("messageType","customersuccess");
        message.put("firstName", customer.getFirstName());
        message.put("emailAddress", customer.getEmailAddress());
        message.put("addressLine1", customer.getAddressLine1());
        message.put("addressLine2", customer.getAddressLine2());
        message.put("city",customer.getCity());
        message.put("postalCode", customer.getPostalCode());
        message.put("phoneNumber", customer.getPhoneNumber());
        message.put("createdBy", customer.getCreatedBy());
        
        IndexRequest request = new IndexRequest("kafkamsgfailures", "kfailures",id).source(message);
        IndexResponse response = elasticRestClientBuilder.getRestHighLevelClient().index(request);
        System.out.println(response);
	}
	
	public void sendRequest(Application application) throws IOException {
		Map<String, Object> message = new HashMap<>();
        String id = application.getId().toString();
        message.put("messageType","applicationsuccess");
        message.put("customerId", application.getCustomerId());
        message.put("heiCode", application.getHeiCode());
        message.put("courseCode", application.getHeiCode());
        message.put("courseYear", application.getCourseYear());
        message.put("tflAmount",application.getTflAmount());
        message.put("mlAmount", application.getMlAmount());
        message.put("createdBy", application.getCreatedBy());
        message.put("confirmedAtnInd", application.getConfirmedAtnInd());
        
        IndexRequest request = new IndexRequest("kafkamsgfailures", "kfailures",id).source(message);
        IndexResponse response = elasticRestClientBuilder.getRestHighLevelClient().index(request);
        System.out.println(response);
	}

}
