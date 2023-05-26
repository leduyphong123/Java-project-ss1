import java.util.Scanner;

import entity.*;
import service.*;
import service.impl.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static CategoryService categoryService = new CategoryServiceImpl();
    static int idUserDefault = 0;
    static int idCategoryDefault = 0;
    static  int idProductDefault=0;

    public static void main(String[] args) {
//        register();
//        login();
//        userService.getAll(); list user
//        System.out.println(userService.viewCurrentUserInfor()); get current user
newCategory();
        addProduct();

    }

    //Product start
    private static void addProduct(){
        System.out.println("-----add Product----- ");
        System.out.print("input name product: ");
        String nameProduct = input.nextLine();
        System.out.print("input price product: ");
        long priceProduct = input.nextLong();
        System.out.println("List Category");
        categoryService.getAll();
        System.out.println("Select and input id Category");
        int idCategory= input.nextInt();
        Product product = new Product(idProductDefault+1,nameProduct,priceProduct);
        categoryService.addProduct(idCategory,product);
        categoryService.showListProduct(idCategory);
    }
    //Product end
    //Category start
    private static void newCategory(){
        System.out.println("-----New Category----- ");
        System.out.print("input name category: ");
        String nameCategory = input.nextLine();
        Category category = new Category(idCategoryDefault+1, nameCategory);
        boolean result=categoryService.newCategory(category);
        showResult(result,"New Category");
    }
    //Category end
// user start
    private static void register() {
        System.out.println("-----REGISTER----- ");
        System.out.print("input userName: ");
        String userName = input.nextLine();
        System.out.print("input passWord: ");
        String passWord = input.nextLine();
        User user = new User(idUserDefault + 1, userName, passWord);
        boolean result = userService.register(user);
        showResult(result, "register");
    }

    private static void login() {
        System.out.println("-----LOGIN----- ");
        System.out.print("input userName: ");
        String userName = input.nextLine();
        System.out.print("input passWord: ");
        String passWord = input.nextLine();
        boolean result = userService.login(userName, passWord);
        showResult(result, "login");
    }
//user end



    private static void showResult(boolean result, String element) {
        if (result) {
            System.out.println("your " + element + " succes");
        } else {
            System.out.println("your " + element + " error");
        }
    }
}