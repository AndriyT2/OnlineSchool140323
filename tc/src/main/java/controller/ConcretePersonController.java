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

@WebServlet(name = "ConcretePerson", urlPatterns = {"/concretePerson"})
public class ConcretePersonController extends HttpServlet {
    AmySQLForServlet data = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int personIdSQL = Integer.parseInt(req.getParameter("personIdSQL"));
        PersonEntity person = data.personById(personIdSQL);
        req.setAttribute("conPersons", person);
        req.getRequestDispatcher("concretePerson.jsp").forward(req, resp);
    }
}
