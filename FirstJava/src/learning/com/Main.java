package learning.com;

import java.util.ArrayList;
import java.util.Collections;

import learning.io.*;
import learning.model.*;

public class Main {

	private final static String SERIAL_FILE = "serial.txt";
	private final static String TEXT_FILE = "text.txt";

	static void PrintCustomers(ArrayList<Customer> customers)
	{
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Customer> customers = new ArrayList<Customer>();

		customers.add(new Customer(1, "Nguyen Van A", "0978754"));
		customers.add(new Customer(2, "Le van C", "345345"));
		customers.add(new Customer(3, "Pham Minh D", "3765647"));
		customers.add(new Customer(4, "Quach thi E", "56753234"));
		customers.add(new Customer(5, "Le thi F", "47823345"));


		SerializeFileFactory.saveFile(customers, SERIAL_FILE);

		customers = SerializeFileFactory.readFile(SERIAL_FILE);

		PrintCustomers(customers);
		System.out.println("print bang text file");

		TextFileFactory.saveFile(customers, TEXT_FILE);

		customers = TextFileFactory.readFile(TEXT_FILE);

		Collections.sort(customers);
		PrintCustomers(customers);


	}


}
