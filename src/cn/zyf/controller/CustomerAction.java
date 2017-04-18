package cn.zyf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.zyf.entity.Customer;
import cn.zyf.entity.Status;
import cn.zyf.service.ICustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1215175513422696389L;
	/*******封装数据********/
	Customer customer = new Customer();
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	private int rows;
	private int page;

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	/*******封装数据********/



	/*******具体处理事情：
	 * 通过spring注入业务层的具体实现类**************
	 */
	private ICustomerService service;
	public void setService(ICustomerService service) {
		this.service = service;
	}
	/****************************************************/
	/**
	 * 添加客户
	 * @return
	 */
	public String add(){
		try {
			String custBirth = customer.getYear()+"-"+
					(Integer.parseInt(customer.getMonth())<10?"0"+customer.getMonth():""+customer.getMonth())+"-"
					+(Integer.parseInt(customer.getDay())<10?"0"+customer.getDay():""+customer.getDay());
			String custId = new SimpleDateFormat("yyyyMMdd").format(new Date())+customer.getCustTel();
			System.out.println(custId);
			customer.setCustBirth(custBirth);
			customer.setCustId(custId);
			service.add(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	/**
	 * 获取所有客户信息
	 * @return
	 */
	public String getAllCustomers(){
		try {
			List<Customer> allCustomers = service.getAllCustomers();
			String jsonString = JSON.toJSONString(allCustomers);
			System.out.println(jsonString);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除指定id 的客户
	 * @return
	 */
	public String delete(){
		try {
			System.out.println(customer);
			service.delete(customer);
			return "success";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "error";

	}
	/**
	 * 获取指定id的客户信息
	 * @return
	 */
	public String getCustomerById(){
		try {
			Customer customerById = service.getCustomerById(customer.getCustId());
			System.out.println(customerById);
			String jsonString = JSON.toJSONString(customerById);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据指定id更改用户信息
	 * @return
	 */
	public String update(){
		try {
			String custBirth = customer.getYear()+"-"+
					(Integer.parseInt(customer.getMonth())<10?"0"+customer.getMonth():""+customer.getMonth())+"-"
					+(Integer.parseInt(customer.getDay())<10?"0"+customer.getDay():""+customer.getDay());
			customer.setCustBirth(custBirth);
			System.out.println("------------"+customer);
			service.update(customer);
			return "success";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "error";
	}
	/**
	 * 更改客户状态
	 * @return
	 * @throws IOException 
	 */
	public String updateStatus() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		try {
			System.out.println("------------->"+customer);
			Calendar c = Calendar.getInstance();
			c.setTime(customer.getCustTime());
			customer.setYear(c.get(Calendar.YEAR)+"");
			customer.setMonth((c.get(Calendar.MONTH)+1)+"");
			customer.setDay(c.get(Calendar.DAY_OF_MONTH)+"");
			int rows = service.updateStatus(customer);
			if(rows>0){
				out.write("success");
			}else{
				out.write("error");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("状态未更改成功");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取所有客户状态为空的客户信息
	 */
	public String getAllStatusNullCust(){
		try {
			List<Customer> allCustomers = service.queryStatusIsNull();
			String jsonString = JSON.toJSONString(allCustomers);
			System.out.println(jsonString);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 本月统计
	 * @return
	 */
	public String getCurrMonthTotal(){
		try {
			Status status = service.countStatusCurrMon();
			String jsonString = JSON.toJSONString(status);
			System.out.println(jsonString);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 今日统计
	 * @return
	 */
	public String getCurrDayTotal(){
		try {
			Status status = service.countStatusCurrDay();
			String jsonString = JSON.toJSONString(status);
			System.out.println(jsonString);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 咨询师的所有客户信息
	 * @return
	 */
	public String getAllAskCust(){
		try {
			List<Customer> statusGOIN = service.queryStatusGOIN();
			String jsonString = JSON.toJSONString(statusGOIN);
			System.out.println(jsonString);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**=
	 * 根据指定条件查询相应咨询师的所有客户信息
	 * @return
	 */
	public String getAllAskCustByCondition(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String condition = req.getParameter("condition");
		String select = req.getParameter("select");
		List<Customer> statusGOIN = null;
		String jsonString = "";
		try {
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			if("custName".equals(condition)){
				statusGOIN = service.queryStatusGOINByName(select);
			}else if("custTel".equals(condition)){
				statusGOIN = service.queryStatusGOINByTel(select);
			}else if("custTime".equals(condition)){
				statusGOIN = service.queryStatusGOINByTime(select);
			}
			System.out.println(statusGOIN);
			jsonString = JSON.toJSONString(statusGOIN);

			out.write(jsonString);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
