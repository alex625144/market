package com.market.servlet;

import com.market.command.*;
import com.market.entity.Product;
import com.market.entity.Repositary;
import com.market.entity.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


public class Servlet extends HttpServlet {



    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {
        commands.put("listUsers", new CommandListUsers());
        commands.put("listProducts", new CommandListProducts());
        commands.put("buy", new CommandBuy());
        commands.put("login", new CommandLogin());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String name = request.getParameter("command");
        System.out.println("COMMAND " + name);

        if (name == null) {
            System.out.println("COMMAND NULL");
            System.out.println("PATH " +request.getRequestURI());
            String path = request.getRequestURI();
            request.getRequestDispatcher(path).forward(request,response);
        }

        String path = request.getRequestURI();
        System.out.println("PATH " + path);

        path = path.replaceAll(".*/market_war_exploded/" , "");
        Command command = commands.getOrDefault(name , (r)->"/index.jsp");
        String page = command.execute(request);
        System.out.println("PAGE " + page);

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