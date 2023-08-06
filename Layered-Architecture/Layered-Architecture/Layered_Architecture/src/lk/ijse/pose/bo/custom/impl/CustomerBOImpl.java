package lk.ijse.pose.bo.custom.impl;

import lk.ijse.pose.bo.custom.CustomerBO;
import lk.ijse.pose.bo.dao.DAOFactory;
import lk.ijse.pose.bo.dao.custom.CustomerDAO;
import lk.ijse.pose.bo.entity.Customer;
import lk.ijse.pose.bo.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }
    public boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }
    public boolean deleteCustomers(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    public String generateNewCusID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }

    public CustomerDTO searchCustomers(String id) throws SQLException, ClassNotFoundException {
        Customer c = customerDAO.search(id);
        return new CustomerDTO(c.getId(),c.getName(),c.getAddress());
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> list = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer:all) {
            list.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return list;
    }
    public boolean existCustomers(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
}
