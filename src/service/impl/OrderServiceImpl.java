package service.impl;

import entity.Card;
import entity.CardLine;
import entity.Order;
import entity.OrderLine;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    static int idOrderLineDefaul=1;

    static List<Order> listOrder = new ArrayList<>();
    static Order cardCurrent;

    @Override
    public boolean isCardIdUser(int idUser) {
        for (Order list: listOrder){
            if(list.getIdUser()==idUser){
                cardCurrent=list;
                return true;
            }
        }
        return false;
    }


    @Override
    public void newOrder(Order order) {
        listOrder.add(order);
        cardCurrent=order;
    }

    @Override
    public boolean addOrderLine(CardLine cardLine,String adress) {
        OrderLine orderLine= new OrderLine(idOrderLineDefaul,cardLine.getIdProduct(),cardLine.getSubTotal(),cardLine.getQuantity(),adress);
        this.cardCurrent.setListOrderLine(orderLine);
        return true;
    }

    @Override
    public void getAll() {
        for (OrderLine list : cardCurrent.getListOrderLine()){
            System.out.println(list);
        }
    }
}
