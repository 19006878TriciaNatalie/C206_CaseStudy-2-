
public class Outlet{
private int outlet_id;
private String outlet_name;
private String location;
private int Sales;
private int num_staff;
public Outlet(int outlet_id, String outlet_name, String location,int Sales,int num_staff) {
	this.outlet_id = outlet_id;
	this.outlet_name = outlet_name;
	this.location = location;
	this.Sales=Sales;
	this.num_staff=num_staff;
}
public int getOutlet_id() {
	return outlet_id;
}
public void setOutlet_id(int outlet_id) {
	this.outlet_id = outlet_id;
}
public String getOutlet_name() {
	return outlet_name;
}
public void setOutlet_name(String outlet_name) {
	this.outlet_name = outlet_name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getSales() {
	return Sales;
}
public void setSales(int sales) {
	Sales = sales;
}
public int getNum_staff() {
	return num_staff;
}
public void setNum_staff(int num_staff) {
	this.num_staff = num_staff;
}
public String toString() {//Code Refactoring Done by Yan Xin
	return String.format("%-20d %-20s %-25s %-20d %-20d", getOutlet_id(),getOutlet_name(),getLocation(),getSales(),getNum_staff(),getNum_staff());
}

}