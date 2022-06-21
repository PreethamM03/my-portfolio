package com.google.sps.servlets;

import com.google.api.client.util.Key;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
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
    String name = Jsoup.clean(textValue[0], Safelist.none());
    String email = Jsoup.clean(textValue[1], Safelist.none());
    String phoneNumber = Jsoup.clean(textValue[2], Safelist.none());
    long timestamp = System.currentTimeMillis();


    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Person");

    FullEntity personEntity = 
    Entity.newBuilder(keyFactory.newKey())
        .set("Time", timestamp)
        .set("Name", name)
        .set("Email", email)
        .set("Phone Number", phoneNumber)
        .build();

        datastore.put(personEntity);
    // Print the value so you can see it in the server logs.
    System.out.println("Name submitted: " + textValue[0]+"  Email Submitted: " + textValue[1]+" Phone Number Submitted: " + textValue[2]);

    // Write the value to the response so the user can see it.
    //response.getWriter().println("Name submitted: " + textValue[0]+"\nEmail Submitted: " + textValue[1]+"\nPhone Number Submitted: " + textValue[2]);
    //response.sendRedirect("/contacts-list");
    response.sendRedirect("/index.html");



  }
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");



  }
}