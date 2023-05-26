package service;

import entity.Category;
import entity.Product;

public interface CategoryService {
    boolean newCategory(Category category);

    void getAll();

    boolean addProduct(int idCategory, Product product);

    void showListProduct(int idCategory);
}
