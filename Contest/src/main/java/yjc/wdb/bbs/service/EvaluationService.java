package yjc.wdb.bbs.service;

import java.util.List;

import yjc.wdb.bbs.bean.Evaluation;
import yjc.wdb.bbs.bean.Manager;

public interface EvaluationService {
	public Evaluation read(int c_id) throws Exception;
	public void create(Evaluation list) throws Exception;
	public Manager manager(int t_id) throws Exception;
	public Manager config(int t_id) throws Exception;
	public List<Manager> read_id(int c_id) throws Exception;
	public Manager read_work(Manager m) throws Exception;
	public int cnt_work(Manager m) throws Exception;
	public int cnt_m(int t_id) throws Exception;
	public int cnt_eval(Manager m) throws Exception;
	public int cnt_u_work(Manager m) throws Exception;
	public void grande(Manager m) throws Exception;
	public Manager get_work_id(Manager work) throws Exception;
	public void del_grande(Manager m)throws Exception;
	public List<Manager> get_epage(int c_id) throws Exception;
	public void update(Evaluation evaluation);
	public List<Manager> progress(Manager m) throws Exception;
	public void firstCreate(Evaluation evaluation) throws Exception;
	public List<Manager> cnt_alleval(Manager m1) throws Exception;
	public Manager get_ep_id(int t_id) throws Exception;
	public void stage_end(int t_id) throws Exception;
	public void stage_pro(int ep_id) throws Exception;
	public List<Manager> result_get(Manager m) throws Exception;
	public void result_set(Manager m) throws Exception;
	public List<Manager> get_work(int t_id) throws Exception;
	public Manager nowEp_id(int t_id) throws Exception;
	public Manager epEl(int t_id) throws Exception;
	public int ep_id(int c_id) throws Exception;
	public void elistCreate(Manager m) throws Exception;
}
