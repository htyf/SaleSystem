package cn.zyf.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import cn.zyf.dao.ICustomerDao;
import cn.zyf.entity.Customer;
import cn.zyf.entity.Status;
import cn.zyf.service.ICustomerService;


@Transactional
public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao dao ;
	
	public void setDao(ICustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(Customer cust) throws Exception {
		dao.add(cust);
		System.out.println("service ----------add");
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		return dao.query();
	}

	@Override
	public void delete(Customer cust) throws Exception {
		System.out.println("dao..delete");
		dao.delete(cust);
	}

	@Override
	public void update(Customer cust) throws Exception {
		dao.update(cust);
	}

	@Override
	public Customer getCustomerById(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

	@Override
	public int updateStatus(Customer cust) throws Exception {
		return dao.updateStatus(cust);
		
	}

	@Override
	public List<Customer> queryStatusIsNull() throws Exception {
		// TODO Auto-generated method stub
		return dao.queryStatusIsNull();
	}

	@Override
	public Status getStatus() throws Exception {
		int invalid = dao.countStatus("无效");
		int notpass = dao.countStatus("未通");
		int died = dao.countStatus("死单");
		int goin = dao.countStatus("上门");
		int forword = dao.countStatus("紧跟");
		int allocation = invalid+notpass+died+goin+forword;
		Status sta = new Status(invalid,notpass,died,goin,forword,allocation);
		return sta;
	}
	@Override
	public Status countStatusCurrMon() throws Exception {
		int invalid = dao.countStatusCurrMon("无效");
		int notpass = dao.countStatusCurrMon("未通");
		int died = dao.countStatusCurrMon("死单");
		int goin = dao.countStatusCurrMon("上门");
		int forword = dao.countStatusCurrMon("紧跟");
		int allocation = invalid+notpass+died+goin+forword;
		Status sta = new Status(invalid,notpass,died,goin,forword,allocation);
		return sta;
	}

	@Override
	public Status countStatusCurrDay() throws Exception {
		int invalid = dao.countStatusCurrDay("无效");
		int notpass = dao.countStatusCurrDay("未通");
		int died = dao.countStatusCurrDay("死单");
		int goin = dao.countStatusCurrDay("上门");
		int forword = dao.countStatusCurrDay("紧跟");
		int allocation = invalid+notpass+died+goin+forword;
		Status sta = new Status(invalid,notpass,died,goin,forword,allocation);
		return sta;
	}
	@Override
	public List<Customer> queryStatusGOIN() throws Exception {
		List<Customer> statusGOIN = dao.queryStatusGOIN();
		return statusGOIN;
	}

	@Override
	public List<Customer> queryStatusGOINByName(String name) throws Exception {
		
		return dao.queryStatusGOINByName(name);
	}

	@Override
	public List<Customer> queryStatusGOINByTel(String tel) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryStatusGOINByTel(tel);
	}

	@Override
	public List<Customer> queryStatusGOINByTime(String time) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryStatusGOINByTime(time);
	}

	

}
