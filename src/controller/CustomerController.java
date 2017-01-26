package controller;

import java.util.Scanner;
import domain.MemberBean;
import javax.swing.*;
import constants.Bank;
import domain.AccountBean;
import service.AccountService;
import serviceImpl.AccountServiceImpl;
public class CustomerController {

	public void start() {
		Scanner s = new Scanner(System.in);
		MemberBean member = null;
		AccountBean account = null;
		AccountService service = new AccountServiceImpl();
		String ssn = "";
		while (true) {
			/*
			 * int opt = Integer.parseInt(option); String opt2 =
			 * String.valueOf(opt);
			 */
			switch (JOptionPane.showInputDialog("0.종료 1.회원등록 2.통장개설 3.입금 4.출금 5.조회 6.해지")) {
			case "0":
				return;
			case "1":
				member = new MemberBean();
				while (true) {
					ssn = JOptionPane.showInputDialog("주민번호앞자리(800101-1)");
					char ch = ssn.charAt(7);
					if (ch == '0' || ch == '7' || ch == '8' || ch == '9') {
						JOptionPane.showMessageDialog(null, "다시 입력하세요");
					} else {
						break;
					}
				}
				member.setSsn(ssn);
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setName(JOptionPane.showInputDialog("이름"));
				JOptionPane.showMessageDialog(null, member.getName() + "님 회원등록 되었습니다.");
				break;
			case "2":
				String uid = "";
				int money = 0;
				String accountType = "저축예금";
				account = service.createAccount(uid, accountType, money);
				/*
				 * [한빛뱅크] 계좌번호: 123456 예금종류: 저축예금 송상훈님 가입일:2016년12월14일 잔액: ￦ 0
				 */
				JOptionPane.showMessageDialog(null, account.toString());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, service.deposit(Integer.parseInt(JOptionPane.showInputDialog("얼마를 입금하시겠습니까?"))));
				break;
			case "4":
				JOptionPane.showMessageDialog(null, 
						service.withdraw(Integer.parseInt(
								JOptionPane.showInputDialog("출금할 금액을 입력해주세요."))));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, "잔액은"+account.getMoney()+"입니다.");
				break;
			case "6":
				break;
			}
		}
	}

}
