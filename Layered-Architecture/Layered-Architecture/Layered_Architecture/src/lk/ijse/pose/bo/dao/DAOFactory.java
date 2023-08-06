package lk.ijse.pose.bo.dao;

import lk.ijse.pose.bo.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoObjectCreator;
    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        if (daoObjectCreator==null){
            daoObjectCreator= new DAOFactory();
        }
        return daoObjectCreator;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO
    }

    public <T extends SuperDAO>T getDAO(DAOTypes res) {
            switch (res){
                case CUSTOMER:
                    return (T) new CustomerDAOImpl();
                case ITEM:
                    return (T) new ItemDAOImpl();
                case ORDER:
                    return (T) new OrderDAOImpl();
                case ORDER_DETAILS:
                    return (T) new OrderDetailsDAOImpl();
                case QUERY_DAO:
                    return (T) new QueryDAOImpl();
                default:
                    return null;
            }
        }


}