 import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
	private Food fd1; 
	private Food fd2;
	private Electronics el1;
	private Electronics el2;
	private ArrayList<Food> foodList;
	private ArrayList<Electronics> electronicsList;
	@Before
	public void setUp() throws Exception {
		
		foodList = new ArrayList<Food>();
		fd1=new Food(1, "Noodles", "Noodle maker", 12, 11122020,2.40);
		fd2=new Food(25, "Rice", "Rice maker", 12, 11032020,2.50);
		electronicsList = new ArrayList<Electronics>();
		el1=new Electronics(21, "iPhone 102", "Apple inc", 12, 1254843141,1000,90);
		el2=new Electronics(51, "Philips monitor 2000", "Philips", 14, 1144145194,140,90);

	}
	@Test
	  public void addFoodTest() {
	    ArrayList<Food> foodList = new ArrayList<Food>();
	    // Item list is not null, so that can add a new item - boundary
	    assertNotNull("Check if there is valid Food arraylist to add to", foodList);
	    //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	    //The item just added is as same as the first item of the list
	    
	    Food fd=new Food(1, "Noodles", "Noodle maker", 12, 11122020,2.40);
	    C206_CaseStudy.addFood(foodList, fd);
	    assertEquals("Check that Food arraylist size is 1", 1, foodList.size());
	    assertSame("Check that Food is added", fd, foodList.get(0));
	    
	    //Add another item. test The size of the list is 2? -normal
	    //The item just added is as same as the second item of the list
	  //User input all the detail of the product then the system put it in the list (Normal)
	    Food fd1=new Food(25, "Rice", "Rice maker", 12, 11032020,2.50);
	    C206_CaseStudy.addFood(foodList, fd1);
	    assertEquals("Check that Food arraylist size is 2", 2, foodList.size());
	    assertSame("Check that Food is added", fd1, foodList.get(1));
	  }
	@Test
	  public void addEleTest() {
	    ArrayList<Electronics> electronicsList = new ArrayList<Electronics>();
	    // Item list is not null, so that can add a new item - boundary
	    assertNotNull("Check if there is valid Food arraylist to add to", electronicsList);
	    //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	    //The item just added is as same as the first item of the list
	    
	    Electronics el1=new Electronics(21, "iPhone 102", "Apple inc", 12, 1254843141,1000,90);
	    C206_CaseStudy.addEle(electronicsList, el1);
	    assertEquals("Check that electronics arraylist size is 1", 1, electronicsList.size());
	    assertSame("Check that electronics is added", el1, electronicsList.get(0));
	    
	    //Add another item. test The size of the list is 2? -normal
	    //The item just added is as same as the second item of the list
	  //User input all the detail of the product then the system put it in the list (Normal)
	    Electronics el2=new Electronics(51, "Philips monitor 2000", "Philips", 14, 1144145194,140,90);
	    C206_CaseStudy.addEle(electronicsList, el2);
	    assertEquals("Check that electronics arraylist size is 2", 2, electronicsList.size());
	    assertSame("Check that electronics is added", el2, electronicsList.get(1));
	  }
	@Test
	public void deletefoodtest() {
		ArrayList<Food> foodList = new ArrayList<Food>();
		//Product list cannot be null before deleting product (Boundary)
		assertNotNull("Check if there is valid Food arraylist to delete to from", foodList);

	}
	@Test
	public void deleteEletest() {
		ArrayList<Electronics> electronicsList = new ArrayList<Electronics>();
		//Product list cannot be null before deleting product (Boundary)
	 electronicsList.add(new Electronics(21, "iPhone 102", "Apple inc", 12, 1254843141,1000,90));
		assertNotNull("Check if there is valid Electronics arraylist to delete to from", electronicsList);
	}
	@Test
	public void Viewallfoodtest() {
		 ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new Food(1, "Noodles", "Noodle maker", 12, 11122020,2.40));
		String allfood= C206_CaseStudy.retrieveAllFoodProduct(foodList);
		foodList.clear();
		String testOutput = String.format(String.format("%-20d %-20s %-20s %-20d %-20d \n",1, "Noodles", "Noodle maker", 12, 11122020,2.40));
		assertSame("Test that viewFoodProduct", testOutput,allfood);
	}
	@Test
	public void	updateFoodtest() {
		//update product vendor name to “tom handling” for anyone of the product. (Normal)
		 ArrayList<Food> foodList = new ArrayList<Food>();
		 foodList.add(new Food(1, "Noodles", "Noodle maker", 12, 11122020,2.40));
		 C206_CaseStudy.updateFood(foodList);
		 assertEquals("Test to make sure that the production infomration is change to tom handling ", "tom handling", foodList.get(0).getVendor_name());
			//Product list cannot be null before updating product (Boundary)
		 foodList.add(new Food(211, "Noodles", "Noodle maker", 12, 11122020,2.40));
			assertNotNull("Check if there is valid food arraylist to delete to from", foodList);
	}
	
	@Test
	public void	updateEletest() {
		//update product vendor name to “tom handling” for anyone of the product. (Normal)
		ArrayList<Electronics> electronicsList = new ArrayList<Electronics>();
		 electronicsList.add(new Electronics(21, "iPhone 102", "Apple inc", 12, 1254843141,1000,90));
		 C206_CaseStudy.updateEle(electronicsList);
		 assertEquals("Test to make sure that the production infomration is change to tom handling ", "tom handling", electronicsList.get(0).getVendor_name());
			//Product list cannot be null before updating product (Boundary)
		 electronicsList.add(new Electronics(22, "iPhone 102", "Apple inc", 12, 1254843141,1000,90));
			assertNotNull("Check if there is valid Electronics arraylist to delete to from", electronicsList);
	}
	@Test
	public void	foodrefundcheckertest() {
		//When user key in food as product type when user key refund then will return true (Normal)
		assertTrue(C206_CaseStudy.foodrefundchecker());
		//key in other types of product other than food and electronics should return false. 
		assertFalse(C206_CaseStudy.foodrefundchecker());
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	

}


