package lk.ijse.pose.bo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class OrderDTO  {
    private String orderId;
    private LocalDate orderDate;
    private String customerId;
    private String customerName;
    private BigDecimal orderTotal;
    List<OrderDetailDTO> orderDetailDTO;
    public OrderDTO() {
    }

    public OrderDTO(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetailDTO) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.orderDetailDTO = orderDetailDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTO() {
        return orderDetailDTO;
    }

    public void setOrderDetailDTO(List<OrderDetailDTO> orderDetailDTO) {
        this.orderDetailDTO = orderDetailDTO;
    }

    public OrderDTO(String orderId, LocalDate orderDate, String customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public OrderDTO(String orderId, LocalDate orderDate, String customerId, String customerName, BigDecimal orderTotal) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderTotal=" + orderTotal +
                '}';
    }
}
