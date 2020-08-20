
public class Customer {
private int customer_id;
private String customer_name;
private int customer_contactNo;
private int reward_point;
	
public Customer(int customer_id, String customer_name, int customer_contactNo,int reward_point) {
	super();
	this.customer_id = customer_id;
	this.customer_name = customer_name;
	this.customer_contactNo = customer_contactNo;
	this.reward_point=reward_point;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public int getCustomer_contactNo() {
	return customer_contactNo;
}
public void setCustomer_contactNo(int customer_contactNo) {
	this.customer_contactNo = customer_contactNo;
}
public int getReward_point() {
	return reward_point;
}
public void setReward_point(int reward_point) {
	this.reward_point = reward_point;
}


}
