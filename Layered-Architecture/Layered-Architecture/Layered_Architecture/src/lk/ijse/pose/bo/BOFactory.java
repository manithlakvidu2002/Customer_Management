package lk.ijse.pose.bo;

import lk.ijse.pose.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pose.bo.custom.impl.ItemBOImpl;
import lk.ijse.pose.bo.custom.impl.PurchaseOrderBOImpl;

import java.sql.SQLException;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBOFactory() throws SQLException, ClassNotFoundException {
        return boFactory == null ? boFactory= new BOFactory() : boFactory;
    }
    public enum BOTypes{
        CUSTOMER_BO,ITEM_BO,PURCHASE_ORDER
    }

    public static <T extends SuperBO>T getBO(BOTypes res) {
        switch (res){
            case CUSTOMER_BO:
                return (T) new CustomerBOImpl();
            case ITEM_BO:
                return (T) new ItemBOImpl();
            case PURCHASE_ORDER:
                return (T) new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
