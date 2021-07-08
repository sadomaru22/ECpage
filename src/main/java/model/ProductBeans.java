package model;
import java.io.Serializable;

public class ProductBeans  implements Serializable {
	
	private int id;
	private String name;
	private int price;
	private String exp;
	private String fileName;
	
	public ProductBeans() {}
	
	public ProductBeans(int id, String name, int price, String exp, String fileName) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.exp = exp;
		this.fileName = fileName;
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
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
