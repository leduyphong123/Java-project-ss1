import java.util.Scanner;

import entity.*;
import service.*;
import service.impl.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static CategoryService categoryService = new CategoryServiceImpl();
    static CardService cardService = new CardServiceImpl();
    static OrderService orderService= new OrderServiceImpl();
    static int idUserDefault = 1;
    static int idCategoryDefault = 1;
    static int idProductDefault = 1;
    static int idCardDefault = 1;
    static int idOrderDefault = 1;

    public static void main(String[] args) {
        admin();
        homePage();
    }

    private static void homePage() {
        int key;
        do {
            menu();
            key = input.nextInt();
            input.nextLine();
            switch (key) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    if (userService.viewCurrentUserInfor() == null) {
                        System.out.println("Your no login");
                        login();
                    }
                    System.out.println(userService.viewCurrentUserInfor());
                    break;
                case 4:
                    System.out.println("-----CATEGORY PAGE-----");
                    pageCategorry();
                    break;
                case 5:
                    System.out.println("-----PRODUCT PAGE-----");
                    pageProduct();
                    break;
                case 6:
                    System.out.println("-----CARD PAGE-----");
                    cardOrderPage();
                    break;

                case 7:
                    showResult(userService.logout(), "logout");
                    break;
                case 8:
                    if (userService.viewCurrentUserInfor().getTypeUser() == "admin") {
                        userService.getAll();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("error key");
            }
        } while (key != 0);
    }

    private static void menu() {
        System.out.println("-----HOME PAGE-----");
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.Profile");
        System.out.println("4.Category");
        System.out.println("5.Product");
        System.out.println("6.Card");
        System.out.println("7.Logout");
        if (userService.viewCurrentUserInfor() != null) {
            if (userService.viewCurrentUserInfor().getTypeUser() == "admin") {
                System.out.println("8.List account");
            }
        }
        System.out.println("0.Exit");
    }

    private static void cardOrderPage() {
        int keyCard;
        do {
            System.out.println("1.Card list");
            System.out.println("2.Edit Card line");
            System.out.println("3.Order list");
            System.out.println("0.Exit");
            keyCard=input.nextInt();
            input.nextLine();
            switch (keyCard){
                case 1:
                    System.out.println("List card");
                    cardService.getCardCurrent().getListCardLine();
                    cardService.getCardCurrent().getTotal();
                    break;
                case 2:
                    subCardOrderPage();
                    break;
                case 3:
                    orderService.getAll();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("error key");
            }
        }while (keyCard!=0);
    }

    private static void subCardOrderPage() {
        System.out.println("input id card line");
        int temp=input.nextInt();
        input.nextLine();
        cardService.getCardCurrent().getListCardLine(temp);
        int keyCardLine;
        do {
            System.out.println("1.Augment one quantity");
            System.out.println("2.Reduce one quantity");
            System.out.println("3.Order");
            System.out.println("4.Delete card");
            System.out.println("0.Exit");
            keyCardLine=input.nextInt();
            input.nextLine();
            switch (keyCardLine){
                case 1:
                    cardService.getCardCurrent().getCurrenCardLine().augmentQuantity();
                    cardService.getCardCurrent().getListCardLine(temp);
                    break;
                case 2:
                    cardService.getCardCurrent().getCurrenCardLine().reduceQuantity();
                    cardService.getCardCurrent().getListCardLine(temp);
                    break;
                case 3:
                    System.out.println("input address");
                    CardLine cardLine=cardService.getCardCurrent().getCurrenCardLine();
                    boolean result= orderService.addOrderLine(cardLine,input.nextLine());
                    cardService.getCardCurrent().deleteCurrentCardLine();
                    System.out.println("order succes");
                    keyCardLine=0;
                    break;
                case 4:
                    if (cardService.getCardCurrent().deleteCurrentCardLine()){
                        System.out.println("Delete succes");
                        keyCardLine=0;
                    }else {
                        System.out.println("error");
                    }
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }while (keyCardLine!=0);
    }

    private static void pageProduct() {
        int keyProduct;
        do {
            System.out.println("1.Show List Product of Category");
            System.out.println("2.Show List Product all");
            System.out.println("3.Product add to card");
            if (userService.viewCurrentUserInfor() != null) {
                if (userService.viewCurrentUserInfor().getTypeUser() == "admin") {
                    System.out.println("4.New product");
                }
            }

            System.out.println("0.Exit");
            keyProduct = input.nextInt();
            input.nextLine();
            switch (keyProduct) {
                case 1:
                    if (showListCategory()) {
                        System.out.println("input id Category");
                        System.out.println("list product");
                        categoryService.showListProduct(input.nextInt());
                    }
                    break;
                case 2:
                    System.out.println("list product");
                    categoryService.showListProductAll();
                    break;
                case 3:
                    System.out.println("input id product");
                    boolean result = cardService.addCartLine(input.nextInt(),categoryService.getListCategory());
                    if (result){
                        System.out.println("Add Product succes");
                    }else {
                        System.out.println("Erorr No id Product");
                    }
                    break;
                case 4:
                    if (userService.viewCurrentUserInfor() != null) {
                        if (userService.viewCurrentUserInfor().getTypeUser() == "admin") {
                            addProduct();
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("error key");
            }
        } while (keyProduct != 0);
    }

    private static void pageCategorry() {
        int keyCategory;
        do {
            System.out.println("1.Show List Category");
            if (userService.viewCurrentUserInfor() != null) {
                if (userService.viewCurrentUserInfor().getTypeUser() == "admin") {
                    System.out.println("2.New Category");
                }
            }

            System.out.println("0.Exit");
            keyCategory = input.nextInt();
            input.nextLine();
            switch (keyCategory) {
                case 1:
                    showListCategory();
                    break;
                case 2:
                    if (userService.viewCurrentUserInfor() != null) {
                        if (userService.viewCurrentUserInfor().getTypeUser() == "admin") {
                            newCategory();
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("error key");
            }
        } while (keyCategory != 0);
    }

    private static boolean showListCategory() {
        if (categoryService.isEmtry()) {
            System.out.println("No Category");
            return false;
        } else {
            categoryService.getAll();
            return true;
        }
    }

    //Cart start

    private static void addListCart(int idUser) {
        if (!cardService.isCardIdUser(idUser)) {
            Card card = new Card(idCardDefault + 1, idUser);
            cardService.newCart(card);
        }

    }
    //Cart end

    //order start
    private static void addListOrder(int idUser) {
        if (!orderService.isCardIdUser(idUser)) {
            Order order = new Order(idOrderDefault + 1, idUser);
            orderService.newOrder(order);
        }

    }
    //order end
    //Product start
    private static void addProduct() {
        System.out.println("-----add Product----- ");
        System.out.print("input name product: ");
        String nameProduct = input.nextLine();
        System.out.print("input price product: ");
        long priceProduct = input.nextLong();
        System.out.println("List Category");
        categoryService.getAll();
        System.out.println("Select and input id Category");
        int idCategory = input.nextInt();
        Product product = new Product(idProductDefault, nameProduct, priceProduct);
        categoryService.addProduct(idCategory, product);
        categoryService.showListProduct(idCategory);
        idProductDefault += 1;
    }

    //Product end
    //Category start
    private static void newCategory() {
        System.out.println("-----New Category----- ");
        System.out.print("input name category: ");
        String nameCategory = input.nextLine();
        Category category = new Category(idCategoryDefault, nameCategory);
        boolean result = categoryService.newCategory(category);
        if (result) {
            idCategoryDefault += 1;
        }
        showResult(result, "New Category");
    }

    //Category end
// user start
    private static void register() {
        boolean result = false;
        do {
            System.out.println("-----REGISTER----- ");
            System.out.print("input userName: ");
            String userName = input.nextLine();
            System.out.print("input passWord: ");
            String passWord = input.nextLine();
            User user = new User(idUserDefault, userName, passWord);
            result = userService.register(user);
            showResult(result, "register");
            if (result) {
                idUserDefault += 1;
            } else {
                System.out.println("username exist or password <8");
            }
        } while (!result);

    }

    private static void login() {
        System.out.println("-----LOGIN----- ");
        System.out.print("input userName: ");
        String userName = input.nextLine();
        System.out.print("input passWord: ");
        String passWord = input.nextLine();
        boolean result = userService.login(userName, passWord);
        if (result) {
            addListCart(userService.viewCurrentUserInfor().getId());
            addListOrder(userService.viewCurrentUserInfor().getId());
        }
        showResult(result, "login");
    }
//user end

    //admin start
    private static void admin() {
        User user = new User(idUserDefault, "admin", "admin123");
        user.setTypeUser("admin");
        userService.register(user);
        idUserDefault += 1;
    }

    //admin end
    private static void showResult(boolean result, String element) {
        if (result) {
            System.out.println("your " + element + " succes");
        } else {
            System.out.println("your " + element + " error");
        }
    }
}