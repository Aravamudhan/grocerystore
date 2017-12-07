package amudhan.grocerystore.business.services;

import java.util.List;

import amudhan.grocerystore.business.entities.Product;
import amudhan.grocerystore.business.entities.repositories.ProductRepository;

public class ProductService {
  public List<Product> findAll() {
    return ProductRepository.getInstance().findAll();
  }

  public Product findById(final Integer id) {
    return ProductRepository.getInstance().findById(id);
  }
}
