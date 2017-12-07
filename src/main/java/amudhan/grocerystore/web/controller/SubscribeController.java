package amudhan.grocerystore.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

public class SubscribeController implements ParentController {

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response,
      ServletContext servletContext, ITemplateEngine templateEngine) throws Exception {
    WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
    templateEngine.process("subscribe", ctx, response.getWriter());
  }

}
