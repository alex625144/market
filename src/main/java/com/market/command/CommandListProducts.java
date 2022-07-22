package com.market.command;

import com.market.Path;

import javax.servlet.http.HttpServletRequest;

public class CommandListProducts implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter("command");


        return Path.LIST_PRODUCTS;

    }
}