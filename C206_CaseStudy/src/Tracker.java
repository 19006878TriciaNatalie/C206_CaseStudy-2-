public class Tracker extends Customer{
	private int tracking_id;
	private String tracking_type;



	public Tracker(int customer_id, String customer_name, int customer_contactNo, int reward_point, int tracking_id,
			String tracking_type) {
		super(customer_id, customer_name, customer_contactNo, reward_point);
		this.tracking_id = tracking_id;
		this.tracking_type = tracking_type;
	}


	public int getTracking_id() {
		return tracking_id;
	}

	public void setTracking_id(int tracking_id) {
		this.tracking_id = tracking_id;
	}

	public String getTracking_type() {
		return tracking_type;
	}

	public void setTracking_type(String tracking_type) {
		this.tracking_type = tracking_type;
	}
	

}
