package com.sample.h2database.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ApiController {
	
	IAPIService apiService;
	
	@Autowired
	public ApiController(IAPIService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json", value="/findall")
	public @ResponseBody String findAll() {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String response = "";
		try {
			response = mapper.writeValueAsString(apiService.findAll());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json", value="/addall")
	public @ResponseBody String addAll() {
		
		
		String response = "";
		try {
			apiService.addProduct("TV", "New TV in the market");
			apiService.addProduct("Internet", "Gigabit in the market");
			apiService.addProduct("Phone", "Digital Phone in the market");
		} catch (Exception e) {
			
		}
		return "Successfully added products";
	}
	
}
