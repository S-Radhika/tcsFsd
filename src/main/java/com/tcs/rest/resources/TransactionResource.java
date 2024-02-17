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

import com.tcs.rest.resource.Transaction;
import com.tcs.rest.service.TransactionService;



@RestController
@RequestMapping("/transaction/api.1.0")
public class TransactionResource {
	@Autowired 
	//GET POST PUT DELETE
	TransactionService service;

	
	@GetMapping
	public String check(){
		return "/transaction/api.1.0";
	}
    
	@GetMapping
    @RequestMapping("/alltransactions")
	 public List<Transaction> showAllTransaction(){
		return service.getTransaction();
	}

	
	@GetMapping
	@RequestMapping("/transactionid/{id}")
	public Transaction fetchTransaction(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE,
	value="/addtransaction")
	
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return service.save(transaction);
		
	}
	
	@PutMapping
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
		produces= MediaType.APPLICATION_JSON_VALUE,
		value= "/modify")
	public Transaction updateTransaction(@RequestBody Transaction ts) {
		return service.update(ts);
	}
		
	
		
	
	
}