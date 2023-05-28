package service;

import entity.Category;
import entity.Product;

import java.util.List;

public interface CategoryService {
    boolean newCategory(Category category);

    void getAll();

    boolean addProduct(int idCategory, Product product);

    void showListProduct(int idCategory);

    boolean isEmtry();

    void showListProductAll();
    List<Category> getListCategory();
}
