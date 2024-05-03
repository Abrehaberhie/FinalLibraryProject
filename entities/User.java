package entities;




public class User {
	
	private int id;
	
	private String name;
    private int age;
    private double rating;
	public User() {
		super();
		
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", age=" + age + ", rating=" + rating + "]";
}
	   

}
