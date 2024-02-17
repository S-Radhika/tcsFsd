package com.tcs.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.rest.resource.Investor;
import com.tcs.rest.service.InvestorService;



@RestController
@RequestMapping("/investor/api.1.0")
public class InvestorResource {
	@Autowired 
	//GET POST PUT DELETE
	InvestorService service;

	
	@GetMapping
	public String check(){
		return "/investor/api.1.0";
	}
    
	@GetMapping
    @RequestMapping("/allinvestor")
	 public List<Investor> showAllInvestor(){
		return service.getInvestor();
	}

	
	@GetMapping
	@RequestMapping("/investorid/{id}")
	public Investor fetchInvestor(@PathVariable int id) {
		return service.getInvestorById(id);
	}
	
	@PostMapping
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE,
	value="/addinvestor")
	
	public Investor createInvestor(@RequestBody Investor investor) {
		return service.save(investor);
		
	}
	
	@PutMapping
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
		produces= MediaType.APPLICATION_JSON_VALUE,
		value= "/modify")
	public Investor updateInvestor(@RequestBody Investor inv) {
		return service.update(inv);
	}
		
	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String deleteInvestor(@PathVariable int id){
		return service.delete(id);
	}
		
	
	
}
	


