package amudhan.grocerystore.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import amudhan.grocerystore.business.entities.Order;
import amudhan.grocerystore.business.services.OrderService;

public class OrderListController implements ParentController {

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response,
      ServletContext servletContext, ITemplateEngine templateEngine) throws Exception {
    final OrderService orderService = new OrderService();
    final List<Order> allOrders = orderService.findAll();

    final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
    ctx.setVariable("orders", allOrders);

    templateEngine.process("order/list", ctx, response.getWriter());
  }

}
