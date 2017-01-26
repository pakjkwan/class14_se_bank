package service;
import domain.MemberBean;
public interface AdminService {
	// create
	public void regist(MemberBean member);
	// read
	public MemberBean findById(String id);
	public MemberBean[] findByName(String name);
	public int countByName(String name);
	public MemberBean[] list();
	public int count();
	// update
	public void changeRank(MemberBean member);
	// delete
	public void remove(MemberBean member);
}
