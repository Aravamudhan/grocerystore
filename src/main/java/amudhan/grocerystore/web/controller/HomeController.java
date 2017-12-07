package amudhan.grocerystore.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

public class HomeController implements ParentController {

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response,
      ServletContext servletContext, ITemplateEngine templateEngine) throws Exception {

    // A Thymeleaf context contains all the data required for an execution of the template engine.
    // The data is available in a variable map

    WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyy");
    LocalDate timeNow = LocalDate.now();
    String formattedDate = timeNow.format(formatter);
    ctx.setVariable("today", formattedDate);
    templateEngine.process("home", ctx, response.getWriter());
  }

}
