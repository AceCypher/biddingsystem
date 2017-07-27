package com.obs.pojos;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="product_id")
    private Integer id;

    @Column(name = "product_code", length = 100)
    @NotEmpty(message = "Name must not be blank")
    @Size(min = 3, message = "Product Code must be at least 3 characters!")
    private String productCode;

    @Column(name = "product_name", length = 100)
    @Size(min = 3, message = "Product Name must be at least 3 characters!")
    private String productName;

    @Column(name = "product_desc", length = 100)
    @Size(min = 5, message = "Product Description must be at least 5 characters!")
    private String productDesc;


    @Column(name = "product_base_amount", length = 100)
    @Range(min = 100,max=5000, message = "Product base amount must be at least 3 characters!")
    private Long productBaseAmount;

    @Column(name = "product_seo_url", length = 100)
    @Size(min = 3, message = "Product url must be at least 3 characters!")
    private String productSeoUrl;

    @Column(name = "product_image_url", length = 100)
    @Size(min = 3, message = "Product image url must be at least 3 characters!")
    private String productImageUrl;
    
    @Column(name = "product_rank", length = 100)
    private Integer rank;

    //Here JoinColumn states that this entity is the owner of the relationship
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;
    
//    @OneToOne(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Bid bid;
    @Column(name="category_id")
    private Integer CategoryId;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Long getProductBaseAmount() {
		return productBaseAmount;
	}

	public void setProductBaseAmount(Long productBaseAmount) {
		this.productBaseAmount = productBaseAmount;
	}

	public String getProductSeoUrl() {
		return productSeoUrl;
	}

	public void setProductSeoUrl(String productSeoUrl) {
		this.productSeoUrl = productSeoUrl;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

//	public Bid getBid() {
//		return bid;
//	}
//
//	public void setBid(Bid bid) {
//		this.bid = bid;
//	}

	public Integer getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}

	/**
	 * 
	 */
	public Product() {
		super();
	}

	/**
	 * @param id
	 * @param productCode
	 * @param productName
	 * @param productDesc
	 * @param productBaseAmount
	 * @param productSeoUrl
	 * @param productImageUrl
	 * @param rank
	 * @param category
	 * @param bid
	 */
	public Product(Integer id, String productCode, String productName, String productDesc, Long productBaseAmount,
			String productSeoUrl, String productImageUrl, Integer rank/*, Category category, Bid bid*/) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productBaseAmount = productBaseAmount;
		this.productSeoUrl = productSeoUrl;
		this.productImageUrl = productImageUrl;
		this.rank = rank;
		//this.category = category;
		//this.bid = bid;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productName=" + productName + ", productDesc="
				+ productDesc + ", productBaseAmount=" + productBaseAmount + ", productSeoUrl=" + productSeoUrl
				+ ", productImageUrl=" + productImageUrl + ", rank=" + rank + /*", category=" + category + */"]";
		//", bid=" + bid+ 
	}
    
    

}
