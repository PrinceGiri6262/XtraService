package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {
	
	//CREATE LEAD :- 
	public void saveLeadInfo(Lead lead);

	//READ LEAD	:- “listAll” 
	public List<Lead> getLeads();

	//DELETE LEAD :-
	public void deleteLead(long id);

	//CREATE LEAD :- 
	public Lead getOneLead(long id);



	

}
