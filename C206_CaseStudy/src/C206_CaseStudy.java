import java.util.ArrayList;
public class C206_CaseStudy {

	private static final int TRANSACTION_VIEWALL = 2;
	private static final int ARCHIVE_DATA = 3;
	private static final int OPTION_TRANSACTION = 4;
	private static final int OPTION_CUSTOMER = 3;
	private static final int OPTION_OUTLET = 2;
	private static final int VIEW_ALL = 3;
	private static final int DELETE = 2;
	private static final int ELECTRONICS = 2;
	private static final int FOOD = 1;
	private static final int ADD = 1;
	private static final int OPTION_QUIT = 5;
	public static void main(String[] args) {
		ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new Food(1, "Noodles", "Noodle maker", 12, 11122020));
		foodList.add(new Food(25, "Rice", "Rice maker", 12, 11032020));
		ArrayList<Electronics> electronicsList = new ArrayList<Electronics>();
		electronicsList.add(new Electronics(21, "iPhone 102", "Apple inc", 12, 1254843141));
		electronicsList.add(new Electronics(51, "Philips monitor 2000", "Philips", 14, 1144145194));
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(990812, "Yan Xin", 90944385, 0));
		customerList.add(new Customer(990252, "Tricia", 88750325, 0));
		ArrayList<Outlet> outletList = new ArrayList<Outlet>();
		outletList.add(new Outlet(1, "Store plaza sing", "Plaza singapore 72512"));
		outletList.add(new Outlet(2, "Store wood", "Wood singapore 745784"));
		ArrayList<Tracker> trackList= new ArrayList<Tracker>();
		ArrayList<Tracker> oldtrackList= new ArrayList<Tracker>();
		
		
		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// inventory
				C206_CaseStudy.Service_menu(option);
				int seroption = Helper.readInt("Enter service option > ");

				if (seroption == ADD) {
					// Add a product
					C206_CaseStudy.ITEMTYPE_MENU();
					int catenumber=Helper.readInt("Enter an option > ");
					if(catenumber==FOOD) {
						Food fd=inputFood();
						C206_CaseStudy.addFood(foodList, fd);	
					} else if(catenumber==ELECTRONICS){
						Electronics el=inputEle();
						C206_CaseStudy.addEle(electronicsList, el);
					}else {
						System.out.println("Invalid option");
					}
					
				} else if (seroption == DELETE) {
					// Delete product
					C206_CaseStudy.ITEMTYPE_MENU();
					int catenumber=Helper.readInt("Enter an option > ");
					if(catenumber==FOOD) {
						
						C206_CaseStudy.removeFood(foodList);	
					} else if (catenumber==ELECTRONICS){
					
						C206_CaseStudy.removeEle(electronicsList);
					}else {
						System.out.println("Invalid option");
					}

				}else if (seroption == VIEW_ALL) {
					// view all product
					C206_CaseStudy.ITEMTYPE_MENU();
					int catenumber=Helper.readInt("Enter an option > ");
					if(catenumber==1) {
						C206_CaseStudy.viewFoodProduct(foodList);	
					} else {
						C206_CaseStudy.viewEleProduct(electronicsList);
					}
					

				}
				else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_OUTLET) {
				//outlet
				C206_CaseStudy.Service_menu(option);
				int seroption = Helper.readInt("Enter service option > ");
			// Add a new outlet
				if (seroption == ADD) {
					// Add a outlet
						Outlet ou=inputOutlet();
						C206_CaseStudy.addOutlet(outletList, ou);	
				}else if (seroption == DELETE) {
					// Delete outlet							
						C206_CaseStudy.removeOutlet(outletList);	
					}else if (seroption == VIEW_ALL) {
						// view all outlet
					C206_CaseStudy.viewOutlet(outletList);	
					
					}
					else {
						System.out.println("Invalid type");
					}
						
				} else if (option == OPTION_CUSTOMER) {
				// Customer
					C206_CaseStudy.Service_menu(option);
					int seroption = Helper.readInt("Enter service option > ");
						if (seroption == ADD) {
							// Add a customer
								Customer cu=inputCustomer();
								C206_CaseStudy.addOutlet(customerList, cu);	
						}else if (seroption == DELETE) {
							// Delete customer							
								C206_CaseStudy.removeCustomer(customerList);	
							}else if (seroption == VIEW_ALL) {
								// view all customer
							C206_CaseStudy.viewCustomer(customerList);	
							
							}
							else {
								System.out.println("Invalid type");
							}

			} else if (option == OPTION_TRANSACTION) {
//				// Tracking 
				C206_CaseStudy.Service_menu(option);
				int seroption = Helper.readInt("Enter service option > ");
					if (seroption == ADD) {
						// Add a transaction
							Tracker tr=inputTransaction(customerList);
							C206_CaseStudy.addTransaction(trackList, tr);	
					}else if (seroption == TRANSACTION_VIEWALL) {
						// View Transaction							
							C206_CaseStudy.viewTransaction(trackList);	
						}else if (seroption == ARCHIVE_DATA) {
							// Archive old transactions
						C206_CaseStudy.archiveOldTransaction(trackList,oldtrackList);	
												
						}
						else {
							System.out.println("Invalid type");
						}
			}else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			}else {
				System.out.println("Invalid option");
			}

		}

	}
	public static void ITEMTYPE_MENU() {
		C206_CaseStudy.setHeader("PRODUCT CATEGORY");
		System.out.println("1. Food");
		System.out.println("2. Electronic");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("CUSTOMER RETURN TRACKING APP");
		System.out.println("1. Product Inventory");
		System.out.println("2. Outlet");
		System.out.println("3. Customer");
		System.out.println("4. Tracking");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	public static void Service_menu(int option) {
		C206_CaseStudy.setHeader("SERVICE TYPE");
		if(option==4) {
		System.out.println("1. Add");
		System.out.println("2. View All");
		System.out.println("3. Archive old transactions");
		}else {
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. View All");	
	}
	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
 }

//=================Option 1 Product===============================(Jia Wei)
	//=================Add===============================(Jia Wei)
	public static Food inputFood() {
		int product_id = Helper.readInt("Enter Product ID > ");
		String product_name = Helper.readString("Enter Product name > ");
		String vendor_name = Helper.readString("Enter vendor name > ");
		int quanity=Helper.readInt("Enter quanity >");
		int expiration_date=Helper.readInt("Enter expiration date in DDMMYYYY format >");
		
		Food fd= new Food(product_id, product_name, vendor_name, quanity, expiration_date);
		return fd;
		
	}
	public static void addFood(ArrayList<Food> foodList, Food fd) {
		
		foodList.add(fd);
		System.out.println("Food added");
	}
	
	public static Electronics inputEle() {
		int product_id = Helper.readInt("Enter Product ID > ");
		String product_name = Helper.readString("Enter Product name > ");
		String vendor_name = Helper.readString("Enter vendor name > ");
		int quanity=Helper.readInt("Enter quanity");
		int license_no=Helper.readInt("Enter serial number of the product >");
		
		Electronics el= new Electronics(product_id, product_name, vendor_name, quanity, license_no);
		return el;
		
	}
	public static void addEle(ArrayList<Electronics> electronicsList, Electronics el) {
		
		electronicsList.add(el);
		System.out.println("Electronic added");
	}
	//=================Delete===============================(Jia Wei)
	public static void removeFood(ArrayList<Food> foodList) {
	if(foodList.size()==0) {
		System.out.println("There is nothing to be deleted in the list.");
	}else {
	C206_CaseStudy.viewFoodProduct(foodList);
	int productpos = locateFood(foodList);
	String yes_no = confirmationFood(foodList, productpos);
	if (yes_no.equalsIgnoreCase("Yes")) {
		foodList.remove(productpos);
		System.out.println("Food has been deleted");
	}
	}
	}
	public static String confirmationFood(ArrayList<Food> foodList, int productpos) {
		String yes_no=Helper.readString("You sure want to delete "+foodList.get(productpos).getProduct_name()+" ? (Yes/No)>");
		return yes_no;
	}
	public static int locateFood(ArrayList<Food> foodList) {
		int product_id=Helper.readInt("Enter product ID that you want to remove >");
		int productpos=-1;
		for (int i=0;i<foodList.size();i++) {
			if (product_id==foodList.get(i).getProduct_id()) {
				productpos=i;
			}
		}
		return productpos;
	}
	
	public static void removeEle(ArrayList<Electronics> electronicsList) {
		if(electronicsList.size()==0) {
			System.out.println("There is nothing to be deleted in the list.");
		}else {
		C206_CaseStudy.viewEleProduct(electronicsList);
		int productpos = locateEle(electronicsList);
		String yes_no=Helper.readString("You sure want to delete "+electronicsList.get(productpos).getProduct_name()+" ? (Yes/No)>");
		if (yes_no.equalsIgnoreCase("Yes")) {
			electronicsList.remove(productpos);
			System.out.println("Electronics has been deleted");
		}
		}	
	}
	public static int locateEle(ArrayList<Electronics> electronicsList) {
		int product_id=Helper.readInt("Enter product ID that you want to remove >");
		int productpos=-1;
		for (int i=0;i<electronicsList.size();i++) {
			if (product_id==electronicsList.get(i).getProduct_id()) {
				productpos=i;
			}
		}
		return productpos;
	}
	//=================view all===============================(Jia Wei)
	public static String retrieveAllFoodProduct(ArrayList<Food> foodList) {
		String output="";
		for (int i = 0; i < foodList.size(); i++) {
			output += String.format("%-20d %-20s %-20d %-20d %-20s\n", foodList.get(i).getProduct_id(),
					foodList.get(i).getProduct_name(),foodList.get(i).getExpiration_date(), 
					foodList.get(i).getQuanity(),foodList.get(i).getVendor_name());
		}
		return output;
	}
	public static void viewFoodProduct(ArrayList<Food> foodList) {
		C206_CaseStudy.setHeader("FOOD LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "PRODUCT ID", "PRODUCT NAME",
				"EXPIRATION DATE", "QUANTITY","VENDOR");
		 output += retrieveAllFoodProduct(foodList);	
		System.out.println(output);
	}
	
	public static String retrieveAllEleProduct(ArrayList<Electronics> electronicsList) {
		String output="";
		for (int i = 0; i < electronicsList.size(); i++) {
			output += String.format("%-20d %-20s %-20d %-20d %-20s\n", electronicsList.get(i).getProduct_id(),
					electronicsList.get(i).getProduct_name(),electronicsList.get(i).getSerial_number(), 
					electronicsList.get(i).getQuanity(),electronicsList.get(i).getVendor_name());
		}
		return output;
	}
	public static void viewEleProduct(ArrayList<Electronics> electronicsList) {
		C206_CaseStudy.setHeader("ELECTRONIC LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "PRODUCT ID", "PRODUCT NAME",
				"SERIAL NUMBER", "QUANTITY","VENDOR");
		 output += retrieveAllEleProduct(electronicsList);	
		System.out.println(output);
	}
	
	//=================Option 2 Outlet===============================(Yan Xin)
	//=================Add===============================(Yan Xin)
	public static Outlet inputOutlet() {
		int outlet_id = Helper.readInt("Enter Outlet ID > ");
		String outlet_name = Helper.readString("Enter Outlet name > ");
		String location = Helper.readString("Enter Location > ");

		
		Outlet ou= new Outlet(outlet_id, outlet_name, location);
		return ou;
		
	}
	public static void addOutlet(ArrayList<Outlet> outletList, Outlet ou) {
		
		outletList.add(ou);
		System.out.println("Outlet added");
	}
	//=================Delete===============================(Yan Xin)
	public static void removeOutlet(ArrayList<Outlet> outletList) {
	if(outletList.size()==0) {
		System.out.println("There is nothing to be deleted in the list.");
	}else {
	C206_CaseStudy.viewOutlet(outletList);
	int outlet_id=Helper.readInt("Enter outlet ID that you want to remove >");
	int outletpos=-1;
	for (int i=0;i<outletList.size();i++) {
		if (outlet_id==outletList.get(i).getOutlet_id()) {
			outletpos=i;
		}
	}
	String yes_no=Helper.readString("You sure want to delete "+outletList.get(outletpos).getOutlet_name()+" ? (Yes/No)>");
	if (yes_no.equalsIgnoreCase("Yes")) {
		outletList.remove(outletpos);
		System.out.println("Outlet has been deleted");
	}
	}
	}
	//=================view all===============================(Yan Xin)
	public static String retrieveAllOutlet(ArrayList<Outlet> outletList) {
		String output="";
		for (int i = 0; i < outletList.size(); i++) {
			output += String.format("%-20d %-20s %-20s \n", outletList.get(i).getOutlet_id(),
					outletList.get(i).getOutlet_name(),outletList.get(i).getLocation());
		}
		return output;
	}
	public static void viewOutlet(ArrayList<Outlet> outletList) {
		C206_CaseStudy.setHeader("OUTLET LIST");
		String output = String.format("%-20s %-20s %-20s \n", "OUTLET ID", "OUTLET NAME",
				"LOCATION");
		 output += retrieveAllOutlet(outletList);	
		System.out.println(output);
	}
	//=================Option 3 Customer===============================(Cheryl)
	//=================Add====================================(Cheryl)
	public static Customer inputCustomer() {
		int customer_id = Helper.readInt("Enter Customer ID > ");
		String customer_name = Helper.readString("Enter Customer name > ");
		int customer_contactNo = Helper.readInt("Enter Customer contact number > ");
		int reward_point=Helper.readInt("Enter the reward code >");

		
		Customer cu=new Customer(customer_id, customer_name, customer_contactNo, reward_point);
		return cu;
		
	}
	public static void addOutlet(ArrayList<Customer> customerList, Customer cu) {
		
		customerList.add(cu);
		System.out.println("Customer added");
	}
	//=================Delete=================================(Cheryl)
	public static void removeCustomer(ArrayList<Customer> customerList) {
	if(customerList.size()==0) {
		System.out.println("There is nothing to be deleted in the list.");
	}else {
	C206_CaseStudy.viewCustomer(customerList);
	int customer_id=Helper.readInt("Enter customer ID that you want to remove >");
	int customerpos=-1;
	for (int i=0;i<customerList.size();i++) {
		if (customer_id==customerList.get(i).getCustomer_id()) {
			customerpos=i;
		}
	}
	String yes_no=Helper.readString("You sure want to delete "+customerList.get(customerpos).getCustomer_id()+" ? (Yes/No)>");
	if (yes_no.equalsIgnoreCase("Yes")) {
		customerList.remove(customerpos);
		System.out.println("Outlet has been deleted");
	}
	}
	}
	//=================view all===============================(Cheryl)
	public static String retrieveAllCustomer(ArrayList<Customer> customerList) {
		String output="";
		for (int i = 0; i < customerList.size(); i++) {
			output += String.format("%-20d %-20s %-20d %-20d \n", customerList.get(i).getCustomer_id(),
					customerList.get(i).getCustomer_name(),customerList.get(i).getCustomer_contactNo(),customerList.get(i).getReward_point());
		}
		return output;
	}
	public static void viewCustomer(ArrayList<Customer> customerList) {
		C206_CaseStudy.setHeader("CUSTOMER LIST");
		String output = String.format("%-20s %-20s %-20s %-20s \n", "CUSTOMER ID", "CUSTOMER NAME",
				"CONTACT NUMBER","REWARD POINT");
		 output += retrieveAllCustomer(customerList);	
		System.out.println(output);
	}
	//=================Option 4 Transaction===============================(Tricia)
	//=================Add====================================(Tricia)
	public static Tracker inputTransaction(ArrayList<Customer>customerList) {
		String customer_name = "";
		int customer_contactNo =0;
		int reward_point=0;
		int customer_id = Helper.readInt("Enter Customer ID > ");
		for (int i=0;i<customerList.size();i++) {
			if(customer_id==customerList.get(i).getCustomer_id()) {
			customer_name=customerList.get(i).getCustomer_name();
			reward_point=customerList.get(i).getReward_point();
			customer_contactNo=customerList.get(i).getCustomer_contactNo();
			}
		}
		int tracking_id=Helper.readInt("Enter the Tracking ID >");
		String tracking_type=Helper.readString("Enter the Tracking Type >");

		
		Tracker tr=new Tracker(customer_id, customer_name, customer_contactNo, reward_point, tracking_id, tracking_type);
		return tr;
		
	}
	public static void addTransaction(ArrayList<Tracker> trackList, Tracker tr) {
		
		trackList.add(tr);
		System.out.println("Transaction added");
	}
	//=================view all=================================(Tricia)
	public static String retrieveAllTransaction(ArrayList<Tracker> trackList) {
		String output="";
		for (int i = 0; i < trackList.size(); i++) {
			output += String.format("%-20d %-20s %-20d %-20d \n", trackList.get(i).getTracking_id(),trackList.get(i).getTracking_type(),trackList.get(i).getCustomer_id(),
					trackList.get(i).getCustomer_contactNo());
		}
		return output;
	}
	public static void viewTransaction(ArrayList<Tracker> trackList) {
		C206_CaseStudy.setHeader("TRANSACTION LIST");
		String output = String.format("%-20s %-20s %-20s %-20s \n", "TRACKING ID", "TRACKING TYPE",
				"CUSTOMER ID","CUSTOMER CONTACT NUMBER");
		 output += retrieveAllTransaction(trackList);	
		System.out.println(output);
	}
	//=================Archive old transactions===============================(Tricia)
	public static void archiveOldTransaction(ArrayList<Tracker> trackList,ArrayList<Tracker> oldtrackList) {
	if(trackList.size()==0) {
		System.out.println("There is nothing in the list to archive");
	}else {
		C206_CaseStudy.viewTransaction(trackList);
		String yes_no=Helper.readString("Are you sure you want archive old transaction? (Yes/No) >");
		if(yes_no.equalsIgnoreCase("Yes")) {
		for(int i=0;i<trackList.size();i++) {
		oldtrackList.add(oldtrackList.size(),trackList.get(i));
		}
		trackList.clear();
		System.out.println("List has been archived");
		}else {
			System.out.println("Going back to home page");
		}

			
	}
		
	}
	

}