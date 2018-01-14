import java.util.HashMap;

interface Order{
	int ONE = 1;
	int TWO = 2;
	int THREE =3;
}
enum OrderEnum{
	ONE(1), TWO(2) , THREE(3) , FOUR(4), FIVE(5);
	private int value;
	OrderEnum(int val){
		this.value = val;
	}
	public int getValue(){
		return this.value;
	}
	
}
public class NumberKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderEnum e = OrderEnum.ONE;
		HashMap<OrderEnum,String> map = new HashMap<>();
		map.put(e,"Order A");
		map.put(OrderEnum.TWO,"Order A");
		System.out.println(e.getValue());

	}

}
