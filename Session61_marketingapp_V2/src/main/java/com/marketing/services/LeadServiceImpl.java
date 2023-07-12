package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;

//@Service: It is used to mark the class as a service provider. 
//[NOTE:If we don't use @Service annotation,otherwise this will be ordinary class.]
@Service
public class LeadServiceImpl implements LeadService {
	@Autowired// Dependency Injection
	private LeadRepository leadRepo;

	
/* -------------------------------------------------------------------------------------------------------------------------- */
//@Override:
	@Override
	public void saveLeadInfo(Lead lead) {
		leadRepo.save(lead);//To save data into the database.
	}
	
/* -------------------------------------------------------------------------------------------------------------------------- */
	@Override
	public List<Lead> getLeads() {
		List<Lead> leads = leadRepo.findAll();//To read data into the database. beacus its many object 
		return leads;
	}
	
/* -------------------------------------------------------------------------------------------------------------------------- */
    @Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);//To delete data from the database
	}

/* -------------------------------------------------------------------------------------------------------------------------- */
	@Override
	public Lead getOneLead(long id) {
    Optional<Lead> findById = leadRepo.findById(id);//findrecord by ID# in the database
    Lead lead = findById.get();
    return lead;
	}
	
/* -------------------------------------------------------------------------------------------------------------------------- */
}
