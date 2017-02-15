package service;
import domain.MemberBean;
import java.util.*;
public interface AdminService3 {
	// create
	public void regist(MemberBean member);
	// read
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public List<MemberBean> memberList();
	public List<String> keyList();
	public Set<MemberBean> memberSet();
	public Set<String> keySet();
	public Map<String,MemberBean> mapFindByName(String name);
	public int count();
	// update
	public void update(MemberBean member);
	// delete
	public void remove(String id);
}
