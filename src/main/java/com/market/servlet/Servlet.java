package com.market.servlet;

import com.market.command.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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

        if (name == null) {
            String path = request.getRequestURI();
            request.getRequestDispatcher(path).forward(request, response);
        }

        String path = request.getRequestURI();
        path = path.replaceAll(".*/market_war_exploded/", "");
        Command command = commands.getOrDefault(name, (r) -> "/index.jsp");
        String page = command.execute(request);

        if (page.contains("redirect:")) {
            response.sendRedirect(page.replaceAll("redirect:", "/market_war_exploded"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    public void destroy() {
    }
}