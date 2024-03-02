package Project.ProjectShopping;

import java.util.List; 
import java.util.Scanner;

public class IOHelper {
	public void displayProducts(List<Product> list) {
    	if(list.isEmpty()) {
    		System.out.println("Products are not uploaded yet!");
    	}
    	else {
    		System.out.println("Id        Name                  Price");
    		System.out.println("````````````````````````````````````````");
    		for(Product x:list) {
    			String outStr = x.getId()+" ";
    			//System.out.println(x.getId()+"       "+x.getName());
    			while(outStr.length()<=9) {
    				outStr+=" ";
    			}
    			outStr += x.getName();
    			while(outStr.length()<=30) {
    				outStr+=" ";
    			}
    			outStr+="$"+x.getPrice();
    			System.out.println(outStr);
    		}
    	}
    }
	
	public Product getProductDetails(Scanner sc) {
		System.out.print("Enter product ID: ");
	    int id = sc.nextInt();
	    
	    if(idExistsInTable(id)) {
	    	System.out.println("Same product Id already exists. Please add different product id.");
	    	return null;
	    }
	    
    	System.out.print("Enter product name: ");
	    String name = sc.next();
	    System.out.print("Enter product price: ");
	    double price = sc.nextDouble();
	    Product product = new Product(id,name,price);
		return product;
	}
	
	private boolean idExistsInTable(int id) {
		ProductManagement productDoaObj = new ProductManagement();
		List<Product>productsList = productDoaObj.getAllProductsList();
		for(Product x:productsList){
			 if(x.getId()==id) {
			    	return true;
			 }
		}
		return false;
	}

	public Product getProductDetailsForUpdation(Scanner sc) {
		
		System.out.print("Enter product ID: ");
	    int id = sc.nextInt();
	    
	    if(!idExistsInTable(id)) {
	    	System.out.println("Product ID not found!");
	    	return null;
	    }
	   
    	System.out.print("Enter updated product name: ");
	    String name = sc.next();
	   // sc.nextLine(); // Consume newline
	    System.out.print("Enter updated product price: ");
	    double price = sc.nextDouble();
	    Product product = new Product(id,name,price);
		return product;
	}

	public int getProductIDForDeletion(Scanner sc) {
		
		System.out.print("Enter product ID: ");
	    int id = sc.nextInt();
		
		if(!idExistsInTable(id)) {
			System.out.println("Product ID not found!");
			return -1;
		}
		return id;
	}
	
	
	

	//These functions are for customer IO
	
	public Product getProductDetailsForAddingToCart(Scanner sc) {
		System.out.print("Enter product ID: ");
	    int id = sc.nextInt();
		
	    ProductManagement productDoaObj = new ProductManagement();
		List<Product>productsList = productDoaObj.getAllProductsList();
		for(Product x:productsList){
			 if(x.getId()==id) {
			    	return x;
			 }
		}
		System.out.println("Product ID not found!");
		return null;
	}

	public Product getProductDetailsForDeletion(Scanner sc) {
		System.out.print("Enter product ID: ");
	    int id = sc.nextInt();
		
	    ProductManagement productDoaObj = new ProductManagement();
		List<Product>productsList = productDoaObj.getAllProductsList();
		for(Product x:productsList){
			 if(x.getId()==id) {
			    	return x;
			 }
		}
		System.out.println("Item with "+id+" product ID not present in cart!");
		return null;
	}
}
