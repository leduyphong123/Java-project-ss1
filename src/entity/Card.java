package entity;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private int idCard;
    private int idUser;
    private int total;
    private CardLine currenCardLine;
    private List<CardLine> listCardLine = new ArrayList<>();

    public void upTotal(){
        this.total=0;
        for (CardLine list:listCardLine){
            this.total+=list.getSubTotal();
        }
        System.out.println("Total:" +this.total);
    }
    public CardLine getCurrenCardLine() {
        return currenCardLine;
    }

    public void setCurrenCardLine(CardLine currenCardLine) {
        this.currenCardLine = currenCardLine;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public Card(){}
    public Card(int idCard,int idUser){
        this.idCard=idCard;
        this.idUser=idUser;
    }
    public void getListCardLine(int idCardLine){
        for (CardLine list:listCardLine){
            if (list.getIdCardLine()==idCardLine){
                currenCardLine=list;
                System.out.println(list);
            }
        }
    }

    public void setListCardLine(CardLine cardLine){
        listCardLine.add(cardLine);
    }
    public void getListCardLine(){
        for (CardLine list:listCardLine){
            System.out.println(list);
        }
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Card{" +
                "idCard=" + idCard +
                ", idUser=" + idUser +
                ", listCardLine=" + listCardLine +
                '}';
    }

    public boolean deleteCurrentCardLine() {
         boolean result = listCardLine.remove(currenCardLine);
        currenCardLine=null;
        return result;
    }
}
