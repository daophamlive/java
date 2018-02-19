package learning.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import learning.model.Customer;

public class TextFileFactory {
	public static boolean saveFile(ArrayList<Customer> customers, String path)
	{
		try	
		{
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			for(Customer customer : customers)
			{
				String line = customer.getCustomerId() + ";" + customer.getName() + ";" + customer.getMobile();
				bw.write(line);
				bw.newLine();
			}

			bw.close();
			osw.close();
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
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader brd = new BufferedReader(isr);
			String line = brd.readLine();
			while(line != null)
			{
				String[] arr = line.split(";");

				if(arr.length == 3)
				{
					double id = Double.parseDouble(arr[0]);
					Customer cus = new Customer(id, arr[1], arr[2]);
					customers.add(cus);
				}
				line = brd.readLine();
			}
			brd.close();
			isr.close();
			fis.close();
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
