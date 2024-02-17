package com.tcs.rest.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.rest.repository.TransactionRepository;
import com.tcs.rest.resource.Transaction;
import com.tcs.rest.resource.Investor;

@Service
public class TransactionService {
	
	@Autowired
    TransactionRepository repo;
	
	public List<Transaction> getTransaction(){
		List <Transaction> list1 = repo.findAll();
		return list1;
	}
	
	public Transaction getById(int id) {
		Optional<Transaction> transaction = repo.findById(id);
		return transaction.get();
	}
	public Transaction save(Transaction t){
		return repo.save(t);
	}
	public Transaction update(Transaction i) {
		 Optional<Transaction>  optional = repo.findById(i.getTid());
		 Transaction tempTransaction = optional.get();
		 tempTransaction.setTamount(i.getTamount());
		 tempTransaction.setIid(i.getIid());
		 repo.save(tempTransaction);
		 return tempTransaction;
	}

		
	
}	
	
	
	
	
	
	
	
