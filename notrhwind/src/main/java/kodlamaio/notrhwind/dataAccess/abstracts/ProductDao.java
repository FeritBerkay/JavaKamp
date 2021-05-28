package kodlamaio.notrhwind.dataAccess.abstracts;

import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.entities.concretes.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	
	Result add(Product product);
	
	 Product getByProductNameAndCategory(String productName, int categoryId);
	  
	  List<Product> getByProductNameOrCategory(String productName, int categoryId);
	  
	  List<Product> getByCategoryIn(List<Integer> categories);
	  
	  List<Product> getByProductNameContains(String productName);
	  
	  List<Product> getByProductNameStartsWith(String productName);
}
