package com.obs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.pojos.*;

@Repository
public class BidDaoImpl implements BidDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public Bid addBid(Bid b) {
		System.out.println("Dao : add bid product "
				+ factory.getCurrentSession().save(b));
		return b;
	}
	@Override
	public Bid getBidById(Integer id) {
		return (Bid) factory.getCurrentSession().get(Bid.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Bid> getBids() {
		return factory.getCurrentSession()
				.createQuery("from Bid b",Bid.class).getResultList();

	}
	@Override
	public Bid bidOnThis(Bid b) {
		factory.getCurrentSession().update(b);
		return b;
	}

	@Override
	public String deleteBid(Bid p) {
		String status="Product from Bid deletion failed";
		if(p != null) {
			factory.getCurrentSession().delete(p);
			status="Bid with ID "+p.getId()+" deleted successfully";
		}
		return status;
	}
///////////////////////////////
	// @Override
	// public String getBidAmount(Bids b) {
	// 	//TODO service call
	// 	return null;
	// }
	// @Override
	// public List<Product> getTopProducts() {
	// 	//TODO add product service and add this to that.
	// 	return null;//factory.getCurrentSession()
	// 			//.createQuery("from Product p order by p.rank",Product.class).getResultList();
	// }


	// @Override
	// public String deleteBidByProductId(Product p) {
	// 	//TODO add this to service
	// 	return null;
	// 	//		String status="Product from Bid deletion failed";
	// 	//		if(p != null) {
	// 	//			this.deleteBid((Bids) factory.getCurrentSession()
	// 	//					.createQuery("from Bids b where b.product= :prod",Bids.class)
	// 	//					.setParameter("prod", p).getSingleResult());
	// 	//			status="Bid with product ID "+p.getId()+" deleted successfully";
	// 	//		}
	// 	//		return status;
	// }

	// @Override
	// public Bids getBidByProductId(Integer id) {
	// 	//TODO add this to service only.
	// 	return null;
	// 	//	(Bids) factory
	// 	//			.getCurrentSession()
	// 	//			.createQuery("select b from Bids b where b.product_id = :pid",Bids.class)
	// 	//			.setParameter("pid", id).getSingleResult();
	// }



	// @Override
	// public List<Product> getProductByPages(Integer begin, Integer offset) {
	// 	// TODO Auto-generated method stub
	// 	//Service call
	// 	return null;
	// }




}
