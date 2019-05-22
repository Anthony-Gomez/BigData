package fr.anthonygomez.hbase.drivers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import fr.anthonygomez.hbase.HBaseCore;
import fr.anthonygomez.models.Product;

public class ProductCRUD extends HBaseCore {
	
	// META-INFOS
	
	private static TableName tableName = TableName.valueOf("Product");
	private static String infosColumn = "infos";
	
	// TABLE STRUCTURE
	
	public static void generateStruct() {
		
		 try {
			if (admin.tableExists(tableName) == false) {
				HTableDescriptor desc = new HTableDescriptor(tableName);
				desc.addFamily(new HColumnDescriptor(infosColumn));
				try {
					admin.createTable(desc);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// CREATE 
	
	// Single element
	
	public static void addElement(Product prodcut) {
		byte[] row = Bytes.toBytes(prodcut.getId());
		Put p = new Put(row);
		p.addImmutable(infosColumn.getBytes(), "label".getBytes(), Bytes.toBytes(prodcut.getLabel()));
		try {
			Table table = HBaseCore.connection.getTable(tableName);
			table.put(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Multi elements
	
	public static void addElements(Collection<Product> products) {
		
		for (Product product : products) {
			
			addElement(product);
		}
		
	}
	
	// READ
	
	// single element
	
	public static String getElement(byte[] row) {
		
		Get g = new Get(row);
		Table table = getTableFromNameTable(tableName);
		Result r = null;
		try {
			r = table.get(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] value = r.getValue(infosColumn.getBytes(), "label".getBytes());
		String resultString = null;
		try {
			resultString = new String(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultString;
	}
	
	// Multi elements
	
	public static ArrayList<String> getElements(ArrayList<byte[]> rows) {
		
		ArrayList<String> elements = new ArrayList<>();
		
		for (byte[] row : rows) {
			String resultString = getElement(row);
			elements.add(resultString);
		}
		return elements;
		
	}
	
	// UPDATE
	
	// Single element
	
	
	
	// Multi element
	
	
	
	// DELETE
	
	// Single element
	
	public static void deleteElement(byte[] row) {
		Delete delete = new Delete(row);
		try {
			HBaseCore.connection.getTable(tableName).delete(delete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Multi elements
	
	public static void deleteElements(ArrayList<byte[]> rows) {
		
		ArrayList<String> elements = new ArrayList<>();
		
		for (byte[] row : rows) {
			deleteElement(row);
		}
	}
	
	

}
