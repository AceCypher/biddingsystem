package com.obs.pojos;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bids")
public class Bid {

	@Id
	@GeneratedValue
	@Column(name="bid_id")
	private Integer id;

//	@OneToOne
//	@JoinColumn(name = "product_id", nullable = false)
//	private Product product;
//	@OneToOne
//	@JoinColumn(name = "customer_id", nullable = false)
//	private Customer customer;
	
	@Column(name = "product_id", length = 100)
    private Long productId;
	
	@Column(name = "customer_id", length = 100)
    private Long customerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	@NotNull(message="Start Date must not be blank")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date timerStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	@NotNull(message="End Date must not be blank")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date timerEnd;

	@Column(name = "bid_amt", length = 100)
	@NotNull(message = "Final bidding amount must not be left blank")
	@Range(min = 100,max=5000, message = "Bid amount must be between 100 and 5000!")
	private Integer finalBidAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Date getTimerStart() {
		return timerStart;
	}

	public void setTimerStart(Date timerStart) {
		this.timerStart = timerStart;
	}

	public Date getTimerEnd() {
		return timerEnd;
	}

	public void setTimerEnd(Date timerEnd) {
		this.timerEnd = timerEnd;
	}

	public Integer getFinalBidAmount() {
		return finalBidAmount;
	}

	public void setFinalBidAmount(Integer finalBidAmount) {
		this.finalBidAmount = finalBidAmount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 */
	public Bid() {
		super();
		System.out.println("In Bid");
	}

	/**
	 * @param id
	 * @param product
	 * @param customer
	 * @param timerStart
	 * @param timerEnd
	 * @param finalBidAmount
	 */
	public Bid(Integer id, /*Product product, Customer customer, */ Date timerStart, Date timerEnd, Integer finalBidAmount) {
		super();
		this.id = id;
//		this.product = product;
//		this.customer = customer;
		this.timerStart = timerStart;
		this.timerEnd = timerEnd;
		this.finalBidAmount = finalBidAmount;
	}

	@Override
	public String toString() {
		return "Bid [id=" + id + ", timerStart=" + timerStart
				+ ", timerEnd=" + timerEnd + ", finalBidAmount=" + finalBidAmount + "]";
		//, product=" + product + ", customer=" + customer + "
	}
	

	
}
