package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String[] textValue = request.getParameterValues("q1");

    // Print the value so you can see it in the server logs.
    System.out.println("Name submitted: " + textValue[0]+"  Email Submitted: " + textValue[1]+" Phone Number Submitted: " + textValue[2]);

    // Write the value to the response so the user can see it.
    //response.getWriter().println("Name submitted: " + textValue[0]+"\nEmail Submitted: " + textValue[1]+"\nPhone Number Submitted: " + textValue[2]);
    response.sendRedirect("/index.html");
  }
  /*@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");

  }*/
}