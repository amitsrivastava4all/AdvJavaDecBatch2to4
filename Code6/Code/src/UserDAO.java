import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserDAO {
	static Connection createConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
		String driverName = rb.getString("driver");
		//String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);
		// Step - 2 Create Connection
		// jdbc:oracle:thin:@localhost:1521:SID
		//jdbc:mysql://localhost:3306/quizdb
		//String url = "jdbc:mysql://localhost:3306/quizdb";
		String url = rb.getString("url");
		String userid = rb.getString("userid");
		//Connection connection = DriverManager.getConnection(url,"root","");
		Connection connection = DriverManager.getConnection(url,userid,"");
		return connection;
	}
	static void insert() throws ClassNotFoundException, SQLException{
		final String SQL = "insert into user_mst (uid,userid,password)"
				+ " values(?,?,?)";
		Connection connection = createConnection();
		PreparedStatement pstmt = connection.prepareStatement(SQL);
		pstmt.setString(2, "rim");
		pstmt.setString(3, "123");
		pstmt.setInt(1, 40);
		int insertedRow = pstmt.executeUpdate();
		System.out.println(insertedRow>0?"Record Added...":"Not Added");
		pstmt.close();
		connection.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step - 1 Load the DB Driver
		// oracle.jdbc.driver.OracleDriver
		boolean isFound = false;
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter the Userid");
		String userid = scanner.nextLine();
		System.out.println("Enter the Password");
		String pwd  = scanner.nextLine();
		System.out.println("Enter the Uid");
		int uid = scanner.nextInt();
		System.out.println("Uid "+uid);
		//String uid = scanner.nextLine();
//		String driverName = "com.mysql.jdbc.Driver";
//		Class.forName(driverName);
//		// Step - 2 Create Connection
//		// jdbc:oracle:thin:@localhost:1521:SID
//		//jdbc:mysql://localhost:3306/quizdb
//		String url = "jdbc:mysql://localhost:3306/quizdb";
//		Connection connection = DriverManager.getConnection(url,"root","");
		//Statement stmt = connection.createStatement();
		Connection connection = createConnection();
		PreparedStatement pstmt = connection.prepareStatement("select uid,userid"
				+ ",password from user_mst where userid=?"
				+ " and password=? and uid=?");
		pstmt.setString(1, userid);
		pstmt.setString(2, pwd);
		pstmt.setInt(3, uid);
		//pstmt.setInt(3, Integer.parseInt(uid));
		ResultSet rs= pstmt.executeQuery();
		/*ResultSet rs = stmt.executeQuery("select uid, userid, "
				+ "password from user_mst where   "
						+ " userid='"+userid+"' and password='"+pwd+"'"
						+" and uid="+uid);*/
		while(rs.next()){
			isFound = true;
			System.out.println(rs.getString("userid")
					+" "+rs.getString("password")
					+" "+rs.getInt("uid"));
		}
		if(!isFound){
			System.out.println("No Record Found...");
		}
		rs.close();
		pstmt.close();
		connection.close();
		insert();
		//		if(connection!=null){
//			System.out.println("Connection Created...");
//			connection.close();
//		}
	}
}






