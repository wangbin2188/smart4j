package org.smart4j.chapter2.service;

import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by wangbin10 on 2018/8/15.
 * 业务逻辑层，调用DAO层的工具类对实体类进行增删改查
 */
public class CustomerService {


    public List<Customer> getCustomerList() {
        try {
            String sql = "select * from customer;";
            return DatabaseHelper.queryEntityList(Customer.class, sql);
        } finally {
            DatabaseHelper.closeConnection();
        }
    }

    public Customer getCustomer(long id) {
        try {
            String sql = "select * from customer where id=?";
            return DatabaseHelper.queryEntity(Customer.class, sql, id);
        } finally {
            DatabaseHelper.closeConnection();
        }
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
