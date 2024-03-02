package Project.ProjectShopping;

import java.util.*;

public class ShoppingCartUtility {
	private List<Product> cartItems = new ArrayList<Product>();

    public void addToCart(Product product) {
    	//System.out.println(cartItems.size());
        cartItems.add(product);
        System.out.println(product.getName()+" $"+product.getPrice() + " added to cart.");
    }

    public void removeFromCart(Product product) {
        if (cartItems.contains(product)) {
            cartItems.remove(product);
            System.out.println(product.getName() + " removed from cart.");
        } else {
            System.out.println(product.getName() + " is not in the cart.");
        }
    }

    public void viewCart() {
        System.out.println("Items in cart:"+cartItems.size());
        
        for (Product item : cartItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    public double calculateBill() {
        double totalBill = 0;
        System.out.println("BILL - (Total Items: "+cartItems.size()+")");
        System.out.println("-----------------------------");
        for (Product item : cartItems) {
            totalBill += item.getPrice();
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("-----------------------------");
        System.out.println("Bill Total : $" + totalBill);
        return totalBill;
    }
}
