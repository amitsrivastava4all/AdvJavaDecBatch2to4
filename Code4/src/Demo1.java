import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int xx []= {90,1,100,88};
		Arrays.sort(xx);
		System.out.println("Plain Array Sort "+xx);  // HashCode
		for(int i= 0; i<xx.length; i++){
			System.out.println(xx[i]);
		}
		for(int y : xx){
			System.out.println(y);
		}
		ArrayList<Integer> l = new ArrayList<>();
		//Object arr[]  = l.toArray();
		int x4 = 1000;
		l.add(x4) ;  // l.add (new Integer(x));  // Boxing
		Integer y11 = (Integer)l.get(0); // UnBoxing
		int z = y11.intValue();
		l.add(100);
		int m = l.get(1);
		l.add(1, 2000);
		l.add(200);
		l.remove(0);
		l.set(0, 9999);
		if(l.contains(100)){
			System.out.println("Found...");
		}
		else{
			System.out.println("Not Found...");
		}
		//l.add("Amit");
		//l.add(true);
		Collections.sort(l);
		System.out.println(l);  // l.toString()
		// Traverse
		for(int i = 0 ; i<l.size() ; i++){
			System.out.println(l.get(i));
		}
		int counter= 0;
		Iterator<Integer> j = l.iterator();
		while(j.hasNext()){
			int g = j.next(); // current and move to next
			if(g>10){
				counter++;
			}
			//j.remove();
			
			System.out.println();
		}
		
		ListIterator<Integer> k = l.listIterator();
		while(k.hasNext()){
			System.out.println(k.next());
		}
		while(k.hasPrevious()){
			System.out.println(k.previous());
		}
		
		for(int i : l){
			System.out.println(i);
		}
		System.out.println("*******************************");
		//l.forEach((t)->System.out.println(t));
		ArrayList<Integer> salaryList = new ArrayList<>();
		salaryList.add(9000);
		salaryList.add(19000);
		salaryList.add(29000);
		salaryList.add(39000);
		salaryList.add(49000);
		Demo1 obj = new Demo1();
		salaryList.forEach(obj::printSalary);
		salaryList.forEach(Demo1::printSalary1);
//		for(int i = 0; i<salaryList.size(); i++){
//			obj.printSalary(salaryList.get(i));
//		}
		long sum = salaryList.stream().filter((x)->x>20000).mapToInt(y->y).sum();
		sum = salaryList.parallelStream().filter((x)->x>20000).mapToInt(y->y).sum();
		System.out.println(sum);
	}
	
static void printSalary1(int salary){
		
	}
	
	void printSalary(int salary){
		
	}

}
