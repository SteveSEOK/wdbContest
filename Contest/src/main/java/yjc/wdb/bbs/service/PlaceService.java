package yjc.wdb.bbs.service;

import java.util.List;

import yjc.wdb.bbs.Criteria2;
import yjc.wdb.bbs.bean.Board;
import yjc.wdb.bbs.bean.Criteria;
import yjc.wdb.bbs.bean.PlaceVo;
import yjc.wdb.bbs.bean.Reservation;
import yjc.wdb.bbs.bean.evaluationVo;
import yjc.wdb.bbs.bean.pay;

public interface PlaceService {
	public void insertPlace(PlaceVo place);

	public List<PlaceVo> PlaceList(Criteria2 criteria);

	public PlaceVo getPlaceInfo(Integer p_id);

	public void insertReservation(Reservation reservation);
	
	public List<Reservation> ReservationList(String id);
//	

	public Reservation getReservationInfo(Integer pr_id);

	public void insertpay(pay pay);

	public void deletePlace(Integer  p_id);

	public void updatePlace(Integer  p_id);

	public List<pay> Paylist(String id);

	public void addReply(evaluationVo vo) throws Exception;

	
	public void update(evaluationVo evaluationVo) throws Exception;
	public void delete(Integer r_id) throws Exception;
//	public List<evaluationVo> listPage(Integer p_no, Criteria criteria) throws Exception;
//	public Integer replyCount(Integer r_id) throws Exception;
	public int getTotalCount() throws Exception;
	public List<PlaceVo> listSearch(Criteria criteria) throws Exception;
	public int getSearchTotalCount(Criteria criteria) throws Exception;
}
