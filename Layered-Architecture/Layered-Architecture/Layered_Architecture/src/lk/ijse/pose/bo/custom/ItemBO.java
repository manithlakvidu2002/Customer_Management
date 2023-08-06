package lk.ijse.pose.bo.custom;

import lk.ijse.pose.bo.SuperBO;
import lk.ijse.pose.bo.dao.custom.ItemDAO;
import lk.ijse.pose.bo.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pose.bo.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ItemDAO itemDAO  = new ItemDAOImpl();
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;

    public ItemDTO search(String id) throws SQLException, ClassNotFoundException;
}
