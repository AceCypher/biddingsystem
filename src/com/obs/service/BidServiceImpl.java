package com.obs.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.dao.*;
import com.obs.pojos.*;

@Service
@Transactional
public class BidServiceImpl implements IBidService{

	@Autowired
	private BidDao dao;

//	@Autowired
//	private ProductDao pdao;
	
	@Override
	public Bid addBid(Bid b) {
		Bid c1 = dao.addBid(b);
		if (c1.getId() == null)
			return null;
		return c1;
	}

	@Override
	@Transactional(readOnly = true)
	public Bid getBid(Integer id){
		return dao.getBidById(id);
	}

	@Override
	public List<Bid> getAllBids(){
		return dao.getBids();
	}

	@Override
	public String getBidAmount(Bid b){
		Bid thisBid = dao.getBidById(b.getId());
		if(thisBid == null)
			return null;
		return thisBid.getFinalBidAmount().toString();
	}

	@Override
	public Boolean getBidStatus(Bid b){
		Bid thisBid = dao.getBidById(b.getId());
		System.out.println(thisBid);
//		Date naoDate = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date naoDate = new Date();
		try {
			Date curDate = dateFormatter.parse(dateFormatter.format(naoDate));
			Date bidEndDate = dateFormatter.parse(thisBid.getTimerEnd().toString());
//			System.out.println(bidEndDate);
//			System.out.println(curDate);
//			System.out.println(bidEndDate.before(curDate));
//			System.out.println(curDate.before(bidEndDate));
			if( (thisBid == null) || (thisBid.getTimerEnd().before(naoDate)) || (thisBid.getFinalBidAmount() > b.getFinalBidAmount()))
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
    @Override
    public Bid bidOnThis(Bid b){
    	try {
			if((b.getId() == null) || (this.getBidStatus(b) == false)){
				System.out.println("Bid Failed");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bid mv = dao.bidOnThis(b);
		return mv;
	}

	@Override
	public String deleteBid(Bid p){
		return dao.deleteBid(p);
	}

	@Override
	public Bid getBidByProductId(Integer id){
		return null;
	}

	@Override
	public String deleteBidByProductId(Product p){
		return null;
	}
	
	@Override
	public String bidThis(Integer id){
		Bid b = dao.getBidById(id);
		if(this.getBidStatus(b) == false){
			System.out.println("Bid Failed");
			deleteBid(b);
			return "";
		}
		b.setFinalBidAmount(b.getFinalBidAmount()+100);
		dao.bidOnThis(b);
		
		return getBidAmount(b);
		
	}


}
