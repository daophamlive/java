package learning.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import learning.model.Customer;

public class SerializeFileFactory {
	public static boolean saveFile(ArrayList<Customer> customers, String path)
	{
		try	
		{
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(customers);
			oos.close();
			fos.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static ArrayList<Customer> readFile(String path)
	{
		try {
			ArrayList<Customer> customers = new ArrayList<Customer>();

			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			customers = (ArrayList<Customer>) obj;
			
			ois.close();
			fis.close();
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
