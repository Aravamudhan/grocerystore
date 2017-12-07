package amudhan.grocerystore.business.services;

import java.util.List;

import amudhan.grocerystore.business.entities.Customer;
import amudhan.grocerystore.business.entities.repositories.CustomerRepository;

public class CustomerService {
  public List<Customer> findAll() {
    return CustomerRepository.getInstance().findAll();
  }

  public Customer findById(final Integer id) {
    return CustomerRepository.getInstance().findById(id);
  }
}
