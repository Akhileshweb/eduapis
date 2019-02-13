package com.edupeep.eduapis.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edupeep.eduapis.exception.ResourceNotFoundException;
import com.edupeep.eduapis.model.Employee;
import com.edupeep.eduapis.repository.EmployeeRepository;
import com.edupeep.eduapis.services.EmployeeServices;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    
     
    @Autowired
    private EmployeeServices employeeServices;
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
    	
    	employee.setProfile_pic("RandomNamedp.jpg");
    	  	
    	Employee  empObj;
    	
    	empObj =  employeeServices.createEmployee(employee);
    	
    	HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		  
		  final String filename= "RandomNamedp.jpg";
		  
		  try {
			  
			  //byte[] tempImage = recoverImageFromUrl("https://images-eu.ssl-images-amazon.com/images/G/31/img18/AmazonDevices/kindle/DC_260X260._CB455495283_SY260_.jpg");
			  byte[] tempImage = recoverImageFromUrl(employee.getProfile_pic());
		      
			  ByteArrayResource contentsAsResource = new ByteArrayResource(tempImage){
		            @Override
		            public String getFilename(){
		                return filename;
		            }
		        };
			  
			  MultiValueMap<String, Object> body  = new LinkedMultiValueMap<>();
			  body.add("file", contentsAsResource);
			  
			  HttpEntity<MultiValueMap<String, Object>> requestEntity  = new HttpEntity<>(body, headers);
			  
			  String serverUrl = "http://localhost:8080/uploadFile";
			  
			  RestTemplate restTemplate = new RestTemplate();
			  ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		  
		    
    	return empObj;
    	
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
    public byte[] recoverImageFromUrl(String urlText) throws Exception {
        URL url = new URL(urlText);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
         
        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }
     
        return output.toByteArray();
    }
    

}
