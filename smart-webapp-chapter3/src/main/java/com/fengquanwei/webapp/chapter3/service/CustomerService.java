package com.fengquanwei.webapp.chapter3.service;

import com.fengquanwei.framework.annotation.Service;
import com.fengquanwei.framework.helper.DatabaseHelper;
import com.fengquanwei.webapp.chapter3.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 客户服务
 *
 * @author fengquanwei
 * @create 2017/12/07 15:34
 **/
@Service
public class CustomerService {
    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
