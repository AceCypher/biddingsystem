package com.obs.service;

import java.util.List;

import com.obs.pojos.*;
public interface IBidService {

	public Bid addBid(Bid b);

	public Bid getBid(Integer id);

	public List<Bid> getAllBids();

	public Bid bidOnThis(Bid b);

	public String deleteBid(Bid p);

	public Bid getBidByProductId(Integer id);

	public String deleteBidByProductId(Product p);

	public String getBidAmount(Bid b);
	//1. Check if bid still active, yes - > get the latest value, if db value is greater than amount, reject it, else if the value is smaller, increase the amt and make the deal. If deal ended, reject the bid and acknowledge regret msg.

	public Boolean getBidStatus(Bid b);
	//Check if the bid is active, return true else update the user-transaction table and remove the bid from the table and on view destroy the dom or just show bid over.
}
