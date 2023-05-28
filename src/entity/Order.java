package entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int idOrder;
    private int idUser;
    private OrderLine currentOrderLine;
    List<OrderLine> listOrderLine = new ArrayList<>();

    public Order() {
    }

    public Order(int idOrder, int idUser) {
        this.idOrder = idOrder;
        this.idUser = idUser;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", listOrderLine=" + listOrderLine +
                '}';
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public List<OrderLine> getListOrderLine() {
        return listOrderLine;
    }

    public void setListOrderLine(OrderLine orderLine) {
        this.listOrderLine.add(orderLine);
        this.currentOrderLine = orderLine;
    }
}
