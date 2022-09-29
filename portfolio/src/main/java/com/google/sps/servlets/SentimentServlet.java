// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sentiment")
public class SentimentServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String message = request.getParameter("q1");

    Document doc =
        Document.newBuilder().setContent(message).setType(Document.Type.PLAIN_TEXT).build();
    LanguageServiceClient languageService = LanguageServiceClient.create();
    Sentiment sentiment = languageService.analyzeSentiment(doc).getDocumentSentiment();
    float score = sentiment.getScore();
    languageService.close();

    // Output the sentiment score as HTML.
    // A real project would probably store the score alongside the content.
    response.setContentType("text/html;");
    String m;
    if(score > .7){
        m = "The sentiment of the message was extremely positive.";
    }
    else if(score>0){
        m = "The sentiment of the message was relatively positive";

    }
    else if(score > -.7){
        m = "The sentiment of the message was relatively negative";
    }
    else{
        m = "The sentiment of the message was extremely negative.";
    }
    //response.getWriter().println("<p>You entered: " + message + "</p>");
   /* response.getWriter().println(    "<link rel=\"stylesheet\" href=\"style.css\">"    );
    response.getWriter().println( "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css\">");

    response.getWriter().println( "<div id=\"personal\" data-aos=\"zoom-out-up\"><div class=\"center\"><h1>Sentient Analysis Score: "
    +score+"</h1>"+
    "<p>"+m+"</p>"+
    "<a href=\"http://pminchu-sps-summer22.appspot.com/proj.html\"><button class=\"but\" ><i class=\"bi bi-backspace\"></i></button></a>"+
    "</div></div");*/
    response.getWriter().println(score );
    //response.getWriter().println("<p><a href=\"/\">Back</a></p>");
  }
  

}
