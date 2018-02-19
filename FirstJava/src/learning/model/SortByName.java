package learning.model;

import java.util.Comparator;

public class SortByName implements Comparator<Customer> {

	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
