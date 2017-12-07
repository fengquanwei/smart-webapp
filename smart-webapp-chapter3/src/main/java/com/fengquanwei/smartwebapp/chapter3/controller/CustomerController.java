package com.fengquanwei.smartwebapp.chapter3.controller;

import com.fengquanwei.framework.annotation.Action;
import com.fengquanwei.framework.annotation.Controller;
import com.fengquanwei.framework.annotation.Inject;
import com.fengquanwei.framework.bean.Data;
import com.fengquanwei.framework.bean.Param;
import com.fengquanwei.framework.bean.View;
import com.fengquanwei.smartwebapp.chapter3.model.Customer;
import com.fengquanwei.smartwebapp.chapter3.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * 客户管理
 */
@Controller
public class CustomerController {
    @Inject
    private CustomerService customerService;

    /**
     * 进入客户列表界面
     */
    @Action("get:/customer")
    public View index() {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示客户基本信息
     */
    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 进入创建客户界面
     */
    @Action("get:/customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

    /**
     * 处理创建客户请求
     */
    @Action("post:/customer_create")
    public Data createSubmit(Param param) {
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 进入编辑客户界面
     */
    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理编辑客户请求
     */
    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理删除客户请求
     */
    @Action("delete:/customer_edit")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}