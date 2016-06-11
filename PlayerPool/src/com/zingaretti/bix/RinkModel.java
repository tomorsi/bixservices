package com.zingaretti.bix;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.util.PSQLException;



public class RinkModel implements Serializable {
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
		"INSERT INTO RINK(RINKNAME,ADDRESS,STATECODE,ZIPCODE,MANAGERPHONE,MANAGEREMAIL, PASSWORD) "+
		"VALUES(?,?,?,?,?,?,?)";
	static private final String SQL_SELECT_FULL = 
		"SELECT RINKNAME,ADDRESS,STATECODE,ZIPCODE,MANAGERPHONE,MANAGEREMAIL FROM RINK";
		
	RinkModel()
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
	
	public Boolean addRink(Rink rink)
	{
		Boolean bSuccess = true;
		
		try {
		
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
			statement.setString(1,rink.getRinkName());
			statement.setString(2,rink.getAddress());
			statement.setString(3,rink.getStateCode());
			statement.setString(4,rink.getZipCode());
			statement.setString(5,rink.getManagerPhone());
			statement.setString(6,rink.getManagerEmail());
			statement.setObject(7,rink.getPassword(),Types.OTHER);
		
			statement.executeUpdate();
		} 
		catch (PSQLException pse)
		{
			logger.logp(Level.INFO,"RinkModel","addRink",pse.toString());
			bSuccess = false;
		}
		catch (SQLException se)
		{
		    logger.logp(Level.INFO,"RinkModel","addRink",se.toString());
			bSuccess = false;
		}
		
		return bSuccess;
	}
	
	public List<Rink> getFullList()
	{
		List<Rink> rinkList = null;
		
		try {
		
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_FULL);
			
			rinkList = new ArrayList<Rink>();
			
			while(resultSet.next())
			{
				Rink rink = new Rink();
				rink.setRinkName(resultSet.getString("RINKNAME"));
				rink.setAddress(resultSet.getString("ADDRESS"));
				rink.setStateCode(resultSet.getString("STATECODE"));
				rink.setZipCode(resultSet.getString("ZIPCODE"));
				rink.setManagerPhone(resultSet.getString("MANAGERPHONE"));
				rink.setManagerEmail(resultSet.getString("MANAGEREMAIL"));
				
				rinkList.add(rink);
			}
		}
		catch (PSQLException pse)
		{
			logger.logp(Level.INFO,"RinkModel","getFullList",pse.toString());
			
		}
		catch (SQLException se)
		{
		    logger.logp(Level.INFO,"RinkModel","getFullList",se.toString());
		}
		
		return rinkList;
	}
}
