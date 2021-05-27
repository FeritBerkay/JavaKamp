package kodlamaio.notrhwind.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.notrhwind.business.abstracts.ProductService;
import kodlamaio.notrhwind.core.Utilities.result.DataResult;
import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.entities.concretes.Product;


@RestController //java olmayanlarda bizi tanısın
@RequestMapping("/api/products") //sub domain i verdik.
public class ProductsController {
	
	
	private ProductService productService;
	
	
	@Autowired //product service den produnct manageri cekmemize yararıyor.
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}



	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add") //datayı karsılıklı olarak eşleştirir requestbody. Mapler.	
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
}
