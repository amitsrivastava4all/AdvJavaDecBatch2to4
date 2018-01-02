import java.util.ArrayList;
import java.util.HashMap;
class Address{
	String phone;
	String city;
	String state;
	Address(String phone,String city, String state){
		this.phone = phone;
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [phone=" + phone + ", city=" + city + ", state=" + state + "]";
	}
	
}
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,ArrayList<Address>> phoneMap = new HashMap<>();
		ArrayList<Address> amitNos = new ArrayList<>();
		amitNos.add(new Address("2222","Delhi","Delhi"));
		amitNos.add(new Address("3333","Mumbai","Mumbai"));
		phoneMap.put("amit", amitNos);
//		ArrayList<Integer> ramNos = new ArrayList<>();
//		ramNos.add(5555);
//		ramNos.add(5555);
//		phoneMap.put("ram", ramNos);
		//System.out.println(phoneMap);
		System.out.println(phoneMap.get("amit"));
	}

}
