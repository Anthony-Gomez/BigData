package fr.anthonygomez.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import com.google.protobuf.ServiceException;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main(String[] args)
    {
    	Configuration config = HBaseConfiguration.create();
    	 
    	String path = App.class.getResource("hbase-site.xml").getPath();
    	config.addResource(new Path(path));
    	try {
    		HBaseAdmin.checkHBaseAvailable(config);
    	} catch (ServiceException | IOException e) {
    		e.printStackTrace();
    	}
    }
}
