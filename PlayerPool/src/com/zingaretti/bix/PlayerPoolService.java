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
   public String addSkater(@FormParam("firstname") String firstname,
		   @FormParam("lastname") String lastname,
		   @FormParam("emailprimary") String emailprimary,
		   @FormParam("smstextnumber") String smstextnumber,
		   @FormParam("zipcode") String zipcode,
		   @FormParam("password") String password)
   {
	     
	   
	   return SUCCESS_RESULT;
   }
   
   /*
    * Create a skater object using the xml application type. 
    */
   @PUT
   @Path("/skatersByXml")
   @Consumes(MediaType.APPLICATION_XML)
   @Produces(MediaType.TEXT_HTML)
   public String addSkater(JAXBElement<Skater> skater)
   {
	     	   
	   return SUCCESS_RESULT;
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