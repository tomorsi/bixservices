package com.zingaretti.bix;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

// Debugging
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;


@Path("/PlayerPoolService")
public class PlayerPoolService {
   static Logger logger;
   
   static {
	   	logger = Logger.getLogger("com.appinf");
   }
   	
	
   SkaterModel skaterModel = new SkaterModel();
   GoalieModel goalieModel = new GoalieModel(); 
   
   private static final String SUCCESS_RESULT = "<html>Success</html>";
   private static final String FAILURE_RESULT = "<html>Failure</html>";
   
   public PlayerPoolService()
   {
	   logger.logp(Level.INFO,"PlayerPoolService","CTOR","ENTER");
	   
	   String jaxClass = "empty";
	   try {
		   jaxClass = getDebugJaxClass();
	   } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   logger.logp(Level.INFO,"PlayerPoolService","CTOR",jaxClass);
	   
   }
       
   private String getDebugJaxClass() throws Exception
   {
     JAXBContext jc = JAXBContext.newInstance(Skater.class);
     Skater s = new Skater();
     s.setFirstName("Tom");
     s.setLastName("Orsi");
     Marshaller marshaller = jc.createMarshaller();
     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
     
     marshaller.marshal(s, byteOutputStream);
     return byteOutputStream.toString();
   }
   
   @GET
   @Path("/skaters")
   @Produces(MediaType.APPLICATION_XML)
   public List<Skater> getSkaters(){
	  logger.logp(Level.INFO,"PlayerPoolService","getSkaters","ENTER");
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
	   logger.logp(Level.INFO,"addSkater By Form","addSkater","ENTER");
	   
	     
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
	   logger.logp(Level.INFO,"addSkater By XML","addSkater","ENTER");
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
	   
	   System.out.println("Enter modifyskater");
	   
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