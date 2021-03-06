package kodlamaio.notrhwind.business.abstracts;


import java.util.List;

import kodlamaio.notrhwind.core.Utilities.result.DataResult;
import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.entities.concretes.Product;
public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
}
