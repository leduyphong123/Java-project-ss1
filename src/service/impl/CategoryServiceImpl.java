package service.impl;

import entity.Category;
import entity.Product;
import service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    static List<Category> listCategory=new ArrayList<>();
    @Override
    public boolean newCategory(Category category) {
        if(category==null){
            return false;
        }
        listCategory.add(category);
        return true;
    }

    @Override
    public void getAll() {
        for(Category list:listCategory){
            System.out.println(list);
        }
    }

    @Override
    public boolean addProduct(int idCategory, Product product) {
        for (Category list: listCategory){
            if(list.getIdCategory()==idCategory){
                list.setListProduct(product);
                return true;
            }
        }
        return false;

    }

    @Override
    public void showListProduct(int idCategory) {
        for (Category list:listCategory){
            if (list.getIdCategory()==idCategory){
                for (Product listP : list.getListProduct()){
                    System.out.println(listP);
                }
            }
        }
    }


}
