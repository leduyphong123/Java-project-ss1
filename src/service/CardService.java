package service;

import entity.Card;
import entity.Category;

import java.util.List;

public interface CardService {


    boolean isCardIdUser(int idUser);

    Card getCardCurrent();

    void newCart(Card card);

    boolean addCartLine(int idProduct, List<Category> categories);
}
