package amudhan.grocerystore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.ITemplateEngine;

import amudhan.grocerystore.business.entities.User;
import amudhan.grocerystore.web.application.GroceryStoreApplication;
import amudhan.grocerystore.web.controller.ParentController;

/**
 * Entry point of all requests to the store
 * 
 * @author amudhan
 *
 */
public class GroceryStoreFilter implements Filter {

  private ServletContext servletContext;

  private GroceryStoreApplication application;

  public GroceryStoreFilter() {
    super();
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.servletContext = filterConfig.getServletContext();
    this.application = new GroceryStoreApplication(servletContext);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    addUserToSession((HttpServletRequest) request);
    if (!process((HttpServletRequest) request, (HttpServletResponse) response)) {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

  private static void addUserToSession(final HttpServletRequest request) {
    // Simulate a real user session by adding a user object
    request.getSession(true).setAttribute("user", new User("John", "Apricot", "Antarctica", null));
  }

  /**
   * This method takes a request and performs initialization of templates and
   * 
   * @param request
   * @param response
   * @return
   */
  private boolean process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException {
    try {
      // This prevents triggering engine executions for resource URLs
      // resource URLs are handled by the default servlet provided the servlet container
      if (request.getRequestURI().startsWith("/css")
          || request.getRequestURI().startsWith("/images")
          || request.getRequestURI().startsWith("/favicon")) {
        return false;
      }
      ParentController controller = this.application.resolveControllerForRequest(request);
      if (controller == null) {
        return false;
      }
      // Get the template engine instance
      ITemplateEngine templateEngine = this.application.getTemplateEngine();
      /*
       * Write the response headers
       */
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("Pragma", "no-cache");
      response.setHeader("Cache-Control", "no-cache");
      response.setDateHeader("Expires", 0);
      /*
       * Execute the controller and process view template, writing the results to the response
       * writer.
       */
      controller.process(request, response, this.servletContext, templateEngine);
      return true;
    } catch (Exception e) {
      try {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      } catch (final IOException ignored) {
        // Just ignore this
      }
      throw new ServletException(e);
    }
  }

}
