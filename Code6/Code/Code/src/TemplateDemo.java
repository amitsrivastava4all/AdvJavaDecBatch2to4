import java.util.ArrayList;
class Stack<T extends Number>{
	T data;
	ArrayList<T> list = new ArrayList<>();
	void push(T d){
		this.data= d;
		list.add(data);
	}
	void peep(){
		for(T d : list){
			System.out.println(d);
		}
	}
}
public class TemplateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stack<String> stack = new Stack<>();
		//stack.push("Hello");
		//stack.push("Hello2");
		//stack.peep();
		
		Stack<Integer> intStack = new Stack<>();
	}

}
