
public class Electronics extends Product {
	private int serial_number;
	private int days_return;
	public Electronics(int product_id, String product_name, String vendor_name, int quanity,int serial_number,double price,int days_return) {
		super(product_id, product_name, vendor_name, quanity,price);
		this.serial_number=serial_number;
		this.days_return=days_return;
	}

	public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public int getDays_return() {
		return days_return;
	}

	public void setDays_return(int days_return) {
		this.days_return = days_return;
	}

	public String toString(){//Code refactoring Done by Jia Wei
		String output = super.toString();
		return String.format("%-100s %-20d %-20d", output,getSerial_number(),getDays_return());
	}
	 
	

}
