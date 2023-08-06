package lk.ijse.pose.bo.dao;

import lk.ijse.pose.bo.dao.custom.CustomerDAO;
import lk.ijse.pose.bo.dao.custom.ItemDAO;
import lk.ijse.pose.bo.dao.custom.OrderDAO;
import lk.ijse.pose.bo.dao.custom.OrderDetailsDAO;
import lk.ijse.pose.bo.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pose.bo.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pose.bo.dao.custom.impl.OrderDAOImpl;
import lk.ijse.pose.bo.dao.custom.impl.OrderDetailsDAOImpl;

public class Objects {

        private static OrderDAO orderDAO = new OrderDAOImpl();
        private static OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
        private static ItemDAO itemDAO = new ItemDAOImpl();
        private static CustomerDAO customerDAO = new CustomerDAOImpl();

        public static OrderDAO getOrderObject(){
            return  orderDAO == null ? orderDAO= new OrderDAOImpl() : orderDAO;
        }
        public static OrderDetailsDAO getOrderDetailObject(){
            return  orderDetailsDAO == null ? orderDetailsDAO= new OrderDetailsDAOImpl() : orderDetailsDAO;
        }
        public static ItemDAO getItemObject(){
            return itemDAO == null ? itemDAO= new ItemDAOImpl() : itemDAO;
        }
        public static CustomerDAO getCustomerObject(){
            return customerDAO == null ? customerDAO= new CustomerDAOImpl() : customerDAO;
        }

    }

