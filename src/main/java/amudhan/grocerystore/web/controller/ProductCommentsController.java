package amudhan.grocerystore.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import amudhan.grocerystore.business.entities.Product;
import amudhan.grocerystore.business.services.ProductService;

public class ProductCommentsController implements ParentController {

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response,
      ServletContext servletContext, ITemplateEngine templateEngine) throws Exception {
    final Integer prodId = Integer.valueOf(request.getParameter("prodId"));
    final ProductService productService = new ProductService();
    final Product product = productService.findById(prodId);
    final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
    ctx.setVariable("prod", product);

    templateEngine.process("product/comments", ctx, response.getWriter());
  }

}
