package serviceImpl;
import service.AdminService3;
import domain.MemberBean;
import java.util.*;

public class AdminServiceImpl3 implements AdminService3{
	private Map<String,MemberBean> map;
	public AdminServiceImpl3() {
		map = new HashMap<String,MemberBean>();
	}
	@Override
	public void regist(MemberBean member) {
		map.put(member.getUid(),member);
	}
	@Override
	public MemberBean findById(String id) {
		MemberBean mem=new MemberBean();
		
		return mem;
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		Set<MemberBean>set=memberSet();
		Iterator<MemberBean>it=set.iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		return list;
	}
	@Override
	public List<MemberBean> memberList() {
		List<MemberBean> temp=new ArrayList<MemberBean>();
		for (Map.Entry<String, MemberBean>e : map.entrySet()) {
				temp.add(e.getValue());
		}
		return temp;
	}
	@Override
	public List<String> keyList() {
		List<String> temp=new ArrayList<String>();
		for (Map.Entry<String, MemberBean>e : map.entrySet()) {
				temp.add(e.getKey());
		}
		return temp;
	}
	@Override
	public Set<MemberBean> memberSet() {
		Set<MemberBean> temp=new HashSet<MemberBean>();
		for (Map.Entry<String, MemberBean>e : map.entrySet()) {
				temp.add(e.getValue());
		}
		return temp;
	}
	@Override
	public Set<String> keySet() {
		Set<String> temp=new HashSet<String>();
		for (Map.Entry<String, MemberBean>e : map.entrySet()) {
				temp.add(e.getKey());
		}
		return temp;
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
	public int count() {
		return map.size();
	}
	@Override
	public void update(MemberBean member) {
		
	}
	@Override
	public void remove(String id) {
		
	}
	
}








