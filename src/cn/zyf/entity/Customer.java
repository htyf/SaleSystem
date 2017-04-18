package cn.zyf.entity;

import java.util.Date;

/**
 * 客户实体类
 *
 */
public class Customer {
	private String custId;//编号
	private String custName;//姓名
	private String custGender;//性别 
	private String custBirth;//生日
	private String custNative;//籍贯
	private String custEdu;//学历
	private String custSchool;//学校
	private String custTel;//电话
	private String custEmail;//邮箱
	private String custJonIntention;//求职意向
	private String custSource;//来源
	private String custHA;//家庭住址
	private String custComment;//备注
	private String custStatus;//客户状态
	private Date custTime;//状态时间
	private String year;
	private String month;
	private String day;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustGender() {
		return custGender;
	}
	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}
	public String getCustBirth() {
		return custBirth;
	}
	public void setCustBirth(String custBirth) {
		this.custBirth = custBirth;
	}
	public String getCustNative() {
		return custNative;
	}
	public void setCustNative(String custNative) {
		this.custNative = custNative;
	}
	public String getCustEdu() {
		return custEdu;
	}
	public void setCustEdu(String custEdu) {
		this.custEdu = custEdu;
	}
	public String getCustSchool() {
		return custSchool;
	}
	public void setCustSchool(String custSchool) {
		this.custSchool = custSchool;
	}
	public String getCustTel() {
		return custTel;
	}
	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustJonIntention() {
		return custJonIntention;
	}
	public void setCustJonIntention(String custJonIntention) {
		this.custJonIntention = custJonIntention;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustHA() {
		return custHA;
	}
	public void setCustHA(String custHA) {
		this.custHA = custHA;
	}
	public String getCustComment() {
		return custComment;
	}
	public void setCustComment(String custComment) {
		this.custComment = custComment;
	}
	
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public Date getCustTime() {
		return custTime;
	}
	public void setCustTime(Date custTime) {
		this.custTime = custTime;
	}
	
	public Customer(String custId, String custName, String custGender, String custBirth, String custNative,
			String custEdu, String custSchool, String custTel, String custEmail, String custJonIntention,
			String custSource, String custHA, String custComment) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custGender = custGender;
		this.custBirth = custBirth;
		this.custNative = custNative;
		this.custEdu = custEdu;
		this.custSchool = custSchool;
		this.custTel = custTel;
		this.custEmail = custEmail;
		this.custJonIntention = custJonIntention;
		this.custSource = custSource;
		this.custHA = custHA;
		this.custComment = custComment;
	}
	public Customer(String custName, String custGender, String custBirth, String custNative, String custEdu,
			String custSchool, String custTel, String custEmail, String custJonIntention, String custSource,
			String custHA, String custComment) {
		super();
		this.custName = custName;
		this.custGender = custGender;
		this.custBirth = custBirth;
		this.custNative = custNative;
		this.custEdu = custEdu;
		this.custSchool = custSchool;
		this.custTel = custTel;
		this.custEmail = custEmail;
		this.custJonIntention = custJonIntention;
		this.custSource = custSource;
		this.custHA = custHA;
		this.custComment = custComment;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String custId, String custName, String custGender, String custBirth, String custNative,
			String custEdu, String custSchool, String custTel, String custEmail, String custJonIntention,
			String custSource, String custHA, String custComment, String custStatus, Date custTime) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custGender = custGender;
		this.custBirth = custBirth;
		this.custNative = custNative;
		this.custEdu = custEdu;
		this.custSchool = custSchool;
		this.custTel = custTel;
		this.custEmail = custEmail;
		this.custJonIntention = custJonIntention;
		this.custSource = custSource;
		this.custHA = custHA;
		this.custComment = custComment;
		this.custStatus = custStatus;
		this.custTime = custTime;
	}
	
	
	
	public Customer(String custId, String custName, String custTel, String custStatus, Date custTime) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custTel = custTel;
		this.custStatus = custStatus;
		this.custTime = custTime;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custGender=" + custGender + ", custBirth="
				+ custBirth + ", custNative=" + custNative + ", custEdu=" + custEdu + ", custSchool=" + custSchool
				+ ", custTel=" + custTel + ", custEmail=" + custEmail + ", custJonIntention=" + custJonIntention
				+ ", custSource=" + custSource + ", custHA=" + custHA + ", custComment=" + custComment + ", custStatus="
				+ custStatus + ", custTime=" + custTime + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	
	
	
}
