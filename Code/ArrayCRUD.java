import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

class SortByName implements Comparator<Question>{
	@Override
	public int compare(Question first , Question second){
		return first.question.compareToIgnoreCase(second.question);
	}
}
class SortByScore implements Comparator<Question>{
	public int compare(Question first, Question second){
		return ((Integer)second.score).compareTo(first.score);
	}
}
class Question implements Comparable<Question>{
	int id;  // Integer id
	String question;
	String answers[] = new String[4];
	String rans;
	int score;
	@Override
	public int compareTo(Question object){
		//return this.question.compareTo(object.question);
		//return object.question.compareTo(this.question);
		//return this.question.compareToIgnoreCase(object.question);
		return ((Integer)this.id).compareTo(object.id);
	}
	@Override
	public boolean equals(Object object){
		if(this==object){
			return true;
		}
		else{
			if(object instanceof Question){
				Question ques = (Question) object; //Downcasting
				if(this.id== ques.id){
					return true;
				}
			}
		}
		return false;
	}
	Question(int id){
		this.id = id;
	}
	Question(int id , String name, String ans[], String rans, int score){
		this.id = id;
		this.question = name;
		this.answers = ans;
		this.rans =rans;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + Arrays.toString(answers) + ", rans="
				+ rans + ", score=" + score + "]";
	}
	
	
	
//	@Override
//	public String toString(){
//		String temp = "";
//		for(String ans : answers){
//			temp+=ans+" , ";
//		}
//		return "id "+id+" NAme "+question+" Ans"+temp+" Rans "+rans+" Score "+score;
//	}
	
}
class QuestionOperations{
	ArrayList<Question> questionList = new ArrayList<>();
	void add(Question question){
		questionList.add(question);
		System.out.println("Question Added..");
//		Object o = 100;
//		o = "Amit";
//		o = true;
//		o =90.10;
	}
	void traverse(){
//		for(int i = 0 ; i<questionList.size(); i++){
//			Question question = questionList.get(i);
//			System.out.println(question);
//		}
//		Iterator<Question> q = questionList.iterator();
//		while(q.hasNext()){
//			System.out.println(q.next());
//		}
//		ListIterator<Question> q = questionList.listIterator();
//		while(q.hasNext()){
//			System.out.println(q.next());
//		}
//		while(q.hasPrevious()){
//			System.out.println(q.previous());
//		}
//		for(Question question : questionList){
//			System.out.println(question);
//		}
		questionList.
		forEach(questionObject->System.out.println(questionObject));
	}
	int search(int id){
		Question question = new Question(id);
		System.out.println(questionList
				.contains(question)?"Found":"Not Found");
		return questionList.indexOf(question);
	}
	void update(int id){
		int index = search(id);
		if(index>=0){
			String ans[] = {"a","b","c","d"};
			questionList.set(index, new Question(id,"ABCD",ans,"a",4));
			traverse();
		}
	}
	void sort(){
		Collections.sort(questionList); // trigger Comparable
//		Collections.sort(questionList,new Comparator<Question>() {
//			public int compare(Question first, Question second){
//				return first.question.compareToIgnoreCase(second.question);
//			}
//		});
		Collections.sort(questionList,
				(first, second)->
		first.question.compareToIgnoreCase(second.question));
		//Collections.sort(questionList,new SortByName());
		//Collections.sort(questionList,new SortByScore());
		
	}
	void delete(int id){
		//Question question = new Question(id);
		//String result = questionList.remove(question)?"Deleted":"Not Deleted";
		//System.out.println(result);
		int index = search(id);
		if(index>=0){
			questionList.remove(index);
			traverse();
		}
	}
}
public class ArrayCRUD {
	static Scanner scanner = new Scanner(System.in);
	QuestionOperations qp = new QuestionOperations();
	public void menu(){
		while(true){
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. Search");
		System.out.println("4. Update");
		System.out.println("5. Sort");
		System.out.println("6. Traverse");
		System.out.println("7. Sum");
		System.out.println("8. Count");
		System.out.println("9. Exit");
		System.out.println("Enter the Choice ");
		int choice = scanner.nextInt();
		if(choice == 1){
			System.out.println("Enter the Question Id");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the Question Name");
			String name = scanner.nextLine();
			System.out.println("Enter the OptionA");
			String optionA = scanner.nextLine();
			System.out.println("Enter the OptionB");
			String optionB = scanner.nextLine();
			System.out.println("Enter the OptionC");
			String optionC = scanner.nextLine();
			System.out.println("Enter the OptionD");
			String optionD = scanner.nextLine();
			String answers[] = {optionA,optionB,optionC,optionD};
			System.out.println("Enter the Ans");
			String rans = String.valueOf(scanner.next().charAt(0)).toLowerCase();
			System.out.println("Enter the Score");
			int score = scanner.nextInt();
			Question question = new Question(id, name, answers, rans,score);
			qp.add(question);
		}
		else
		if(choice ==3){	
			System.out.println("Enter the Id to Search");
			qp.search(scanner.nextInt());
		}
		else
		if(choice ==6){	
			qp.traverse();
		}
		else{
			return ;
		}
		}
	}
	public static void main(String[] args) {
		ArrayCRUD obj = new ArrayCRUD();
		obj.menu();

	}

}
