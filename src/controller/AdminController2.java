package controller;

import javax.swing.JOptionPane;
import domain.MemberBean;
import service.AdminService2;
import serviceImpl.AdminServiceImpl2;

public class AdminController2 {
	public void start() {
		MemberBean member = null;
		AdminService2 service = new AdminServiceImpl2();
		String ssn = "";
		int i=0;
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료 1.회원등록 2.ID검색"
					+ " 3.이름검색 4.목록조회 5.등급조정 6.삭제")) {
			case "0":
				return;
			case "1":
				member = new MemberBean();
			String[] strArr=JOptionPane.showInputDialog("ID,이름").split(",");
			member.setUid(strArr[0]);
			member.setName(strArr[1]);
			service.regist(member);
			JOptionPane.showMessageDialog(null, service.count()+"명 등록됨");
				break;
			case "2":
				String keyword = JOptionPane.showInputDialog("아이디를 입력하세요");
				if(service.exist(keyword)){
					JOptionPane.showMessageDialog(null,service.findById(keyword).toString()); 
				}else{
					JOptionPane.showMessageDialog(null,"아이디가 존재하지 않음!!"); 
				}
				
					
				break;
			case "3":
				String temp = JOptionPane.showInputDialog("이름을 입력하세요");
				if(service.countByName(temp)!=0){
					MemberBean[] list = service.findByName(temp);
					for(;i<list.length;i++){
						temp+=list[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null,temp); 
				}else{
					JOptionPane.showMessageDialog(null,"아이디가 존재하지 않음!!"); 
				}
				
				break;
			case "4":
				if(service.count()==0){
					JOptionPane.showMessageDialog(null,
							"회원이 존재하지 않습니다");
				}else{
					MemberBean[] arr = service.list();
					String result = "";
					for(;i<service.count();i++){
						result += arr[i].toString()+"\n";
					}
					JOptionPane.showMessageDialog(null,result);
				}
				break;
			case "5":
				String temp2 = JOptionPane.showInputDialog("ID, RANK?");
				String[] tempArr = temp2.split(",");
				member.setUid(tempArr[0]);
				member.setRank(tempArr[1]);
				service.changeRank(member);
				break;
			case "6":
				break;
			
			}
		}
	}

}
