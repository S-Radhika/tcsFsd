package com.tcs.rest.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.rest.repository.InvestorRepository;
import com.tcs.rest.resource.Investor;



@Service
public class InvestorService {
	
	@Autowired
    InvestorRepository repo;
	
	public List<Investor> getInvestor(){
		List <Investor> list = repo.findAll();
		return list;
	}
	
	public Investor getInvestorById(int id) {
		Optional<Investor> investor = repo.findById(id);
		return investor.get();
	}
	public Investor save(Investor i){
		return repo.save(i);
	}
	public Investor update(Investor i) {
		 Optional<Investor>  optional = repo.findById(i.getId());
		 Investor tempInvestor = optional.get();
		
		 tempInvestor.setName(i.getName());
		 tempInvestor.setAmount(i.getAmount());
		 tempInvestor.setAddress(i.getAddress());
		 repo.save(tempInvestor);
		 return tempInvestor;
		
	}
	public String delete(int id) {
		Optional<Investor> deleted = repo.findById(id);
		repo.deleteById(id);
		return "Successfully deleted: "+ deleted;
	}
	
	
}
