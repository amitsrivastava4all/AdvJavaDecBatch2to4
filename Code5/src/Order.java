import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int id;
	private String name;
	private Date date;
	private ArrayList<Product> productList = new ArrayList<>();
	public Order(int id, String name, Date date, ArrayList<Product> productList) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.productList = productList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", date=" + date + ", productList=" + productList + "]";
	}
	

}
