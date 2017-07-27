package com.obs.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private Long id;

	@Column(name = "category_name", length = 100)
	@NotEmpty(message = "Name must not be blank")
	@Size(min = 3, message = "Category Name must be at least 3 characters!")
	private String categoryName;
	
	//Here mappedBy indicates that the owner is in the other side
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
//	private Set<Product> products = new HashSet<Product>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}

	/**
	 * @param id
	 * @param categoryName
	 * @param products
	 */
	public Category(Long id, String categoryName/*, Set<Product> products*/) {
		super();
		this.id = id;
		this.categoryName = categoryName;
//		this.products = products;
	}

	/**
	 * 
	 */
	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName +/* ", products=" + products +*/ "]";
	} 
	
	
	
}
