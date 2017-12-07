package amudhan.grocerystore.business.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
  private Integer id = null;
  private String name = null;
  private BigDecimal price = null;
  private boolean inStock = false;
  private List<Comment> comments = new ArrayList<Comment>();


  public Product() {
    super();
  }


  public Product(final Integer id, final String name, final boolean inStock,
      final BigDecimal price) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.inStock = inStock;
  }


  public Integer getId() {
    return this.id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }


  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }


  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }


  public boolean isInStock() {
    return this.inStock;
  }

  public void setInStock(final boolean inStock) {
    this.inStock = inStock;
  }


  public List<Comment> getComments() {
    return this.comments;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + (inStock ? 1231 : 1237);
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (inStock != other.inStock)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (price == null) {
      if (other.price != null)
        return false;
    } else if (!price.equals(other.price))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", price=" + price + ", inStock=" + inStock
        + "]";
  }


}
