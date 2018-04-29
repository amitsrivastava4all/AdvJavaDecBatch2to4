import java.util.TreeSet;

class Customer {//implements Comparable<Customer>{
	int id;
	String name;
	double balance;
//	@Override
//	public int compareTo(Customer object){
//		return this.name.compareToIgnoreCase(object.name);
//	}
	Customer(int id , String name , double balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString(){
		return "id "+id+" Name "+name+" Balance "+balance+"\n";
	}
}
public class CustomerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Customer> ts = 
				new TreeSet<>
		((first,second)->first.name.compareToIgnoreCase(second.name));
		ts.add(new Customer(1001,"Ram",9999));
		ts.add(new Customer(1002,"Shyam",7999));
		ts.add(new Customer(1003,"Mike",8999));
		ts.add(new Customer(1002,"Shyam",7999));
		ts.add(new Customer(1004,"Tim",9999));
		ts.add(new Customer(1001,"Ram",9999));
		System.out.println(ts);
	}

}
