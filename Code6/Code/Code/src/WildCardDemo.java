import java.util.ArrayList;
class A1{
	
}
class B extends A1{
	
}
class C extends B{
	
}
class D extends B{
	
}
public class WildCardDemo {
	static void show(A1 []a){
		
	}
	
	// ? extends Serializable
//	static void print(ArrayList<? extends B> aList){
//		
//	}
//	static void print(ArrayList<? super B> aList){
//		
//	}
	
static void print(ArrayList<?> aList){
		
	}
	public static void main(String[] args) {
		
		B b [] = new B[10];
		show(b);
		C c[] = new C[10];
		show(c);
		ArrayList<B> bList =new ArrayList<>();
		print(bList);
		ArrayList<A1> aList = new ArrayList<>();
		print(aList);
		// TODO Auto-generated method stub

	}

}
