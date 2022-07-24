package com.market.command;

import com.market.Path;
import com.market.entity.Product;
import com.market.entity.Request;
import com.market.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandBuy implements Command {

    static User user1 = new User(1, "Rod", "Johnson", 100.0);
    static User user2 = new User(2, "James", "Gosling", 100.0);
    static User user3 = new User(3, "Robert", "Martin", 100.0);
    Product product1 = new Product(1, "Java Language Specification", 20.0);
    Product product2 = new Product(2, "Professional Java Development with the Spring Framework", 30.0);
    Product product3 = new Product(3, "Clean Code", 40.0);
    List<Integer> list = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, List<Integer>> mapProduct = new HashMap<>();

    public Map<Integer, List<Integer>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<Integer>> map) {
        this.map = map;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String userIdNotValidateMessage = "";
        String productIdNotValidateMessage = "";
        String dontHaveMoneyMessage = "";

        request.getSession().setAttribute("userIdNotValidateMessage", userIdNotValidateMessage);
        request.getSession().setAttribute("productIdNotValidateMessage", productIdNotValidateMessage);
        request.getSession().setAttribute("dontHaveMoney", dontHaveMoneyMessage);

        String command = request.getParameter("command");
        String listed = request.getParameter("list");

        if (listed.equals("user_id")) {
            List<Request> listed1 = new ArrayList<>();
            for (Integer key : map.keySet()
            ) {
                List<Integer> newList = map.get(key);
                for (int i = 0; i < newList.size(); i++) {
                    Request request1 = new Request(key, newList.get(i));
                    listed1.add(request1);
                }

            }
            request.getSession().setAttribute("list1", map.get(1));
            request.getSession().setAttribute("list2", map.get(2));
            request.getSession().setAttribute("list3", map.get(3));
            return Path.LIST_USERID;
        }
        if (listed.equals("product_id")) {
            request.getSession().setAttribute("list1", mapProduct.get(1));
            request.getSession().setAttribute("list2", mapProduct.get(2));
            request.getSession().setAttribute("list3", mapProduct.get(3));
            return Path.LIST_PRODUCTID;
        }

        if (command.equals("buy")) {
            Integer userId = Integer.valueOf(request.getParameter("userId"));
            Integer productId = Integer.valueOf(request.getParameter("productId"));

            if (userId < 1 | userId > 3) {
                userIdNotValidateMessage = "UserID incorrect, please enter from 1 to 3!";
                request.getSession().setAttribute("userIdNotValidateMessage", userIdNotValidateMessage);
            }
            if (productId < 1 | productId > 3) {
                productIdNotValidateMessage = "ProductID incorrect, please enter from 1 to 3!";
                request.getSession().setAttribute("productIdNotValidateMessage", productIdNotValidateMessage);
            }
            if (userIdNotValidateMessage.length() > 0 | productIdNotValidateMessage.length() > 0) {
                return Path.PAGE_HOME;
            }

            Double price = 0.0;
            if (productId == 1) {
                price = product1.getPrice();
            } else if (productId == 2) {
                price = product2.getPrice();
            } else if (productId == 3) {
                price = product3.getPrice();
            }

            Double money = 0.0;
            if (userId == 1) {
                money = user1.getMoney();
            } else if (userId == 2) {
                money = user2.getMoney();
            } else if (userId == 3) {
                money = user3.getMoney();
            }

            if (money >= price) {
                if (userId.equals(1)) {
                    user1.setMoney(user1.getMoney() - price);
                    map.computeIfAbsent(1, k -> new ArrayList<>()).add(productId);
                } else if (userId.equals(2)) {
                    System.out.println("two");
                    user2.setMoney(user2.getMoney() - price);
                    map.computeIfAbsent(2, k -> new ArrayList<>()).add(productId);
                } else if (userId.equals(3)) {
                    System.out.println("three");
                    user3.setMoney(user3.getMoney() - price);
                    map.computeIfAbsent(3, k -> new ArrayList<>()).add(productId);
                }
                if (productId.equals(1)) {
                    mapProduct.computeIfAbsent(1, k -> new ArrayList<>()).add(userId);
                } else if (productId.equals(2)) {
                    mapProduct.computeIfAbsent(2, k -> new ArrayList<>()).add(userId);
                } else if (productId.equals(3)) {
                    mapProduct.computeIfAbsent(2, k -> new ArrayList<>()).add(userId);
                }

                return Path.PAGE_SUCCESS_BUY;
            } else {
                dontHaveMoneyMessage = "You don't have money";
                request.getSession().setAttribute("dontHaveMoneyMessage", dontHaveMoneyMessage);
                return Path.PAGE_DONT_MONEY;
            }

        }
        return Path.PAGE_SUCCESS_BUY;
    }


}
