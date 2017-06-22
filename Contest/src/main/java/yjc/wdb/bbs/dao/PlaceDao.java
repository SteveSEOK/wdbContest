package yjc.wdb.bbs.dao;

import java.util.List;

import org.apache.ibatis.ognl.Evaluation;

import yjc.wdb.bbs.Criteria2;
import yjc.wdb.bbs.bean.Board;
import yjc.wdb.bbs.bean.Criteria;
import yjc.wdb.bbs.bean.PlaceVo;
import yjc.wdb.bbs.bean.Reservation;
import yjc.wdb.bbs.bean.evaluationVo;
import yjc.wdb.bbs.bean.pay;





public interface PlaceDao {
public void insertPlace(PlaceVo place);
public List<PlaceVo> PlaceList(Criteria2 criteria);
public int getTotalCount() throws Exception;
public List<PlaceVo> listSearch(Criteria criteria) throws Exception;
public int getSearchTotalCount(Criteria criteria)  throws Exception;
public List<Reservation> ReservationList(String u_id);
public PlaceVo getPlaceInfo(Integer p_id);
public void insertReservation(Reservation reservation);
public Reservation getReservationInfo(Integer pr_id);
public void insertpay(pay pay);
public void deletePlace( Integer p_id);
public void deleteReservation(Integer pr_id);
public void updatePlace(Integer p_id);
public void updateReservationStatus(Integer pr_id);
public List<pay>Paylist(String id);
public List<evaluationVo> list(Integer p_no) throws Exception;


public void create(evaluationVo vo) throws Exception;
public void update(evaluationVo evaluationVo) throws Exception;
public void delete( Integer r_id) throws Exception;
public List<evaluationVo> listPage( Integer p_no, Criteria criteria) throws Exception;
public int replyCount(Integer r_id) throws Exception;
}
