
public class Product {
private int product_id;
private String product_name;
private String vendor_name;
private int quanity;
public Product(int product_id, String product_name, String vendor_name, int quanity) {
	super();
	this.product_id = product_id;
	this.product_name = product_name;
	this.vendor_name = vendor_name;
	this.quanity = quanity;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getVendor_name() {
	return vendor_name;
}
public void setVendor_name(String vendor_name) {
	this.vendor_name = vendor_name;
}
public int getQuanity() {
	return quanity;
}
public void setQuanity(int quanity) {
	this.quanity = quanity;
}


}
