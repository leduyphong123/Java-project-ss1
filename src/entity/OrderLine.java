package entity;

public class OrderLine {
    private int idOrderLine;
    private int idProduct;
    private long subTotal;
    private int quantity;
    private String adress;


    public int getIdOrderLine() {
        return idOrderLine;
    }

    public void setIdOrderLine(int idOrderLine) {
        this.idOrderLine = idOrderLine;
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

    public OrderLine(int idOrderLine, int idProduct, long subTotal, int quantity, String adress) {
        this.idOrderLine = idOrderLine;
        this.idProduct = idProduct;
        this.subTotal = subTotal;
        this.quantity = quantity;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "idOrderLine=" + idOrderLine +
                ", idProduct=" + idProduct +
                ", subTotal=" + subTotal +
                ", quantity=" + quantity +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public OrderLine() {
    }


}
