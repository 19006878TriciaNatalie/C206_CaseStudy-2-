
public class Food extends Product {
private int expiration_date;

public Food(int product_id, String product_name, String vendor_name, int quanity,int expiration_date) {
	super(product_id, product_name, vendor_name, quanity);
	this.expiration_date=expiration_date;
}

public int getExpiration_date() {
	return expiration_date;
}

public void setExpiration_date(int expiration_date) {
	this.expiration_date = expiration_date;
}
public void display() {
	
}
public String toString(){//Code refactoring Done by Jia Wei
	String output = super.toString();
	// Write your codes here
	return String.format("%-60s %-20d", output,getExpiration_date());
}
}
