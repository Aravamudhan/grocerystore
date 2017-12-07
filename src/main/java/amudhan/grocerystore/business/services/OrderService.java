package amudhan.grocerystore.business.services;

import java.util.List;

import amudhan.grocerystore.business.entities.Order;
import amudhan.grocerystore.business.entities.repositories.OrderRepository;

public class OrderService {

  public List<Order> findAll() {
    return OrderRepository.getInstance().findAll();
  }

  public Order findById(final Integer id) {
    return OrderRepository.getInstance().findById(id);
  }

  public List<Order> findByCustomerId(final Integer customerId) {
    return OrderRepository.getInstance().findByCustomerId(customerId);
  }
}
