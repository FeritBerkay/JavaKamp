package kodlamaio.notrhwind.dataAccess.abstracts;

import kodlamaio.notrhwind.entities.concretes.Product;
import kodlamaio.notrhwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<Product, Integer>{
		
//	Product getByProductName(String productName);
//	
//	Result add(Product product);
//	
//	 Product getByProductNameAndCategory(String productName, int categoryId);
//	  
//	  List<Product> getByProductNameOrCategory(String productName, int categoryId);
//	  
//	  List<Product> getByCategoryIn(List<Integer> categories);
//	  
//	  List<Product> getByProductNameContains(String productName);
//	  
//	  List<Product> getByProductNameStartsWith(String productName);
//	  
//	  //zaten join kolonları belirtildi. Catergori ıdleri aynı olanları yanyana getir ve bu tablolardan. id productname ve categoryname i getir dedik. ​jpql  kısmı
//	  @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
//		  		+ "(p.id, p.productName, c.categoryName) "
//		  		+ "From Category c Inner Join c.products p")
//	  List<ProductWithCategoryDto> getProductWithCategoryDetails(); 
//	  
//	  //select p.product_id,p.product_name, c.category_name
//	  //from products p inner join categories c on p.category_id =c.category_id
	 Product getByProductName(String productName);
	  
	  Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	  
	  List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
	  List<Product> getByCategoryIn(List<Integer> categories);
	  
	  List<Product> getByProductNameContains(String productName);
	  
	  List<Product> getByProductNameStartsWith(String productName);
	  
	  @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	  List<Product> getByNameAndCategory(String productName, int categoryId);
	  
	  @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
		  		+ "(p.id, p.productName, c.categoryName) "
		  		+ "From Category c Inner Join c.products p")
	  List<ProductWithCategoryDto> getProductWithCategoryDetails();
	  
	  //select p.productId,p.productName, c.categoryName  from Category c inner join Product p
	  //on c.categoryId = p.categoryId
}
