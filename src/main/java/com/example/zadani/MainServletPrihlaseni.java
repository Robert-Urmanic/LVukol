package com.example.zadani;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServletPrihlaseni", value = "/MainServletPrihlaseni")
public class MainServletPrihlaseni extends HttpServlet {
    int goodLog = 0;
    boolean isInNameDatabase = false;
    String errorMessage = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher("regALog.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            errorMessage = "";
            if (request.getParameter("jmenoPrihlaseni") != null && isInDatabase(request.getParameter("jmenoPrihlaseni"), request.getParameter("hesloPrihlaseni")) && Database.muzeSePrihlasit.get(Database.ucetJmeno.indexOf(request.getParameter("jmenoPrihlaseni")))) {
                goodLog++;
                request.setAttribute("pocet", goodLog);
                request.getRequestDispatcher("spravnePrihlaseni.jsp").forward(request, response);
            } else {
                int getIndex = 0;
                if (isInNameDatabase) {
                    getIndex = Database.ucetJmeno.indexOf(request.getParameter("jmenoPrihlaseni"));
                    Database.pocetPrihlaseni.set(getIndex, Database.pocetPrihlaseni.get(getIndex) + 1);
                    if (Database.pocetPrihlaseni.get(getIndex) > 2) {
                        Database.muzeSePrihlasit.set(getIndex, false);
                        errorMessage = " You cannot log in anymore, you failed way too many times.";
                    }
                }
                if (Database.pocetPrihlaseni.get(getIndex) != 0) {
                    errorMessage += " Number of failed logins: " + Database.pocetPrihlaseni.get(getIndex);
                }
                request.setAttribute("message", errorMessage);
                request.getRequestDispatcher("regALog.jsp").forward(request, response);
            }
        } catch (IndexOutOfBoundsException ex) {
            errorMessage = " Couldn't find your username in the database!";
            request.setAttribute("message", errorMessage);
            request.getRequestDispatcher("regALog.jsp").forward(request, response);
        }


        try (PrintWriter out = response.getWriter()) {

        }
    }


    public boolean isInDatabase(String name, String heslo) {
        for (String tempJ : Database.ucetJmeno) {
            if (name.equals(tempJ)) {
                isInNameDatabase = true;
            }
        }
        if (!isInNameDatabase) {
            throw new IndexOutOfBoundsException();
        }

        boolean isInDatabase = false;
        if (isInNameDatabase) {
            for (String tempJ : Database.ucetHeslo) {
                if (heslo.equals(tempJ)) {
                    isInDatabase = true;
                }
            }
        }
        if (!isInDatabase) {
            errorMessage += "The pasword you have typed is wrong.";
        }

        return isInDatabase;
    }

}
