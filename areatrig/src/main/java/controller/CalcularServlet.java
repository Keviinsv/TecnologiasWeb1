package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.CalculadoraArea;
import model.TrianguloBean;

@WebServlet(name="CalcularServlet", urlPatterns={ "/servlets/CalcularServlet" })
public class CalcularServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String operation = request.getParameter("operation");
    float base = Float.parseFloat(request.getParameter("base"));
    float altura = Float.parseFloat(request.getParameter("altura"));
    float result = 0;

    switch(operation)
    {
      case "AREA":
        CalculadoraArea calculadora = new CalculadoraArea();
        TrianguloBean bean = new TrianguloBean();

        bean.setArea(calculadora.obtenerAreaTriangulo(base, altura));

        request.setAttribute("Resultado", bean);
        operation = "*";
        break;
    }

    request.getRequestDispatcher("../view/resultado.jsp").forward(request, response);
  }
}
