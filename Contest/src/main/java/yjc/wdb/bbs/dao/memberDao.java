package yjc.wdb.bbs.dao;

import java.util.List;

import yjc.wdb.bbs.bean.Userbean;



public interface memberDao {
public void insertMember(Userbean member)throws Exception;
public List<Userbean> getMemberAll();
public Userbean login(Userbean vo)throws Exception;
public Userbean check(String id)throws Exception;
public Userbean view(String mid);
//public Integer getType(String id) throws Exception;
}
