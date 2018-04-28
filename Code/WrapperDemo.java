
public class WrapperDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= "hello";
		String b = "hello";
		//System.out.println(a==b); 
		Integer x = 128;
		Integer y= 128;
		//System.out.println(x==y);
		Integer qq = 10;
		Integer vv =qq;
		System.out.println(qq==vv);
		Integer ww = qq++;
		System.out.println(ww==qq);
		System.out.println(ww.intValue()==qq.intValue());
		
	
	}

}
