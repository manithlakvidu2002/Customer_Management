package lk.ijse.pose.bo.custom;

import lk.ijse.pose.bo.SuperBO;
import lk.ijse.pose.bo.dto.CustomerDTO;
import lk.ijse.pose.bo.dto.ItemDTO;
import lk.ijse.pose.bo.dto.OrderDTO;
import lk.ijse.pose.bo.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBO {
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;
    public boolean exist(String s) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;

    public boolean existItemByCode(String code) throws SQLException, ClassNotFoundException;

    public boolean existCustomerByID(String id) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO orderDTO)throws SQLException, ClassNotFoundException ;
}
