package amudhan.grocerystore.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import amudhan.grocerystore.business.entities.Order;
import amudhan.grocerystore.business.services.OrderService;

public class OrderDetailsController implements ParentController {

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response,
      ServletContext servletContext, ITemplateEngine templateEngine) throws Exception {
    final Integer orderId = Integer.valueOf(request.getParameter("orderId"));

    final OrderService orderService = new OrderService();
    final Order order = orderService.findById(orderId);

    final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
    ctx.setVariable("order", order);

    templateEngine.process("order/details", ctx, response.getWriter());
  }

}
