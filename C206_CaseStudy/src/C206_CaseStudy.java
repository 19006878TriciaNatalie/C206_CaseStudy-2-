import java.util.ArrayList;
public class C206_CaseStudy {

	private static final int UPDATE_PRODUCT = 4;
	private static final int TOP_SALES = 4;//Code Refactoring done by Jia Wei
	private static final int TOP_REWARD_POINT = 4;//Code Refactoring done by Jia Wei
	private static final int OPTION_INVENTORY = 1;//Code Refactoring done by Jia Wei
	private static final int TRANSACTION_VIEWALL = 2;//Code Refactoring done by Jia Wei
	private static final int ARCHIVE_DATA = 3;//Code Refactoring done by Jia Wei
	private static final int OPTION_TRANSACTION = 4;//Code Refactoring done by Jia Wei
	private static final int OPTION_CUSTOMER = 3;//Code Refactoring done by Jia Wei
	private static final int OPTION_OUTLET = 2;//Code Refactoring done by Jia Wei
	private static final int VIEW_ALL = 3;//Code Refactoring done by Jia Wei
	private static final int DELETE = 2;//Code Refactoring done by Jia Wei
	private static final int ELECTRONICS = 2;//Code Refactoring done by Jia Wei
	private static final int FOOD = 1;//Code Refactoring done by Jia Wei
	private static final int ADD = 1;//Code Refactoring done by Jia Wei
	private static final int OPTION_QUIT = 5;//Code Refactoring done by Jia Wei
	public static void main(String[] args) {
		ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new Food(1, "Noodles", "Noodle maker", 12, 11122020,2.40));
		foodList.add(new Food(25, "Rice", "Rice maker", 12, 11032020,2.50));
		ArrayList<Electronics> electronicsList = new ArrayList<Electronics>();
		electronicsList.add(new Electronics(21, "iPhone 102", "Apple inc", 12, 1254843141,1000,90));
		electronicsList.add(new Electronics(51, "Philips monitor 2000", "Philips", 14, 1144145194,140,90));
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(990812, "Yan Xin", 90944385, 0,0,0));
		customerList.add(new Customer(990252, "Tricia", 88750325, 1,1,1));
		ArrayList<Outlet> outletList = new ArrayList<Outlet>();
		outletList.add(new Outlet(1, "Store plaza sing", "Plaza singapore 72512",1140,5));
		outletList.add(new Outlet(2, "Store wood", "Wood singapore 745784",1100,4));
		ArrayList<Tracker> trackList= new ArrayList<Tracker>();
		trackList.add(new Tracker(990252, "Tricia", 88750325, 1, 1, "Return", 1,1));
		ArrayList<Tracker> oldtrackList= new ArrayList<Tracker>();
		
		
		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_INVENTORY) {
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
					

				}else if(seroption == UPDATE_PRODUCT) {
					C206_CaseStudy.ITEMTYPE_MENU();
					int catenumber=Helper.readInt("Enter an option > ");
					if(catenumber==1) {
						C206_CaseStudy.updateFood(foodList);	
					} else {
						C206_CaseStudy.updateEle(electronicsList);
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
					
					}else if(seroption==TOP_SALES) {
						C206_CaseStudy.topSales(outletList);
					}else if(seroption==5) {
						C206_CaseStudy.updateOutlet(outletList);
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
							
							}else if (seroption ==TOP_REWARD_POINT){
								C206_CaseStudy.topRewardPoint(customerList);
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
							
						C206_CaseStudy.addTransaction(customerList,trackList);	
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
		if(option==OPTION_TRANSACTION) {
		System.out.println("1. Add");
		System.out.println("2. View All");
		System.out.println("3. Archive old transactions");
		}else if (option==OPTION_OUTLET){
			System.out.println("1. Add");
			System.out.println("2. Delete");
			System.out.println("3. View All");
			System.out.println("4. View Top Sales");
			System.out.println("5. Update Store Detail");
		}else  if (option==OPTION_CUSTOMER){
			System.out.println("1. Add");
			System.out.println("2. Delete");
			System.out.println("3. View All");
			System.out.println("4. View Top Customer Reward Point");
		}else {
		
		System.out.println("1. Add");
		System.out.println("2. Delete");
		System.out.println("3. View All");
		System.out.println("4.Update Product ");
	}
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
 }

//=================Option 1 Product===============================(Jia Wei)
	//=================Add===============================(Jia Wei)
	public static Food inputFood() { //Code Refactoring done by Jia Wei
		int product_id = Helper.readInt("Enter Product ID > ");
		String product_name = Helper.readString("Enter Product name > ");
		String vendor_name = Helper.readString("Enter vendor name > ");
		int quantity=Helper.readInt("Enter quantity >");
		int expiration_date=Helper.readInt("Enter expiration date in DDMMYYYY format >");
		double price=Helper.readDouble("Enter the price of the product >");
		
		Food fd= new Food(product_id, product_name, vendor_name, quantity, expiration_date,price);
		return fd;
		
	}
	public static void addFood(ArrayList<Food> foodList, Food fd) {  //Code Refactoring done by Jia Wei
		
		foodList.add(fd);
		System.out.println("Food added");
	}
	
	public static Electronics inputEle() {//Code Refactoring done by Jia Wei
		int product_id = Helper.readInt("Enter Product ID > ");
		String product_name = Helper.readString("Enter Product name > ");
		String vendor_name = Helper.readString("Enter vendor name > ");
		int quantity=Helper.readInt("Enter quantity");
		int license_no=Helper.readInt("Enter serial number of the product >");
		double price=Helper.readDouble("Enter the price of the product >");
		int days_return=Helper.readInt("Enter number days return for the product >");
		Electronics el= new Electronics(product_id, product_name, vendor_name, quantity, license_no,price,days_return);
		return el;
		
	}
	public static void addEle(ArrayList<Electronics> electronicsList, Electronics el) {//Code Refactoring done by Jia Wei
		
		electronicsList.add(el);
		System.out.println("Electronic added");
	}
	//=================Delete===============================(Jia Wei)
	public static void removeFood(ArrayList<Food> foodList) {//Code Refactoring done by Jia Wei
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
	public static String confirmationFood(ArrayList<Food> foodList, int productpos) {//Code Refactoring done by Jia Wei
		String yes_no=Helper.readString("You sure want to delete "+foodList.get(productpos).getProduct_name()+" ? (Yes/No)>");
		return yes_no;
	}
	public static int locateFood(ArrayList<Food> foodList) {//Code Refactoring done by Jia Wei
		int product_id=Helper.readInt("Enter product ID that you want to remove >");
		int productpos=-1;
		for (int i=0;i<foodList.size();i++) {
			if (product_id==foodList.get(i).getProduct_id()) {
				productpos=i;
			}else {
				productpos=-1;
			}
		}
		return productpos;
	}
	
	public static void removeEle(ArrayList<Electronics> electronicsList) {//Code Refactoring done by Jia Wei
		if(electronicsList.size()==0) {
			System.out.println("There is nothing to be deleted in the list.");
		}else {
		C206_CaseStudy.viewEleProduct(electronicsList);
		int productpos = locateEle(electronicsList);
		String yes_no = confirmationEle(electronicsList, productpos);
		if (yes_no.equalsIgnoreCase("Yes")) {
			electronicsList.remove(productpos);
			System.out.println("Electronics has been deleted");
		}
		}	
	}
	public static String confirmationEle(ArrayList<Electronics> electronicsList, int productpos) {//Code Refactoring done by Jia Wei
		String yes_no=Helper.readString("You sure want to delete "+electronicsList.get(productpos).getProduct_name()+" ? (Yes/No)>");
		return yes_no;
	}
	public static int locateEle(ArrayList<Electronics> electronicsList) {//Code Refactoring done by Jia Wei
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
	public static String retrieveAllFoodProduct(ArrayList<Food> foodList) {//Code refactoring done by Jia Wei
		String output="";
		for (int i = 0; i < foodList.size(); i++) {
			output += String.format("%-120s\n", foodList.get(i).toString());//Code refactoring done by Jia Wei
		}
		return output;
	}
	public static void viewFoodProduct(ArrayList<Food> foodList) {//Code refactoring done by Jia Wei
		C206_CaseStudy.setHeader("FOOD LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "PRODUCT ID", "PRODUCT NAME", "QUANTITY","VENDOR",
				"EXPIRATION DATE","PRICE");
		 output += retrieveAllFoodProduct(foodList);	
		System.out.println(output);
	}
	
	public static String retrieveAllEleProduct(ArrayList<Electronics> electronicsList) {//Code refactoring done by Jia Wei
		String output="";
		for (int i = 0; i < electronicsList.size(); i++) {
			output += String.format("%-140s\n", electronicsList.get(i).toString());//Code refactoring done by Jia Wei
		}
		return output;
	}
	public static void viewEleProduct(ArrayList<Electronics> electronicsList) {//Code refactoring done by Jia Wei
		C206_CaseStudy.setHeader("ELECTRONIC LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "PRODUCT ID", "PRODUCT NAME",
				"SERIAL NUMBER", "QUANTITY","VENDOR","PRICE","DAYS OF RETURN");
		 output += retrieveAllEleProduct(electronicsList);	
		System.out.println(output);
	}
	
	//=================Update product===============================(Jia Wei)
	public static void updateFood(ArrayList<Food> foodList) {
		C206_CaseStudy.viewFoodProduct(foodList);
		int productid=Helper.readInt("Enter product ID of the one you would like to update >");
		boolean productexist=false;
		int productpos=-1;
		for (int i=0;i<foodList.size();i++) {
			if(productid==foodList.get(i).getProduct_id()) {
				productexist=true;
				productpos=i;
			}
		}
		if (productexist) {
			C206_CaseStudy.setHeader("UPDATE OPTION");
			System.out.println("1.Name of product");
			System.out.println("2.Product expiration date");
			System.out.println("3.Product price");
			System.out.println("4.Product quantity");
			System.out.println("5.Product vendor name");
			int updateOption=Helper.readInt("Enter update option >");
			if(updateOption==1) {
				foodList.get(productpos).setProduct_name(Helper.readString("Enter the updated product name >"));
			}else if(updateOption==2) {
				foodList.get(productpos).setExpiration_date(Helper.readInt("Enter the updated product expiration >"));
			}else if (updateOption==3) {
				foodList.get(productpos).setPrice(Helper.readInt("Enter the updated price >"));
			}else if (updateOption==4) {
				foodList.get(productpos).setQuanity(Helper.readInt("Enter the new quantity of product >"));
			}else if (updateOption==5) {
				foodList.get(productpos).setVendor_name(Helper.readString("Enter updated vendor name >"));
			}else {
				System.out.println("Invalid option");
				System.out.println("Returning to homepage");
			}
		}else {
			System.out.println("This product ID is not valid");
			System.out.println("Returning to homepage");
		}
	}
	

	public static void updateEle(ArrayList<Electronics> electronicsList) {
		C206_CaseStudy.viewEleProduct(electronicsList);
		int productid=Helper.readInt("Enter product ID of the one you would like to update >");
		boolean productexist=false;
		int productpos=-1;
		for (int i=0;i<electronicsList.size();i++) {
			if(productid==electronicsList.get(i).getProduct_id()) {
				productexist=true;
				productpos=i;
			}
		}
		if (productexist) {
			C206_CaseStudy.setHeader("UPDATE OPTION");
			System.out.println("1.Name of product");
			System.out.println("2.Product serial number");
			System.out.println("3.Product price");
			System.out.println("4.Product quantity");
			System.out.println("5.Product vendor name");
			int updateOption=Helper.readInt("Enter update option >");
			if(updateOption==1) {
				electronicsList.get(productpos).setProduct_name(Helper.readString("Enter the updated product name >"));
			}else if(updateOption==2) {
				electronicsList.get(productpos).setSerial_number(Helper.readInt("Enter the updated product serial number >"));
			}else if (updateOption==3) {
				electronicsList.get(productpos).setPrice(Helper.readInt("Enter the updated price >"));
			}else if (updateOption==4) {
				electronicsList.get(productpos).setQuanity(Helper.readInt("Enter the new quantity of product >"));
			}else if (updateOption==5) {
				electronicsList.get(productpos).setVendor_name(Helper.readString("Enter updated vendor name >"));
			}else {
				System.out.println("Invalid option");
				System.out.println("Returning to homepage");
			}
		}else {
			System.out.println("This product ID is not valid");
			System.out.println("Returning to homepage");
		}
	}
	
	//=================Item checker===============================(Jia Wei)
	public static boolean foodrefundchecker () {
		String product_type=Helper.readString("Enter the product type >");
		if (product_type.equalsIgnoreCase("Food")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	//=================Option 2 Outlet===============================(Yan Xin)
	//=================Add===============================(Yan Xin)
	public static Outlet inputOutlet() {//Code refactoring done by Yan Xin
		int outlet_id = Helper.readInt("Enter Outlet ID > ");
		String outlet_name = Helper.readString("Enter Outlet name > ");
		String location = Helper.readString("Enter Location > ");
		int Sales=0;
		int num_staff=Helper.readInt("Enter the number of staff in the outlet > ");

		
		Outlet ou= new Outlet(outlet_id, outlet_name, location,Sales,num_staff);
		return ou;
		
	}
	public static void addOutlet(ArrayList<Outlet> outletList, Outlet ou) {//Code refactoring done by Yan Xin
		
		outletList.add(ou);
		System.out.println("Outlet added");
	}
	//=================Delete===============================(Yan Xin)
	public static void removeOutlet(ArrayList<Outlet> outletList) {
	if(outletList.size()==0) {
		System.out.println("There is nothing to be deleted in the list.");
	}else {
	C206_CaseStudy.viewOutlet(outletList);
	int outletpos = locateOutlet(outletList);
	String yes_no = confirmationOulet(outletList, outletpos);
	if (yes_no.equalsIgnoreCase("Yes")) {
		outletList.remove(outletpos);
		System.out.println("Outlet has been deleted");
	}
	}
	}
	public static String confirmationOulet(ArrayList<Outlet> outletList, int outletpos) { //Code refactoring done by Yan Xin
		String yes_no=Helper.readString("You sure want to delete "+outletList.get(outletpos).getOutlet_name()+" ? (Yes/No)>");
		return yes_no;
	}
	public static int locateOutlet(ArrayList<Outlet> outletList) {//Code refactoring done by Yan Xin
		int outlet_id=Helper.readInt("Enter outlet ID that you want to remove >");
		int outletpos=-1;
		for (int i=0;i<outletList.size();i++) {
			if (outlet_id==outletList.get(i).getOutlet_id()) {
				outletpos=i;
			}
		}
		return outletpos;
	}
	//=================view all===============================(Yan Xin)
	public static String retrieveAllOutlet(ArrayList<Outlet> outletList) {
		String output="";
		for (int i = 0; i < outletList.size(); i++) {
			output += String.format("%-80s\n", outletList.get(i).toString());//Code refactoring done by Yan Xin
		}
		return output;
	}
	public static void viewOutlet(ArrayList<Outlet> outletList) {
		C206_CaseStudy.setHeader("OUTLET LIST");
		String output = String.format("%-20s %-20s %-25s %-20s %-20s\n", "OUTLET ID", "OUTLET NAME",
				"LOCATION","SALES($)","NUMBER OF STAFF");
		 output += retrieveAllOutlet(outletList);	
		System.out.println(output);
	}
	//=================Top Sales outlet===============================(Yan Xin)
	public static void topSales(ArrayList<Outlet> outletList) {
		int toppoint=0;
		for (int i=0;i<outletList.size();i++) {
			if(toppoint<outletList.get(i).getSales()) {
				toppoint=outletList.get(i).getSales();
				}
		}
		if(toppoint==0) {
			System.out.println("There is no outlet with the highest Sales ");
		}else {
			setHeader("OUTLET WITH HIGHEST SALES");
			String output = String.format("%-20s %-20s %-25s %-20s %-20s \n", "OUTLET ID", "OUTLET NAME",
					"LOCATION","SALES($)","NUMBER OF STAFF");
			for(int z=0;z<outletList.size();z++) {
				if(toppoint==outletList.get(z).getSales())
				output += String.format("%-105s\n", outletList.get(z).toString());
			}
			System.out.println(output);
		}
		
		
	}
	
	//=======================Update Outlet information========================(Yan Xin)
	public static void updateOutlet(ArrayList<Outlet> outletList) {
		C206_CaseStudy.viewOutlet(outletList);
		boolean outletexist=false;
		int outletpos=-1;
		int outletid=Helper.readInt("Enter the outlet ID > ");
		for (int i=0;i<outletList.size();i++) {
			if(outletid==outletList.get(i).getOutlet_id()) {
				outletexist=true;
				outletpos=i;
			}
		}
		if (outletexist) {
			C206_CaseStudy.setHeader("UPDATE OPTION");
			System.out.println("1.Name of outlet");
			System.out.println("2.Location of outlet");
			System.out.println("3.Sales Amount for the outlet");
			System.out.println("4.Number of staff in the outlet");
			int updateOption=Helper.readInt("Enter update option >");
			if(updateOption==1) {
				outletList.get(outletpos).setOutlet_name(Helper.readString("Enter the updated outlet name >"));
			}else if(updateOption==2) {
				outletList.get(outletpos).setLocation(Helper.readString("Enter the updated outlet location >"));
			}else if (updateOption==3) {
				outletList.get(outletpos).setSales(Helper.readInt("Enter the updated sales >"));
			}else if (updateOption==4) {
				outletList.get(outletpos).setNum_staff(Helper.readInt("Enter the new number of staff in outlet >"));
			}else {
				System.out.println("Invalid option");
				System.out.println("Returning to homepage");
			}
		}else {
			System.out.println("This outlet ID is not valid");
			System.out.println("Returning to homepage");
		}
	}
	
	
	
	
	
	//=================Option 3 Customer===============================(Cheryl)
	//=================Add====================================(Cheryl)
	public static Customer inputCustomer() {//Code Refactoring Done by Cheryl
		int customer_id = Helper.readInt("Enter Customer ID > ");
		String customer_name = Helper.readString("Enter Customer name > ");
		int customer_contactNo = Helper.readInt("Enter Customer contact number > ");
		int reward_point=Helper.readInt("Enter the reward point >");
		int number_transaction=0;
		int number_return=0;
		
		Customer cu=new Customer(customer_id, customer_name, customer_contactNo, reward_point,number_transaction,number_return);
		return cu;
		
	}
	public static void addOutlet(ArrayList<Customer> customerList, Customer cu) {//Code Refactoring Done by Cheryl
		
		customerList.add(cu);
		System.out.println("Customer added");
	}
	//=================Delete=================================(Cheryl)
	public static void removeCustomer(ArrayList<Customer> customerList) {
	if(customerList.size()==0) {
		System.out.println("There is nothing to be deleted in the list.");
	}else {
	int customerpos = locateCustomer(customerList);
	String yes_no = confirmationCustomer(customerList, customerpos);
	if (yes_no.equalsIgnoreCase("Yes")) {
		customerList.remove(customerpos);
		System.out.println("Outlet has been deleted");
	}
	}
	}
	public static int locateCustomer(ArrayList<Customer> customerList) {//Code Refactoring Done by Cheryl
		C206_CaseStudy.viewCustomer(customerList);
		int customer_id=Helper.readInt("Enter customer ID that you want to remove >");
		int customerpos=-1;
		for (int i=0;i<customerList.size();i++) {
			if (customer_id==customerList.get(i).getCustomer_id()) {
				customerpos=i;
			}
		}
		return customerpos;
	}
	public static String confirmationCustomer(ArrayList<Customer> customerList, int customerpos) {//Code Refactoring Done by Cheryl
		String yes_no=Helper.readString("You sure want to delete "+customerList.get(customerpos).getCustomer_id()+" ? (Yes/No)>");
		return yes_no;
	}
	//=================view all===============================(Cheryl)
	public static String retrieveAllCustomer(ArrayList<Customer> customerList) {//Code Refactoring Done by Cheryl
		String output="";
		for (int i = 0; i < customerList.size(); i++) {
			output += String.format("%-120s \n", customerList.get(i).toString());
		}
		return output;
	}
	public static void viewCustomer(ArrayList<Customer> customerList) {//Code Refactoring Done by Cheryl
		C206_CaseStudy.setHeader("CUSTOMER LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "CUSTOMER ID", "CUSTOMER NAME",
				"CONTACT NUMBER","REWARD POINT","NUMBER TRANSACTION","NUMBER RETURNS");
		 output += retrieveAllCustomer(customerList);	
		System.out.println(output);
	}
	//=================Top Reward Points===============================(Cheryl)
	public static void topRewardPoint(ArrayList<Customer> customerList) {
		int toppoint=0;
		for (int i=0;i<customerList.size();i++) {
			if(toppoint<customerList.get(i).getReward_point()) {
				toppoint=customerList.get(i).getReward_point();
				}
		}
		if(toppoint==0) {
			System.out.println("There is no customer with the highest reward point ");
		}else {
			setHeader("CUSTOMER WITH HIGHEST REWARD POINT");
			String output = String.format("%-20s %-20s %-20s %-20s %-20s \n", "CUSTOMER ID", "CUSTOMER NAME",
					"CONTACT NUMBER","REWARD POINT","NUMBER TRANSACTION","NUMBER RETURN");
			for(int z=0;z<customerList.size();z++) {
				if(toppoint==customerList.get(z).getReward_point())
				output += String.format("%-100s\n", customerList.get(z).toString());
			}
			System.out.println(output);
		}
		
		
	}
	
	
	//=================Option 4 Transaction===============================(Tricia)
	//=================Add====================================(Tricia)
	public static void addTransaction(ArrayList<Customer>customerList,ArrayList<Tracker> trackList) {
		boolean acceptance=false;
		String customer_name = "";
		int customer_contactNo =0;
		int reward_point=0;
		int number_transaction=0;
		int number_return=0;
		boolean customerexist=false;
		int customerpos=-1;
				int customer_id = Helper.readInt("Enter Customer ID > ");
		for (int i=0;i<customerList.size();i++) {
			if(customer_id==customerList.get(i).getCustomer_id()) {
			customer_name=customerList.get(i).getCustomer_name();
			reward_point=customerList.get(i).getReward_point();
			customer_contactNo=customerList.get(i).getCustomer_contactNo();
			number_transaction=customerList.get(i).getNumber_transaction();
			customerList.get(i).setNumber_transaction(number_transaction+1);
			number_return=customerList.get(i).getNumber_return();
			customerpos=1;
			customerexist=true;
			break;
			}
		}
		
		if(customerexist) {
		int tracking_id=Helper.readInt("Enter the Tracking ID >");
		for(int z=0;z<trackList.size();z++) {
			if(trackList.get(z).getTracking_id()==tracking_id) {
				System.out.println("Tracking ID existed key another one");
				tracking_id=Helper.readInt("Enter the Tracking ID >");
			}else {
				break;
			}
		}
		String tracking_type=Helper.readString("Enter the Tracking Type >");
		if (tracking_type.equalsIgnoreCase("Return")) {
			customerList.get(customerpos).setNumber_return(number_return+1);
		}else if(tracking_type.equalsIgnoreCase("Refund")) {
			acceptance=C206_CaseStudy.foodrefundchecker();
		}
		number_transaction=number_transaction+1;
		if(acceptance==false) {
		trackList.add(new Tracker(customer_id, customer_name, customer_contactNo, reward_point, tracking_id, tracking_type, number_transaction,number_return));
		System.out.println("Transaction added");
		}else {
			System.out.println("Food is not refundable ");
		System.out.println("Returning to home page ");
		}
		}else {
			System.out.println("This customer does not exist");
		}
		
			
	}
	
		

	//=================view all=================================(Tricia)
	public static String retrieveAllTransaction(ArrayList<Tracker> trackList) {//Code refactoring Done by Tricia
		String output="";
		for (int i = 0; i < trackList.size(); i++) {
			output += String.format("%-80s \n", trackList.get(i).toString());//Code refactoring Done by Tricia
		}
		return output;
	}
	public static void viewTransaction(ArrayList<Tracker> trackList) {//Code refactoring Done by Tricia
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
		String yes_no = confimationTransaction();
		if(yes_no.equalsIgnoreCase("Yes")) {
		movingToArchivelist(trackList, oldtrackList);
		}else {
			System.out.println("Going back to home page");
		}

			
	}
		
	}
	public static String confimationTransaction() {//Code refactoring Done by Tricia
		String yes_no=Helper.readString("Are you sure you want archive old transaction? (Yes/No) >");
		return yes_no;
	}
	public static void movingToArchivelist(ArrayList<Tracker> trackList, ArrayList<Tracker> oldtrackList) {//Code refactoring Done by Tricia
		for(int i=0;i<trackList.size();i++) {
		oldtrackList.add(oldtrackList.size(),trackList.get(i));
		}
		trackList.clear();
		System.out.println("List has been archived");
	}
	

}