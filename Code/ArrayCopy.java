class MyLinkedList{
	int data;
	MyLinkedList next;
	MyLinkedList prev;
}
public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x [] = {10,20,30,40,50,60};
		int y [] = new int[10];
//		for(int i= 0; i<x.length;i++){
//			y[i] = x[i];
//		}
//		x = y;
//		for(int i :x){
//			System.out.println(i);
//		}
		System.arraycopy(x, 0, y, 0, x.length);
		for(int i :y){
			System.out.println(i);
		}
		
		
	}

}
