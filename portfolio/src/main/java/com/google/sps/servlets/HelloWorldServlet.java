package com.google.sps.servlets;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    String[] facts = new String[]{"I have had surgery 3 times", "I can speak 5 languages", "My favorite sport is basketball"};


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


    Gson gson = new Gson();
    String json = gson.toJson(facts);
    response.setContentType("text/html;");
    response.getWriter().println(json);
    //response.getWriter().println("<p>This is my secret webpage<p>");
  }
}
