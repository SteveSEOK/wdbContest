package yjc.wdb.bbs.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.bbs.bean.Schedule;




@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

	@Inject
	private SqlSession session;	
	private static String namespace = "web.yjc.wdb.mappers.ScheMapper";
	
	@Override
	public void join(Schedule svo) throws Exception {
		session.insert(namespace+".insertschedule",svo);
	}

	@Override
	public List<Schedule> getEvents(int t_id) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getEvents",t_id);
	}
	//���� ����
		@Override
		public void deleteSche(int s_id) {
			// TODO Auto-generated method stub
			session.insert(namespace + ".deleteSche", s_id);
		}

		@Override
		public void updateSche(Schedule schevo) {
			// TODO Auto-generated method stub
			session.update(namespace + ".updateSche", schevo);
		}

		@Override
		public void insertScheduleDrop(Schedule cal) {
			// TODO Auto-generated method stub
			session.update(namespace + ".insertScheduleDrop", cal);
		}

		@Override
		public Schedule getScheInfo(Integer s_id) {
			// TODO Auto-generated method stub
			return session.selectOne(namespace + ".getScheInfo",s_id);
		}
		//���� �˻�
		@Override
		public List<Schedule> getSearchList(HashMap<?, ?> map) {
			// TODO Auto-generated method stub
			return session.selectList(namespace + ".getSearchList", map);
		}

		// Ķ���� �ؿ� ���� ��������.
		@Override
		public List<Schedule> getRecently(String u_id) {
			// TODO Auto-generated method stub
			return session.selectList(namespace + ".getRecently", u_id);
		}
}
