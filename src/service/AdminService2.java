package service;
import domain.MemberBean;
public interface AdminService2 {
	// create
	public void regist(MemberBean member);
	// read
	public MemberBean findById(String id);
	public MemberBean[] findByName(String name);
	
	public MemberBean[] list();
	public int count();
	// update
	public void changeRank(MemberBean member);
	// delete
	public void remove(String id);
	// util
	// validation
	public boolean exist(String keyword);
	public int countByName(String name);
}
