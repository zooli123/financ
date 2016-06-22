package beans;

public class Category {
	private int id;
	private String name;
	private boolean positive;
	
	public Category(){}
	public Category(String name, boolean positive)
	{
		this.name = name;
		this.positive = positive;
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
	public boolean isPositive() {
		return positive;
	}
	public void setPositive(boolean positive) {
		this.positive = positive;
	}
	
	
}
