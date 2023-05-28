package service;

import entity.CardLine;
import entity.Order;

public interface OrderService {
    boolean isCardIdUser(int idUser);

    void newOrder(Order order);

    boolean addOrderLine(CardLine cardLine,String adress);

    void getAll();
}
