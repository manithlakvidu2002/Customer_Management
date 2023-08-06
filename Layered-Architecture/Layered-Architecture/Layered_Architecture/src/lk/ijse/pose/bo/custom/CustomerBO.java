package lk.ijse.pose.bo.custom;

import lk.ijse.pose.bo.SuperBO;
import lk.ijse.pose.bo.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomers(String id) throws SQLException, ClassNotFoundException;
    public String generateNewCusID() throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomers(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    public boolean existCustomers(String id) throws SQLException, ClassNotFoundException;
}
