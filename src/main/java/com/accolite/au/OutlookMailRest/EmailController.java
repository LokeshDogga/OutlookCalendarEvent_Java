package com.accolite.au.OutlookMailRest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.au.OutlookMailRest.Model.Email;
import com.accolite.au.OutlookMailRest.Service.EmailServiceImpl;

@Path("outlook")
public class EmailController {

	EmailServiceImpl emailService = new EmailServiceImpl();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sendMail(Email email) {
		emailService.send(email);
		return "Success";
	}
}
