
public class Outlet{
private int outlet_id;
private String outlet_name;
private String location;
public Outlet(int outlet_id, String outlet_name, String location) {
	super();
	this.outlet_id = outlet_id;
	this.outlet_name = outlet_name;
	this.location = location;
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
}