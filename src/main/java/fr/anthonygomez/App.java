package fr.anthonygomez;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.util.Bytes;

import fr.anthonygomez.hbase.HBaseCore;
import fr.anthonygomez.hbase.CRUD.ProductCRUD;
import fr.anthonygomez.models.Product;

public class App 
{
	
	public static Configuration config;
	
    public static void main(String[] args)
    
    {
    	
    	System.out.println("---RUN---\n");
    	
    	HBaseCore.initHBCore();
    	
    	ProductCRUD.generateStruct();
    	
    	ProductCRUD.addElement(new Product(1, "ProduitTest!"));
    	
    	System.out.println("Product label : "+ProductCRUD.getElement(Bytes.toBytes(1)));
    	
    	ProductCRUD.deleteElement(Bytes.toBytes(1));
    	
    	System.out.println("\n---FINISH---");
    }
}
