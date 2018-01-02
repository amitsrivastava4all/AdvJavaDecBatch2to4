import java.util.HashSet;

class Customer{
	int id;
	String name;
	double balance;
	Customer(int id, String name, double balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + "\n]";
	}
	@Override
	public int hashCode(){
		return name.length();
	}
	
	@Override
	public boolean equals(Object object){
		if(object instanceof Customer){
			Customer c = (Customer) object;
			if(this == c){
				return true;
			}
			if(this.id == c.id 
					&& this.name.equals(c.name) 
					&& this.balance == c.balance){
				return true;
			}
		}
		return false;
	}
	
}
public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Customer> customerSet = new HashSet<>();
		Customer c = new Customer(1001,"Ram",9999);
		customerSet.add(c);
		customerSet.add(c);
		System.out.println(c.hashCode());
		c = new Customer(1001,"tim",9999);
		customerSet.add(c);
		System.out.println(c.hashCode());
		c = new Customer(1002,"Shyam",2999);
		System.out.println(c.hashCode());
		customerSet.add(c);
		c = new Customer(1002,"Shyam",2999);
		System.out.println(c.hashCode());
		customerSet.add(c);
		System.out.println(customerSet);
	}

}
