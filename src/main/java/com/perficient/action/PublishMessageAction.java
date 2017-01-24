package com.perficient.action;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.perficient.domain.Message;


/**
 * @author praveen.muthusamy
 *
 */
@Component
public class PublishMessageAction {

	/**
	 * 
	 */
	public PublishMessageAction() {
	}
	
	public String publishMessageToQueue(Message message){
		final String uri = "https://prftnotifier.cfapps.io/rest/publish";
		try{ 
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.postForObject( uri, message, String.class);
			System.out.println(result);
			return "Mail sent Successfully";
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error ::: "+e.getMessage());
			return "Mail sending Failure.";
		}
	}
}
