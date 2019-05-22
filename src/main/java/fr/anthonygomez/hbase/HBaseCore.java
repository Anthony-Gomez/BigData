package fr.anthonygomez.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class HBaseCore {
	
	private Configuration config;
	
	public HBaseCore() {
		
		this.config = HBaseConfiguration.create();
        
        String path = this.getClass()
          .getClassLoader()
          .getResource("hbase-site.xml")
          .getPath();
        config.addResource(new Path(path));
	}
	
	public Configuration getConfig() {
		return this.config;
	}

}
