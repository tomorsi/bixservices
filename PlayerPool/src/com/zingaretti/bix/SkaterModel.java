package com.zingaretti.bix;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.util.PSQLException;



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
		
	static private final String SQL_SELECT_FULL = 
		"SELECT FIRSTNAME,LASTNAME,EMAILPRIMARY,SMSTEXTNUMBER,ZIPCODE,SKATER) FROM PLAYER";
		
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
		catch (PSQLException pse)
		{
		    logger.logp(Level.INFO,"SkaterModel","addSkater",pse.toString());
		    bSuccess = false;
		}
		catch (SQLException se)
		{
		    logger.logp(Level.INFO,"SkaterModel","addSkater",se.toString());
			bSuccess = false;
		}
		
		return bSuccess;
	}
	
	public List<Skater> getFullList()
	{
		List<Skater> skaterList = null;
		
		try {
		
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_FULL);
			
			skaterList = new ArrayList<Skater>();
			
			while(resultSet.next())
			{
				Skater skater = new Skater();
				
				skaterList.add(skater);
			}
		}
		catch (PSQLException pse)
		{
		    logger.logp(Level.INFO,"SkaterModel","getFullList",pse.toString());
		}
		catch (SQLException se)
		{
		    logger.logp(Level.INFO,"SkaterModel","getFullList",se.toString());
		}
		
		return skaterList;
	}
}
