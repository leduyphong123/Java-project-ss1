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
                if (list.getListProduct().size()==0){
                    System.out.println("No list product");
                    return;
                }
                for (Product listP : list.getListProduct()){
                    System.out.println(listP);
                }
            }
        }
    }

    @Override
    public boolean isEmtry() {
        if(listCategory.size()==0){
            return true;
        }
        return false;
    }

    @Override
    public void showListProductAll() {
        for (Category list:listCategory){
            for (Product listP : list.getListProduct()){
                System.out.println(listP);
            }
        }
    }

    @Override
    public List<Category> getListCategory(){
        return this.listCategory;
    }
}
