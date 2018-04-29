import java.util.HashSet;

class Book{
	int id;
	String name;
	String author;
	Book(int id, String name, String author){
		this.id = id;
		this.name = name;
		this.author = author;
	}
	@Override
	public String toString(){
		return "Id "+id+" Name "+name+" Author "+author+"\n";
	}
	@Override
	public boolean equals(Object object){
		if(object == this){
			return true;
		}
		if(object instanceof Book){
			Book book = (Book)object;
			if(this.id == book.id && this.name.equals(book.name)){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode(){
		if(author.equalsIgnoreCase("jim")){
			return 10;
		}
		else
		if(author.equalsIgnoreCase("kim")){
			return 20;
		}
		else
			if(author.equalsIgnoreCase("vim")){
				return 30;
			}
		return 40;
	}
}
public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Book>  hs = new HashSet<>();
		
		hs.add(new Book(10,"C","kim"));
		hs.add(new Book(10,"C","kim"));
		hs.add(new Book(11,"C++","kim"));
		hs.add(new Book(11,"C++","kim"));
		hs.add(new Book(12,"C","Jim"));
		hs.add(new Book(12,"C","Jim"));
		System.out.println(hs);
		

	}

}
