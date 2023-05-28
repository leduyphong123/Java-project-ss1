package entity;

public class CardLine {
    private int idCardLine;
    private int idProduct;
    private long price;
    private long subTotal;
    private int quantity;

    public CardLine(int idCard, int idProduct, long subTotal, int quantity,long price) {
        this.idCardLine = idCard;
        this.idProduct = idProduct;
        this.subTotal = subTotal;
        this.quantity = quantity;
        this.price=price;
    }

    public void augmentQuantity(){
        this.quantity+=1;
        this.subTotal=this.quantity*this.price;
    }
    public void reduceQuantity(){
        this.quantity-=1;
        this.subTotal=this.quantity*this.price;
    }
    public int getIdCardLine() {
        return idCardLine;
    }

    public void setIdCardLine(int idCardLine) {
        this.idCardLine = idCardLine;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CardLine{" +
                "idCard=" + idCardLine +
                ", idProduct=" + idProduct +
                ", subTotal=" + subTotal +
                ", quantity=" + quantity +
                '}';
    }
}
