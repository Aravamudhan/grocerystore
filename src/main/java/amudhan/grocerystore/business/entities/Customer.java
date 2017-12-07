package amudhan.grocerystore.business.entities;

import java.time.ZonedDateTime;

public class Customer {
  private Integer id = null;
  private String name = null;
  private ZonedDateTime customerSince = null;


  public Customer() {
    super();
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


  public ZonedDateTime getCustomerSince() {
    return this.customerSince;
  }

  public void setCustomerSince(final ZonedDateTime customerSince) {
    this.customerSince = customerSince;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", customerSince=" + customerSince + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((customerSince == null) ? 0 : customerSince.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Customer other = (Customer) obj;
    if (customerSince == null) {
      if (other.customerSince != null)
        return false;
    } else if (!customerSince.equals(other.customerSince))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
