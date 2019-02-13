package com.edupeep.eduapis.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestfulClient {
	RestTemplate restTemplate;
	
	public RestfulClient(){
		restTemplate = new RestTemplate();
	}
	
	/**
	 * post entity
	 */
	public void postEntity(){
		System.out.println("Begin /POST request!");
		String postUrl = "http://localhost:8080//api/v1/uploadFile";
		String name = "EduPEEP.pptx";
		String imagePath = "C:\\Users\\Akhilesh\\Desktop";
		String data = UtilBase64Image.encoder(imagePath);
		
		System.out.println("Post Image'info: name = " + name + " ,data = " + data);
		Image customer = new Image(name, data);
		
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, customer, String.class);
		System.out.println("Response for Post Request: " + postResponse.getBody());
	}
	
	/**
	 * get entity
	 */
	public void getEntity(){
		System.out.println("Begin /GET request!");
		String getUrl = "http://localhost:8080/get?name=demoImage.png";
		ResponseEntity<Image> getResponse = restTemplate.getForEntity(getUrl, Image.class);
		
		if(getResponse.getBody() != null){
			Image image = getResponse.getBody();
			System.out.println("Response for Get Request: " + image.toString());
			System.out.println("Save Image to C:\\client\\get");
			UtilBase64Image.decoder(image.getData(), "C:\\client\\get\\" + image.getName());
			System.out.println("Done!");
		}else{
			System.out.println("Response for Get Request: NULL");
		}
	}
}
