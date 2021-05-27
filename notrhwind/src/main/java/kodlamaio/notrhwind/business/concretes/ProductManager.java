package kodlamaio.notrhwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.notrhwind.business.abstracts.ProductService;
import kodlamaio.notrhwind.core.Utilities.result.DataResult;
import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.core.Utilities.result.SuccessDataResult;
import kodlamaio.notrhwind.core.Utilities.result.SuccessResult;
import kodlamaio.notrhwind.dataAccess.abstracts.ProductDao;
import kodlamaio.notrhwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	//interfaceler newlenemez ancak auowired o interface i implemente edeni buluyor. Spring sayesinde.
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override //çiğnemek.
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<>(this.productDao.findAll(),"Data Listelendi.");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}
	
}