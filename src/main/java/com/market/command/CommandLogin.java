package com.market.command;

import com.market.Path;

import javax.servlet.http.HttpServletRequest;

public class CommandLogin implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter("command");
        return Path.PAGE_LOGIN;

    }
}