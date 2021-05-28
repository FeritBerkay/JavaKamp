package kodlamaio.notrhwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi.");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}
	
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data listelendi");	
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory(productName, categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	}
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");	//listelenecek ama hangi alana gore bu kısmı verdik.
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Başarılı");
	}
	
}