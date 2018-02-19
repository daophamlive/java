package learning.model;
import java.io.Serializable;

public class Customer implements Serializable, Comparable<Customer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobile=" + mobile + "]";
	}

	private double customerId;
	private String name;
	private String mobile;
	public double getCustomerId() {
		return customerId;
	}
	public void setCustomerId(double customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Customer(double customerId, String name, String mobile) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobile = mobile;
	}
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

}
