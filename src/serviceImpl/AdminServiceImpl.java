package serviceImpl;

import service.AdminService;
import domain.MemberBean;
public class AdminServiceImpl implements AdminService{
	private MemberBean member;
	private MemberBean[] arr;

	private int count;
	public AdminServiceImpl() {
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
		arr[count]=member;
		count++;
	}

	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByName(String name) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	
}
