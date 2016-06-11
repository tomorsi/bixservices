package com.zingaretti.bix;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Debugging
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


@Path("/PlayerPoolService")
public class PlayerPoolService {
   static Logger logger;
   
   static {
	   	logger = Logger.getLogger("com.appinf");
   }
   	
	
    
   SkaterModel skaterModel = new SkaterModel();
   GoalieModel goalieModel = new GoalieModel(); 
   RinkModel rinkModel = new RinkModel();
   
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
     JAXBContext jc = JAXBContext.newInstance(Rink.class);
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
   @Path("/Skaters")
   @Produces(MediaType.APPLICATION_XML)
   public List<Skater> getSkaters(){
	  logger.logp(Level.INFO,"PlayerPoolService","getSkaters","ENTER");
      return skaterModel.getFullList();
   }	
   
   @GET
   @Path("/Rinks")
   @Produces(MediaType.APPLICATION_XML)
   public List<Rink> getRinks(){
	  logger.logp(Level.INFO,"PlayerPoolService","getRinks","ENTER");
      return rinkModel.getFullList();
   }
   
   
   /*
    * Add a Skater object using the xml application type. 
    */
   @PUT
   @Path("/Skater")
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
   
   /*
    * Add a Rink object using the xml data type.
    */
   @PUT
   @Path("/Rink")
   @Consumes(MediaType.APPLICATION_XML)
   @Produces(MediaType.TEXT_HTML)
   public String addRink(Rink rink)
   {
	   logger.logp(Level.INFO,"addRink using xml","addRink","ENTER");
	   if (rinkModel.addRink(rink))
	       return SUCCESS_RESULT;
	   else
	   	   return FAILURE_RESULT;   
   }
   
   @POST
   @Path("Rinks")
   @Consumes(MediaType.APPLICATION_XML)
   public void modifyRink()
   {
	   
	   System.out.println("Enter modifyRink");
	   
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