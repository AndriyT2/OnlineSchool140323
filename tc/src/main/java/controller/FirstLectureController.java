package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;

import java.io.IOException;

@WebServlet("/first_lecture")
public class FirstLectureController extends HttpServlet {
    AmySQLForServlet l = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lecture", l.firstLecture());
        req.getRequestDispatcher("/firsLecture.jsp").forward(req, resp);
    }
}
