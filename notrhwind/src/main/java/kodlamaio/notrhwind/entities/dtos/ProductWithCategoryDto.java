package kodlamaio.notrhwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
	
	private int id;
	private String categoryName;
	private String productName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductWithCategoryDto() {
		super();
	}

	public ProductWithCategoryDto(int id, String categoryName, String productName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.productName = productName;
	}
	
}
