package Project.ProjectShopping;
import java.util.*;
import java.sql.*;

public class ProductManagement {
	
	public void addProduct(Product p)  {
		try {
			Connection conn = DB.getConnection();
			String sql = "INSERT INTO products (product_id, product_name, product_price) VALUES (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, p.getId());
			statement.setString(2, p.getName());
			statement.setDouble(3, p.getPrice());
			statement.executeUpdate();
			statement.close();
			conn.close();
			System.out.println("Product Added Successfully");
		} catch (SQLException e) {
			System.out.println("Error in adding product, try again!");
			e.printStackTrace();
		}
	}
	
	
	public List<Product> getAllProductsList() {
		List<Product> productList = new ArrayList<Product>();
        try {
			Connection connection = DB.getConnection();
			String sql = "SELECT * FROM products order by Product_id";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
			    Product product = new Product();
			    product.setId(resultSet.getInt("product_id"));
			    product.setName(resultSet.getString("product_name"));
			    product.setPrice(resultSet.getDouble("product_price"));
			    productList.add(product);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return productList;
	}
	
	
	public void updateProduct(Product p) {
		try {
			Connection connection = DB.getConnection();
			String sql = "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, p.getName());
			statement.setDouble(2, p.getPrice());
			statement.setInt(3, p.getId());
			int rowsUpdated = statement.executeUpdate();
			statement.close();
			connection.close();
			if (rowsUpdated > 0) {
			    System.out.println("Product updated successfully!");
			} else {
			    System.out.println("Product update failed!");
			}
		} catch (SQLException e) {
			System.out.println("Product update failed, please try again!");
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteProduct(int id) {
		try {
			Connection connection = DB.getConnection();
			String sql = "DELETE FROM products WHERE product_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			int rowsDeleted = statement.executeUpdate();
			statement.close();
			connection.close();
			if (rowsDeleted > 0) {
			    System.out.println("Product deleted successfully!");
			} else {
			    System.out.println("Product deletion failed!");
			}
			
		} catch (SQLException e) {
			System.out.println("Product deletion failed!");
			e.printStackTrace();
		}
	}
}
