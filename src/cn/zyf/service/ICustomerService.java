package cn.zyf.service;

import java.util.Date;
import java.util.List;

import cn.zyf.entity.Customer;
import cn.zyf.entity.Status;

public interface ICustomerService {

	public void add(Customer cust) throws Exception;

	public void delete(Customer cust) throws Exception;

	public void update(Customer cust) throws Exception;

	public List<Customer> getAllCustomers() throws Exception;

	public Customer getCustomerById(String id) throws Exception;

	public int updateStatus(Customer cust) throws Exception ;

	public List<Customer> queryStatusIsNull() throws Exception;

	public Status getStatus() throws Exception;

	public Status countStatusCurrMon() throws Exception;
	
	public Status countStatusCurrDay() throws Exception;
	
	public List<Customer> queryStatusGOIN() throws Exception;

	public List<Customer> queryStatusGOINByName(String name) throws Exception;

	public List<Customer> queryStatusGOINByTel(String tel) throws Exception;

	public List<Customer> queryStatusGOINByTime(String time) throws Exception ;
	

}
