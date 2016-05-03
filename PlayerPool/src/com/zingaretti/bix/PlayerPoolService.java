package com.zingaretti.bix;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;


@Path("/PlayerPoolService")
public class PlayerPoolService {

   SkaterModel skaterModel = new SkaterModel();
   GoalieModel goalieModel = new GoalieModel(); 
   
   private static final String SUCCESS_RESULT = "<html>Success</html>";
   private static final String FAILURE_RESULT = "<html>Failure</html>";
   
   @GET
   @Path("/skaters")
   @Produces(MediaType.APPLICATION_XML)
   public List<Skater> getSkaters(){
      return skaterModel.getFullList();
   }	
   
   /*
    * Create a skater object using the HTML url encoded form.
    */
   @PUT
   @Path("/skatersByForm")
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   @Produces(MediaType.TEXT_HTML)
   public String addSkater(@FormParam("firstName") String firstName,
		   @FormParam("lastName") String lastName,
		   @FormParam("emailPrimary") String emailPrimary,
		   @FormParam("smsTextNumber") String smsTextNumber,
		   @FormParam("zipCode") String zipCode,
		   @FormParam("password") String password)
   {
	     
	   Skater skater = new Skater();
	   
	   skater.setFirstName(firstName);
	   skater.setLastName(lastName);
	   skater.setEmailPrimary(emailPrimary);
	   skater.setZipCode(zipCode);
	   skater.setPassword(password);
	   
	   if (skaterModel.addSkater(skater))
	   	 return SUCCESS_RESULT;
	   else
	   	 return FAILURE_RESULT;   
   
   }
   
   /*
    * Create a skater object using the xml application type. 
    */
   @PUT
   @Path("/skatersByXml")
   @Consumes(MediaType.APPLICATION_XML)
   @Produces(MediaType.TEXT_HTML)
   public String addSkater(Skater skater)
   {
	   if (skaterModel.addSkater(skater))
	   	 return SUCCESS_RESULT;
	   else
	   	 return FAILURE_RESULT;   
   }
   
   @POST
   @Path("skaters")
   @Consumes(MediaType.APPLICATION_XML)
   public void modifySkater()
   {
	   
   }

   @GET
   @Path("/goalies")
   @Produces(MediaType.APPLICATION_XML)
   public List<Goalie> getGoalies(){
      return goalieModel.getFullList();
   }	
   
   @PUT
   @Path("/goalies")
   @Consumes(MediaType.APPLICATION_XML)
   public void addGoalie()
   {
	   
   }
   
   @POST
   @Path("/goalies")
   @Consumes(MediaType.APPLICATION_XML)
   public void modifyGoalie()
   {
	   
   }
   
}