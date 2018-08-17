package org.smart4j.chapter2.service;

import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wangbin10 on 2018/8/15.
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
