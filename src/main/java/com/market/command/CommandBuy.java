package com.market.command;

import com.market.Path;
import com.market.entity.Product;
import com.market.entity.Repositary;
import com.market.entity.User;
import com.market.servlet.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class CommandBuy implements Command{
    static User user1 = new User(1,"Rod", "Johnson", 100.0);
    static User user2 = new User(2,"James", "Gosling", 100.0);
    static User user3 = new User(3,"Robert", "Martin", 100.0);
    Product product1 = new Product(1, "Java Language Specification", 20.0);
    Product product2 = new Product(2, "Professional Java Development with the Spring Framework", 30.0);
    Product product3 = new Product(3, "Clean Code", 40.0);
    List<Product> list = new ArrayList<>();


    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("CommandBUY");
        String userIdNotValidateMessage="";
        String productIdNotValidateMessage="";
        request.getSession().setAttribute("userIdNotValidateMessage",userIdNotValidateMessage);
        request.getSession().setAttribute("productIdNotValidateMessage",productIdNotValidateMessage);
        String command = request.getParameter("command");
        if(command.equals("buy")){
            Integer userId = Integer.valueOf(request.getParameter("userId"));
            Integer productId = Integer.valueOf(request.getParameter("productId"));
            System.out.println("userID " + userId);
            System.out.println("productID" + productId);

            if (userId < 1 | userId > 3){
                userIdNotValidateMessage = "UserID incorrect, please enter from 1 to 3!";
                request.getSession().setAttribute("userIdNotValidateMessage",userIdNotValidateMessage);
            }
            if(productId < 1 | productId > 3){
                productIdNotValidateMessage = "ProductID incorrect, please enter from 1 to 3!";
                request.getSession().setAttribute("productIdNotValidateMessage",productIdNotValidateMessage);
            }
            if(userIdNotValidateMessage.length() > 0 | productIdNotValidateMessage.length() > 0){
                return Path.PAGE_HOME;
            }


        }
        return  Path.PAGE_SUCCESS_BUY;
    }
}
