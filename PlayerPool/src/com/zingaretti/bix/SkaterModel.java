package com.zingaretti.bix;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class SkaterModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5345148168978320712L;
	
	private BasicDataSource ds = null;
	static private final String driverName = "org.postgresql.Driver";
	static private final String connectionUrl ="jdbc:postgressql://bixdb/bixdb";
	
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
	
	public void addSkater(Skater s)
	{
	
		
	}
	
	public List<Skater> getFullList()
	{
		
		return null;
	}
}
