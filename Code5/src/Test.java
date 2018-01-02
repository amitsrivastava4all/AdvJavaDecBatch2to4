import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Customer> customerMap = new HashMap<>();
		Customer customer = new Customer(1001,"Ram",9000);
		Address address1 = new Address("Delhi","Delhi","110007");
		Address address2 = new Address("Delhi","Delhi","110007");
		Address address3 = new Address("Mumbai","Mumbai","210007");
		TreeSet<Address> addressSet =
				new TreeSet<>((first,second)->
				first.getCity().compareToIgnoreCase(second.getCity()));
		addressSet.add(address1);
		addressSet.add(address2);
		addressSet.add(address3);
		HashMap<String,TreeSet<Address>> addressMap = new HashMap<>();
		addressMap.put("office", addressSet);
		customer.setAddressMap(addressMap);
		
		
		customerMap.put(customer.getName(), customer);
		
		TreeSet<Address> officeAddress = customerMap.
				get("Ram").getAddressMap().get("office");
		Iterator<Address> it = officeAddress.iterator();
		int currentIndex = 0;
		int qCount =2;
		while(it.hasNext()){
			Address add = it.next();
			currentIndex++;
			if(currentIndex==qCount){
				break;
			}
			System.out.println(add.getCity());
		}
		System.out.println("STREAM >>>>>>>>>>>>>>>>>");
		customerMap.
		get("Ram").getAddressMap().get("office")
		.stream().forEach(address->System.out.println(address));
		// Order
		Product p = new Product(1,"Abcd",9999);
		Product p1 = new Product(2,"Xyz",19999);
		ArrayList<Product> productList = new ArrayList<>();
		productList.add(p);
		productList.add(p1);
		Order order = new Order(1,"OrderA",new Date(),productList);
		HashMap<Integer,Order> orderMap = new HashMap<>();
		orderMap.put(order.getId(),order);
		customer.setOrderMap(orderMap);
		System.out.println("Orders....");
		Collections.sort(customerMap.get("Ram").getOrderMap().get(1).getProductList());
		System.out.println(customerMap.get("Ram").getOrderMap().get(1).getProductList());
	}

}
















