package lk.ijse.pose.bo.dao.custom;

import lk.ijse.pose.bo.dao.SuperDAO;
import lk.ijse.pose.bo.dto.CustomEntityDTO;
import lk.ijse.pose.bo.entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<CustomEntity> searchOrderByOID(String oid) throws SQLException, ClassNotFoundException;

}
