package service.impl;

import entity.Card;
import entity.CardLine;
import entity.Category;
import entity.Product;
import service.CardService;
import service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CardServiceImpl implements CardService {
    static int idCardLineDefaul=1;

    static List<Card> listCard = new ArrayList<>();
    static Card cardCurrent;

    @Override
    public boolean isCardIdUser(int idUser) {
        for (Card list: listCard){
            if(list.getIdUser()==idUser){
                cardCurrent=list;
                return true;
            }
        }
        return false;
    }

    @Override
    public Card getCardCurrent() {
        return this.cardCurrent;
    }

    @Override
    public void newCart(Card card) {
        listCard.add(card);
        cardCurrent=card;
    }

    @Override
    public boolean addCartLine(int idProduct, List<Category> categories) {
        for (Category list: categories){
            for (Product listP:list.getListProduct()){
                if (idProduct==listP.getIdProduct()){
                    CardLine cardLine= new CardLine(idCardLineDefaul,idProduct,1*listP.getPriceProduct(),1,listP.getPriceProduct());
                    cardCurrent.setListCardLine(cardLine);
                    idCardLineDefaul+=1;
                    return true;
                }
            }
        }
        return false;
    }


}
