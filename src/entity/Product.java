package entity;

public class Product {
    private int idProduct;
    private String nameProduct;
    private long priceProduct;
    public Product(){}
    public Product(int idProduct,String nameProduct, long priceProduct){
        this.idProduct=idProduct;
        this.nameProduct=nameProduct;
        this.priceProduct=priceProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(long priceProduct) {
        this.priceProduct = priceProduct;
    }
}
