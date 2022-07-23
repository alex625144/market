package com.market.entity;

import java.util.ArrayList;
import java.util.List;

public final class Repositary {

    private static Repositary INSTANCE;

        static User user1 = new User(1,"Rod", "Johnson", 100.0);
        static User user2 = new User(2,"James", "Gosling", 100.0);
        static User user3 = new User(3,"Robert", "Martin", 100.0);
        static Product product1 = new Product(1, "Java Language Specification", 20.0);
        static Product product2 = new Product(2, "Professional Java Development with the Spring Framework", 30.0);
        static Product product3 = new Product(3, "Clean Code", 40.0);
        static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        Repositary.productList = productList;
    }

    public Repositary(){

    }
    public static Repositary getInstance()  {
        if (INSTANCE == null) {
            INSTANCE = new Repositary();
        }
        return  INSTANCE;
    }

    public static User getUser1() {
        return user1;
    }

    public static void setUser1(User user1) {
        Repositary.user1 = user1;
    }

    public static User getUser2() {
        return user2;
    }

    public static void setUser2(User user2) {
        Repositary.user2 = user2;
    }

    public static User getUser3() {
        return user3;
    }

    public static void setUser3(User user3) {
        Repositary.user3 = user3;
    }

    public static Product getProduct1() {
        return product1;
    }

    public static void setProduct1(Product product1) {
        Repositary.product1 = product1;
    }

    public static Product getProduct2() {
        return product2;
    }

    public static void setProduct2(Product product2) {
        Repositary.product2 = product2;
    }

    public static Product getProduct3() {
        return product3;
    }

    public static void setProduct3(Product product3) {
        Repositary.product3 = product3;
    }
}
