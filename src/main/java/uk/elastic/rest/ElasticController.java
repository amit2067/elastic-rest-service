package uk.elastic.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ElasticController {
	
   @Autowired	
   private ElasticService elasticService;
	
	@PostMapping("/createLog")
	public ResponseEntity<?> createLog(@RequestBody ConsumerFailure consumerFailure) throws IOException {
		elasticService.sendRequest(consumerFailure);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/pushCustomer")
	public ResponseEntity<?> pushCustomer(@RequestBody Customer customer) throws IOException {
		elasticService.sendRequest(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/pushApplication")
	public ResponseEntity<?> pushApplication(@RequestBody Application application) throws IOException {
		elasticService.sendRequest(application);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
