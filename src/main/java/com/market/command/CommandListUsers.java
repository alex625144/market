package com.market.command;

import javax.servlet.http.HttpServletRequest;
import com.market.Path;


public class CommandListUsers implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter("command");

        System.out.println("bingo");
        return "redirect:" + Path.LIST_USERS;

    }
}
