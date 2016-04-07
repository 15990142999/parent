package com.walter.myopensource.web.service;

import com.walter.myopensource.web.helper.DatabaseHelper;
import com.walter.myopensource.web.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by wangdongliang on 16/4/6.
 */
public class CustomerService {

    /**
     * 获取客户列表
     *
     * @return
     */
    public List<Customer> getCustomerList(){
        String sql = "select * from USER";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(long id){
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        return false;
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return false;
    }

    public boolean deleteCustomer(long id){
        return false;
    }
}
