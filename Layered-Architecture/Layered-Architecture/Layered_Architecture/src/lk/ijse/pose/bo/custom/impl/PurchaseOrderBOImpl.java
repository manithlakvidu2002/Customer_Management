package lk.ijse.pose.bo.custom.impl;

import lk.ijse.pose.bo.dao.DAOFactory;
import lk.ijse.pose.bo.custom.PurchaseOrderBO;
import lk.ijse.pose.bo.dao.custom.CustomerDAO;
import lk.ijse.pose.bo.dao.custom.ItemDAO;
import lk.ijse.pose.bo.dao.custom.OrderDAO;
import lk.ijse.pose.bo.dao.custom.OrderDetailsDAO;
import lk.ijse.pose.bo.db.DBConnection;
import lk.ijse.pose.bo.entity.Customer;
import lk.ijse.pose.bo.entity.Item;
import lk.ijse.pose.bo.entity.OrderDetails;
import lk.ijse.pose.bo.entity.Orders;
import lk.ijse.pose.bo.dto.CustomerDTO;
import lk.ijse.pose.bo.dto.ItemDTO;
import lk.ijse.pose.bo.dto.OrderDTO;
import lk.ijse.pose.bo.dto.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    OrderDAO orderDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailsDAO orderDetailsDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.save(new Orders(dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId()));
    }

    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(s);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.save(new OrderDetails(dto.getOrderID(),dto.getItemCode(),dto.getQty(),dto.getUnitPrice()));
    }
    public ItemDTO findItemByID(String code) {
        try {
            Item item = itemDAO.search(code);
            return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        /*Transaction*/
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            if (orderDAO.exist(orderDTO.getOrderId())) {
                return false;
            }

            connection.setAutoCommit(false);

            boolean orderAdded = orderDAO.save(new Orders(orderDTO.getOrderId(),orderDTO.getOrderDate(),orderDTO.getCustomerId()));
            if (!orderAdded) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : orderDTO.getOrderDetailDTO()) {
                boolean odAdded = orderDetailsDAO.save(new OrderDetails(detail.getOrderID(),detail.getItemCode(),detail.getQty(),detail.getUnitPrice()));
                ;
                if (!odAdded) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = findItemByID(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                boolean itemUpdate = itemDAO.update(new Item(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice()));


                if (!itemUpdate) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> list = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer:all) {
            list.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return list;
    }

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> list = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item item:all) {
            list.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return list;
    }
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer c = customerDAO.search(id);
        return new CustomerDTO(c.getId(),c.getName(),c.getAddress());
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.search(code);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    public boolean existItemByCode(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public boolean existCustomerByID(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

}
