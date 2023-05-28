package entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int idCategory;
    private String nameCategory;
    List<Product> listProduct = new ArrayList<>();

    public  List<Product> getListProduct() {
        return listProduct;
    }

    public  void setListProduct(Product product) {
        listProduct.add(product);
    }

    public Category(){}
    public Category(int idCategory,String nameCategory){
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
