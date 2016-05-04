package com.zingaretti.bix;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.apache.commons.dbcp2.BasicDataSource;



public class SkaterModel implements Serializable {
	static Logger logger;
   
   	static {
		logger = Logger.getLogger("com.appinf");
   	}
   	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5345148168978320712L;
	
	private BasicDataSource ds = null;
	static private final String driverName = "org.postgresql.Driver";
	static private final String connectionUrl ="jdbc:postgresql://bixdb/bixdb";
	static private final String SQL_INSERT = 
		"INSERT INTO PLAYER(FIRSTNAME,LASTNAME,EMAILPRIMARY,SMSTEXTNUMBER,ZIPCODE,PASSWORD,SKATER) "+
		"VALUES(?,?,?,?,?,?,TRUE)";
	
	SkaterModel()
	{
		ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUsername("torsi");
		ds.setPassword("borland6");
		ds.setUrl(connectionUrl);
	}

	private Connection getConnection()
	{
		Connection c = null;
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return c;
	}
	
	public Boolean addSkater(Skater skater)
	{
		Boolean bSuccess = true;
		
		try {
		
		Connection connection = this.getConnection();
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
		statement.setString(1,skater.getFirstName());
		statement.setString(2,skater.getLastName());
		statement.setString(3,skater.getEmailPrimary());
		statement.setString(4,skater.getSmsTextNumber());
		statement.setString(5,skater.getZipCode());
		statement.setObject(6,skater.getPassword(),Types.OTHER);
		
		statement.executeUpdate();
		} 
		catch (SQLException se)
		{
		    logger.logp(Level.INFO,"SkaterModel","addSkater",se.toString());
			bSuccess =false;
		}
		
		return bSuccess;
	}
	
	public List<Skater> getFullList()
	{
		return null;
	}
}
