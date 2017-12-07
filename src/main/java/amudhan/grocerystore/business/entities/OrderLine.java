package amudhan.grocerystore.business.entities;

import java.math.BigDecimal;

public class OrderLine {
  private Product product = null;
  private Integer amount = null;
  private BigDecimal purchasePrice = null;


  public OrderLine() {
    super();
  }


  public Product getProduct() {
    return this.product;
  }

  public void setProduct(final Product product) {
    this.product = product;
  }


  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount(final Integer amount) {
    this.amount = amount;
  }

  public BigDecimal getPurchasePrice() {
    return this.purchasePrice;
  }

  public void setPurchasePrice(final BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
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
    OrderLine other = (OrderLine) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (product == null) {
      if (other.product != null)
        return false;
    } else if (!product.equals(other.product))
      return false;
    if (purchasePrice == null) {
      if (other.purchasePrice != null)
        return false;
    } else if (!purchasePrice.equals(other.purchasePrice))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "OrderLine [product=" + product + ", amount=" + amount + ", purchasePrice="
        + purchasePrice + "]";
  }

}
