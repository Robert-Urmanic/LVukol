package com.example.zadani;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {

    public void init() {
    }

    int wrongLog = 0;
    int goodLog = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            request.getRequestDispatcher("regALog.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("Ja jsem init ferko");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("jmenoRegistrace") != null && !(unique(request.getParameter("jmenoRegistrace")))) {
            Database.ucetJmeno.add(request.getParameter("jmenoRegistrace"));
            Database.ucetHeslo.add(request.getParameter("hesloRegistrace"));
            Database.pocetPrihlaseni.add(0);
            Database.muzeSePrihlasit.add(true);
            String message = "Succesfuly registered";
            request.setAttribute("message", message);
            request.setAttribute("jmenoAttribute", request.getParameter("jmenoRegistrace"));
            request.setAttribute("hesloAttribute", request.getParameter("hesloRegistrace"));
            request.getRequestDispatcher("regALog.jsp").forward(request, response);
            System.out.println("Ja se registruju");
        } else if (request.getParameter("jmenoRegistrace") == null || request.getParameter("hesloRegistrace") == null) {
            String message = "You have not entered any information";
            request.setAttribute("message", message);
            request.getRequestDispatcher("regALog.jsp").forward(request, response);
        } else if (unique(request.getParameter("jmenoRegistrace"))) {
            String message = "The name you have entered is alredy in use";
            request.setAttribute("message", message);
            request.getRequestDispatcher("regALog.jsp").forward(request, response);
        }

        if (request.getParameter("jmenoPrihlaseni") != null && isInDatabase(request.getParameter("jmenoPrihlaseni"), request.getParameter("hesloPrihlaseni"))) {
            goodLog++;
            request.setAttribute("pocet", goodLog);
            request.getRequestDispatcher("spravnePrihlaseni.jsp").forward(request, response);
        }


        try (PrintWriter out = response.getWriter()) {

        }


    }

    public void destroy() {
    }

    public boolean unique(String jmenoRegistrace) {
        boolean hasCopy = false;
        for (String tempJ : Database.ucetJmeno) {
            if (jmenoRegistrace.equals(tempJ)) {
                hasCopy = true;
                break;
            }
        }
        return hasCopy;
    }

    public boolean isInDatabase(String name, String heslo) {
        boolean isInDatabase = false;
        for (String tempJ : Database.ucetJmeno) {
            if (name.equals(tempJ)) {
                isInDatabase = true;
            }
        }
        if (isInDatabase) {
            isInDatabase = false;
            for (String tempJ : Database.ucetHeslo) {
                if (heslo.equals(tempJ)) {
                    isInDatabase = true;
                }
            }
        }

        return isInDatabase;
    }

}