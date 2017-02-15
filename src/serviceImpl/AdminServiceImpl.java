package serviceImpl;
import service.AdminService;
import domain.MemberBean;
import java.util.*;

public class AdminServiceImpl implements AdminService{
	private Map<String,MemberBean> map;
	public AdminServiceImpl() {
		map = new HashMap<String,MemberBean>();
	}
	@Override
	public void regist(MemberBean member) {
		map.put(member.getUid(),member);
	}
	@Override
	public MemberBean findById(String id) {
		return map.get(id);
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		for(MemberBean m : memberlist()){
			if(name.equals(m.getName())){
				list.add(m);
			}
		}
		return list;
	}
	@Override
	public List<MemberBean> memberlist() {
		List<MemberBean> list=new ArrayList<MemberBean>();
		for(Map.Entry<String, MemberBean> e: map.entrySet()){
			list.add(e.getValue());
		}
		return list;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public void update(MemberBean member) {
		for(MemberBean m:memberlist()){
			if(member.getUid().equals(m.getUid())){
				m.setName((member.getName().equals(""))?m.getName():member.getName());
				m.setPassword((member.getPassword().equals(""))?m.getPassword():member.getPassword());
				m.setProfileImg((member.getProfileImg().equals(""))?m.getProfileImg():member.getProfileImg());
				m.setPhone((member.getPhone().equals(""))?m.getPhone():member.getPhone());
				m.setEmail((member.getEmail().equals(""))?m.getEmail():member.getEmail());
				m.setRank((member.getRank().equals(""))?m.getRank():member.getRank());
				break;
			}
		}
	}
	@Override
	public void remove(String id) {
		map.remove(id);
	}
	@Override
	public Map<String, MemberBean> mapFindByName(String name) {
		Map<String, MemberBean> temp=new HashMap<String, MemberBean>();
		for (Map.Entry<String, MemberBean>e : map.entrySet()) {
			if(name.equals(e.getValue().getName())){
				temp.put(e.getKey(), e.getValue());
			}
		}
		return temp;
	}
	@Override
	public List<String> keylist() {
		List<String> list=new ArrayList<String>();
		for(Map.Entry<String, MemberBean> e: map.entrySet()){
			list.add(e.getKey());
		}
		return list;
	}
	
}








