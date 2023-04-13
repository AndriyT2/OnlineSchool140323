package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;
import models.Person;
import osHibernate.PersonEntity;

import java.io.IOException;
import java.util.List;

@WebServlet("/person")
public class PersonController extends HttpServlet {

    AmySQLForServlet data = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PersonEntity> personList = data.personGetAll();
        req.setAttribute("persons", personList);
        req.getRequestDispatcher("person.jsp").forward(req, resp);
    }
}
