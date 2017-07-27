package com.obs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.obs.pojos.*;

public interface BidDao {

	public Bid addBid(Bid b);

	public Bid getBidById(Integer id);

	public List<Bid> getBids();

	public Bid bidOnThis(Bid b);

	public String deleteBid(Bid p);

	//Upon completion of bidding, update user transaction and remove bid

}
