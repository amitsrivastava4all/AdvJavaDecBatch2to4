import java.util.NavigableSet;
import java.util.TreeSet;

interface List{
	void add();
}
class ArrayList implements List{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Add Call");
	}
	void remove(){
		System.out.println("Remove Call");
	}
	
}
class Vector implements List{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Vector add");
	}
	void print(){
		System.out.println("Vector Print..");
	}
	
}
public class NavigableDemo {
	
	 static void operations(List list){
		list.add();
		//list.remove();
		//list.print();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		operations(new ArrayList());
		operations(new Vector());
		//HashSet s = new HashSet();
		//Set<Integer> s = new HashSet<>();
		NavigableSet<Integer> s = new TreeSet<>(); 
		s.add(21);
		s.add(50);
		s.add(1);
		s.add(10);
		s.add(20);
		System.out.println(s.lower(20)); //<
		System.out.println(s.higher(21)); //>
		System.out.println(s.ceiling(50));  //>=
		System.out.println(s.floor(10)); //<=
		
		//s.remove(1);
		

	}

}
