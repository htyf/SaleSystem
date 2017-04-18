package cn.zyf.entity;

public class Status {
	private int invalid;//无效
	private int notpass;//未通
	private int died;//死单
	private int goin;//上门
	private int forword;//紧跟
	private int monthCount;//分配
	private int  book;//定坐
	private int submit;//已报
	private int returnMoney;//退费
	public int getInvalid() {
		return invalid;
	}
	public void setInvalid(int invalid) {
		this.invalid = invalid;
	}
	public int getNotpass() {
		return notpass;
	}
	public void setNotpass(int notpass) {
		this.notpass = notpass;
	}
	public int getDied() {
		return died;
	}
	public void setDied(int died) {
		this.died = died;
	}
	public int getGoin() {
		return goin;
	}
	public void setGoin(int goin) {
		this.goin = goin;
	}
	public int getForword() {
		return forword;
	}
	public void setForword(int forword) {
		this.forword = forword;
	}
	public int getAllocation() {
		return monthCount;
	}
	public void setAllocation(int allocation) {
		this.monthCount = allocation;
	}
	public int getBook() {
		return book;
	}
	public void setBook(int book) {
		this.book = book;
	}
	public int getSubmit() {
		return submit;
	}
	public void setSubmit(int submit) {
		this.submit = submit;
	}
	public int getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(int returnMoney) {
		this.returnMoney = returnMoney;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int invalid, int notpass, int died, int goin, int forword, int allocation,
			int book, int submit, int returnMoney) {
		super();
		this.invalid = invalid;
		this.notpass = notpass;
		this.died = died;
		this.goin = goin;
		this.forword = forword;
		this.monthCount = allocation;
		this.book = book;
		this.submit = submit;
		this.returnMoney = returnMoney;
	}
	
	public Status(int invalid, int notpass, int died, int goin, int forword, int allocation) {
		super();
		this.invalid = invalid;
		this.notpass = notpass;
		this.died = died;
		this.goin = goin;
		this.forword = forword;
		this.monthCount = allocation;
	}
	@Override
	public String toString() {
		return "Status [invalid=" + invalid + ", notpass=" + notpass + ", died=" + died + ", goin=" + goin
				+ ", forword=" + forword + ", allocation=" + monthCount + ", book=" + book + ", submit=" + submit
				+ ", returnMoney=" + returnMoney + "]";
	}
	
	

}
