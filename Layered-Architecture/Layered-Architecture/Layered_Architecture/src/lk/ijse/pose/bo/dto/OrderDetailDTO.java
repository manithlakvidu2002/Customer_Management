package lk.ijse.pose.bo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class OrderDetailDTO implements Serializable {
    private String orderID;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderID, String itemCode, int qty, BigDecimal unitPrice) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetailDTO(String itemCode, int qty, BigDecimal unitPrice) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }



    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
