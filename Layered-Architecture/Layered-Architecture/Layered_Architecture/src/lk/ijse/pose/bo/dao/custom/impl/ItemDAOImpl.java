package lk.ijse.pose.bo.dao.custom.impl;

import lk.ijse.pose.bo.dao.custom.ItemDAO;
import lk.ijse.pose.bo.dao.custom.impl.util.SQLUtil;
import lk.ijse.pose.bo.entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(4), rst.getBigDecimal(3)));
        }
        return allItems;
    }

    @Override
    public boolean save(Item dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
      return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(), dto.getUnitPrice(),dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",id);
       return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE code=?",id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM Item WHERE code=?",id);
        if (rst.next()){
            return new Item(rst.getString(1),rst.getString(2),rst.getInt(4),rst.getBigDecimal(3));
        }
        return null;
    }


//    @Override
//    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
//        ArrayList<ItemDTO> allItems = new ArrayList<>();
//        while (rst.next()) {
//            allItems.add(new ItemDTO(rst.getString(1), rst.getString(2), rst.getBigDecimal(4), rst.getInt(3)));
//        }
//        return allItems;
//    }
//
//    @Override
//    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
//        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
//    }
//
//    @Override
//    public boolean saveItem(ItemDTO lk.ijse.pose.bo.dto) throws SQLException, ClassNotFoundException {
//       return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",lk.ijse.pose.bo.dto.getCode(),lk.ijse.pose.bo.dto.getDescription(),lk.ijse.pose.bo.dto.getUnitPrice(),lk.ijse.pose.bo.dto.getQtyOnHand());
//    }
//
//    @Override
//    public boolean updateItem(ItemDTO lk.ijse.pose.bo.dto) throws SQLException, ClassNotFoundException {
//        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",lk.ijse.pose.bo.dto.getDescription(), lk.ijse.pose.bo.dto.getUnitPrice(),lk.ijse.pose.bo.dto.getQtyOnHand(), lk.ijse.pose.bo.dto.getCode());
//    }
//
//    @Override
//    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
//        return rst.next();
//    }
//
//    @Override
//    public String generateNewCode() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("code");
//            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
//            return String.format("I00-%03d", newItemId);
//        } else {
//            return "I00-001";
//        }
//    }
//
//    @Override
//    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
//        ResultSet rst= SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);
//        if (rst.next()){
//            return new ItemDTO(rst.getString(1),rst.getString(2),rst.getBigDecimal(4),rst.getInt(3));
//        }
//        return null;
//    }


}
