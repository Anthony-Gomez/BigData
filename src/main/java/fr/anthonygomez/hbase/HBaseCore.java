package fr.anthonygomez.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Table;

import com.google.protobuf.ServiceException;

public class HBaseCore {
	
	protected static Admin admin;
	protected static Configuration config;
	protected static Connection connection;
	
	
	public static void initHBCore() {
		config = HBaseConfiguration.create();
   	 
    	String path = HBaseCore.class.getResource("hbase-site.xml").getPath();
    	config.addResource(new Path(path));
    	try {
    		HBaseAdmin.checkHBaseAvailable(config);
    	} catch (ServiceException | IOException e) {
    		e.printStackTrace();
    	}
    	try {
    	  connection = ConnectionFactory.createConnection(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Admin admin = null;
		
		try {
			HBaseCore.admin = connection.getAdmin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Table getTableFromNameTable(TableName tableName) {
		Table table = null;
		try {
			table = HBaseCore.connection.getTable(tableName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
	

}
