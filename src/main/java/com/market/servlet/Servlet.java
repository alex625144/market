package com.market.servlet;

import com.market.command.Command;
import com.market.command.CommandListProducts;
import com.market.command.CommandListUsers;
import com.market.command.CommandLogin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {
        commands.put("listUsers", new CommandListUsers());
        commands.put("listProducts", new CommandListProducts());
        commands.put("login", new CommandLogin());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String name = request.getParameter("command");
        System.out.println("name " + name);
        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/market_war_exploded/" , "");
        Command command = commands.getOrDefault(path , (r)->"/index.jsp");
        String page = command.execute(request);

        if(page.contains("redirect:")) {
            System.out.println("redirect ");
            response.sendRedirect(page.replaceAll("redirect:", "/market_war_exploded"));
        } else {
            System.out.println("forward");
            System.out.println(page);
            request.getRequestDispatcher(page).forward(request,response);
        }
    }

    public void destroy() {
    }
}