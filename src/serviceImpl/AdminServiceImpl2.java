package serviceImpl;

import service.AdminService2;
import domain.MemberBean;
public class AdminServiceImpl2 implements AdminService2{
	private MemberBean member;
	private MemberBean[] arr;

	private int count;
	public AdminServiceImpl2() {
		member = new MemberBean();
		count = 0;
		arr = new MemberBean[count];
	}
	@Override
	public void regist(MemberBean member) {
		// 회원정보를 입력한 후 배열에 저장하기
		if(count == arr.length ){
			MemberBean[] temp = new MemberBean[count+10];
			System.arraycopy(arr, 0, temp, 0, count);
			arr = temp;
		}
		arr[count++]=member;
		
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i=0;i<count;i++){
			if(id.equals(arr[i].getUid())){
				member = arr[i];
				break;
			}
		}
		return member;
	}

	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] list = new MemberBean[countByName(name)];
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				list[i] = arr[i];
			}
		}
		return list;
	}
	@Override
	public int countByName(String name) {
		int nameCount = 0;
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				nameCount++;
			}
		}
		return nameCount;
	}


	@Override
	public MemberBean[] list() {
		// 전체목록 출력
		return arr;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public void changeRank(MemberBean member) {
		for(int i=0;i<count;i++){
			if(member.getUid().equals(arr[i].getUid())){
				arr[i].setRank(member.getRank());
				break;
			}
		}
		
	}

	@Override
	public void remove(String id) {
		for(int i=0;i<count;i++){
			if(id.equals(arr[i].getUid())){
				arr[i]=arr[count-1];
				break;
			}
			
		}
		
	}
	@Override
	public boolean exist(String keyword) {
		boolean check = false;
		for(int i=0;i<count;i++){
			if(keyword.equals(arr[i].getUid())){
				check=true;
				break;
			}
		}
		return check;
	}
}








