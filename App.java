package Project.ProjectShopping;
import java.sql.*;
import java.util.*;

public class App {
 
    @SuppressWarnings("resource")
	public static void main(String args[]) throws Exception
    {
    	App appObj= new App();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("======WELCOME TO THE ONLINE SHOP======");
    	System.out.println("--------------------------------------");
    	System.out.println("Select your type:\n1.Admin\n2.Customer");
    	
    	boolean condition =true;
    	while(condition) {
    		int userType =  sc.nextInt();
    		switch (userType) {
    		case 1:
    			appObj.adminFn();
    			condition= false;
    			break;
    		case 2:
    			appObj.customerFn();
    			condition= false;
    			break;
    		default:
    			System.out.println("Select correct option..");
    		
    		}
    	} 	
    	//System.out.println("Program Finished!!");
    }
    
    //This method is for admin Operation
    public void adminFn() throws SQLException {
    		
    	System.out.println("\nYou Logged In as Admin. Please choose options:");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n~~~~~~~\n1. Add Product");
                System.out.println("2. View Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                System.out.print("\n");
                //scanner.nextLine(); // Consume newline
                ProductManagement productDoaObj = new ProductManagement();
                IOHelper ioObj = new IOHelper();
                
                switch (choice) {
                
                    case 1:
                    	System.out.println("Add product option Selected");
                    	Product product = ioObj.getProductDetails(sc);
                    	if(product != null)productDoaObj.addProduct(product);
                        break;
                        
                    case 2:
                    	System.out.println("View products option Selected");
                    	List<Product> productList = new ArrayList<Product>();
                    	productList=productDoaObj.getAllProductsList();
                    	ioObj.displayProducts(productList);
                        break;
                        
                    case 3:
                    	System.out.println("Update product option Selected");
                    	Product product1 = ioObj.getProductDetailsForUpdation(sc);
                    	if(product1 != null) productDoaObj.updateProduct(product1);
                        break;
                    case 4:
                    	System.out.println("Delete product option Selected");
                    	int id = ioObj.getProductIDForDeletion(sc);
                    	if(id != -1)productDoaObj.deleteProduct(id);
                        break;
                    case 5:
                        System.out.println("\n===== Bye, Have a Good Day!! =====\n");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }   
	}
    
    
    //method for customer Operations 
    public void customerFn() throws SQLException {
		
    		System.out.println("\nYou Logged In as Customer. Please choose options:");
            Scanner sc = new Scanner(System.in);
            ProductManagement productDoaObj = new ProductManagement();
            ShoppingCartUtility cartObj = new ShoppingCartUtility();
            IOHelper ioObj = new IOHelper();
            while (true) {
            	System.out.println("\n~~~~~~~~\nOptions-\n1. View all available products");
                System.out.println("2. Add product to cart");
                System.out.println("3. Remove item from cart");
                System.out.println("4. View Cart");
                System.out.println("5. Calculate Bill");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                System.out.print("\n");
                //scanner.nextLine(); // Consume newline
                
                switch (choice) {
                
                    case 1:
                    	System.out.println("View all available products option Selected");
                    	List<Product> productList = new ArrayList<Product>();
                    	productList=productDoaObj.getAllProductsList();
                    	ioObj.displayProducts(productList);
                        break;
                        
                    case 2:
                    	System.out.println("Add item to cart option Selected");
                    	Product product = ioObj.getProductDetailsForAddingToCart(sc);
                    	if(product != null) cartObj.addToCart(product);
                        break;
                        
                    case 3:
                    	System.out.println("Remove item from cart option Selected");
                    	Product product1 = ioObj.getProductDetailsForDeletion(sc);
                    	if(product1 != null) cartObj.removeFromCart(product1);
                        break;
                    case 4:
                    	System.out.println("View cart option Selected");
                    	cartObj.viewCart();
                        break;
                    case 5:
                    	System.out.println("Calculate Bill option Selected");
                    	cartObj.calculateBill();
                    case 6:
                        System.out.println("\n===== Thanks for Shopping, Have a Good Day!! =====\n");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }   
	}
    
    
} 
