
public class Electronics extends Product {
	private int serial_number;

	public Electronics(int product_id, String product_name, String vendor_name, int quanity,int serial_number) {
		super(product_id, product_name, vendor_name, quanity);
		this.serial_number=serial_number;
	}

	public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public String toString(){//Code refactoring Done by Jia Wei
		String output = super.toString();
		// Write your codes here
		return String.format("%-60s %-20d", output,getSerial_number());
	}
	 
	

}
