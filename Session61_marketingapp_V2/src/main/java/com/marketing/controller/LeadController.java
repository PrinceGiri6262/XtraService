package com.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;
import com.marketing.utill.EmailService;

/* -------------------------------------------------------------------------------------------------------------------------- */
//Notes:
/* -------------------------------------------------------------------------------------------------------------------------- */
//@Controller:
//@Autowired:
//@RequestMapping:
//@ModelAttribute:
//@RequestParam:
//ModelMap:
//model:
/* -------------------------------------------------------------------------------------------------------------------------- */


@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	
/* -------------------------------------------------------------------------------------------------------------------------- */
//Email Service: 
/* -------------------------------------------------------------------------------------------------------------------------- */	
	@Autowired
	private EmailService emailService;

	// Handler Methods To navigate to “create_lead.jsp”, because only controller can access this. 
	// URL:-http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return "create_lead";

	}

/* -------------------------------------------------------------------------------------------------------------------------- */
//CREATE LEAD :- There are multiple ways to transfer object data from “View Layer” to database.
/* -------------------------------------------------------------------------------------------------------------------------- */
//1.Ways : Using "@ModelAttribute" To Save data from View Layer to the database (LeadController.java).
	
//STEP 1:Handler Methods To navigate to “create_lead.jsp”, because only controller can access this (<form action="saveLead" method="post">) .
	@RequestMapping("/saveLead")
	
//STEP 2: @ModelAttribute("l"): "lead" object stores the data & reference variable is "l". 
      //Lead: "Lead" is a entity class and "l" is reference variable.
      //ModelMap:(acts like setAttribute) is same as "Request.set & getAttribute" to put back message in View Layer(create.jsp).
	public String saveOneLead(@ModelAttribute("l") Lead lead, ModelMap model) {

//STEP 3: controller layer(package com.marketing.controller) call service layer(package com.marketing.services)
		leadService.saveLeadInfo(lead);
		
//Email Service
		emailService.sendEmail(lead.getEmail(), "Welcome", "test email from Spring Boot");

//STEP 4: To print the message after saving the data.
		model.addAttribute("msg", "record is saved!!");
		
//STEP 5: Return view(create_lead.jsp) page.
		return "create_lead";

	}

/* ------------------------------------------------------------------------------------------------------------------------- */
//2.Ways : Using "@RequestParam" To Save data from View Layer to the database.
//[NOTE : It will make the method argument lengthy if working with huge no.of fields, Recommended for less no. of fields.


//STEP 1:
//	@RequestMapping("/saveLead")

//STEP 2: @RequestParam: act like WebServlet (Request to get-parameter).
//	public String saveOneLead(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
//			@RequestParam("email") String email, @RequestParam("mobile") String mobile, ModelMap model) {

//STEP 3: create object (lead).
//		Lead lead = new Lead();
	
//STEP 4: entities class(package com.marketing.entities ) is set-parameter.
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//STEP 5: controller layer(package com.marketing.controller) call service layer(package com.marketing.services)
//		leadService.saveLeadInfo(lead);
	
//STEP 6: To print the message after saving the data.
//		model.addAttribute("msg", "record is saved!!");
	
//STEP 7: Return view(create_lead.jsp) page.
//		return "create_lead";

//	}

/* -------------------------------------------------------------------------------------------------------------------------- */
//3.Ways : Using " DTO- Data Transfer Object (Directly LeadData)" To Save data from View Layer to the database.
//STEP 1:Create new package (com.marketing.dto).
//STEP 2:Create new class (LeadData.java).
//STEP 3:Create variables matching to create.jsp file from attribute names.
//STEP 4:Generate Getter and Setters.
	
//STEP 5:
//	@RequestMapping("/saveLead")
	
//STEP 6:LeadData: Press Ctr+1, and import class(LeadData.java) in dto package(com.marketing.dto).
//	public String saveOneLead(LeadData leadData, ModelMap model) {//import com.marketing.dto.Leaddata

//STEP 7: Create Object: lead Object is needed to save data in DB
//		Lead lead = new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());

//STEP 8:controller layer(package com.marketing.controller) call service layer(package com.marketing.services)
//		leadService.saveLeadInfo(lead);
		
//STEP 9: To print the message after saving the data.
//		model.addAttribute("msg", "record is saved!!");
	
//STEP 10: Return view(create_lead.jsp) page.
//		return "create_lead";
	
//	}
	
/*---------------------------------------------------------------------------------------------------------------------------
 * Note:-
   Every time restarting the servers manually is painful, let’s make it automatic so that whenever we make any changes to our
   project, server should automatically restart (Live Loading). To do that Right Click on the project, & in cascade menu select
   Spring>Add"DevTools".
 */
	
/* -------------------------------------------------------------------------------------------------------------------------- */
//READ LEAD	:- “listAll” method from “LeadController.java” will return the “leadSearchResult.jsp”
/* -------------------------------------------------------------------------------------------------------------------------- */
//STEP 1:create a method listall 
	// http://localhost:8080/listall
	@RequestMapping("/listall")
	
//STEP 2:create a method listall 
	public String listAllLeads(Model model) {

//STEP 3:Controller method called service method
		java.util.List<Lead> leads = leadService.getLeads();
		System.out.println(leads);//print to console

//STEP 4:
		model.addAttribute("leads", leads);
		
//STEP 5: Return view(list_leads.jsp) page.
		return "";
		
	}
/* -------------------------------------------------------------------------------------------------------------------------- */
//DELETE LEAD :-
/* -------------------------------------------------------------------------------------------------------------------------- */

	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, Model model) {
		leadService.deleteLead(id);

		java.util.List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}

/* -------------------------------------------------------------------------------------------------------------------------- */
//UPDATE LEAD :-
/* -------------------------------------------------------------------------------------------------------------------------- */
	@RequestMapping("/update")
	public String getLeadInfo(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}

	@RequestMapping("/updateLead")
	public String updateLeadInfo(LeadData data, Model model) {
		
		Lead l = new Lead();
		l.setId(data.getId());
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		
		leadService.saveLeadInfo(l);
		java.util.List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";

	}
/* -------------------------------------------------------------------------------------------------------------------------- */
}
