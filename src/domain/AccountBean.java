package domain;

import java.io.Serializable;

public class AccountBean implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String uid,accountType,createDate,
		money,accountNo;
	
	public void setMoney(String money){
		this.money=money;
	}
	public String getMoney(){
		return money;
	}
	public void setAccountNo(String accountNo){
		this.accountNo=accountNo;
	}
	public String getAccount(){
		return accountNo;
	}
	public void setUid(String uid){
		this.uid=uid;
	}
	public String getUid(){
		return uid;
	}
	public void setAccountType(String accountType){
		this.accountType=accountType;
	}
	public String getAccounttype(){
		return accountType;
	}
	public void setCreateDate(String createDate){
		this.createDate=createDate;
	}
	public String getCreateDate(){
		return createDate;
	}
	@Override
	public String toString() {
		return String.format("%d [%s] %s %s ￦%d",
				accountNo,
				accountType,
				uid,createDate,money
				);
	}

}
	
	

