/**
 * 
 */
package br.com.netprecision.prova.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jaime
 *
 */
@Entity
@Table(name = "order")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrder")
	private List<ProductEntity> products;
	@Column(name = "finalPrice")
	private float finalPrice;

	public OrderEntity() {
	}

	/**
	 * @param products
	 * @param finalPrice
	 */
	public OrderEntity(List<ProductEntity> products, float finalPrice) {
		super();
		this.products = products;
		this.finalPrice = finalPrice;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the products
	 */
	public List<ProductEntity> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	/**
	 * @return the finalPrice
	 */
	public float getFinalPrice() {
		return finalPrice;
	}

	/**
	 * @param finalPrice
	 *            the finalPrice to set
	 */
	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", products=" + products + ", finalPrice=" + finalPrice + "]";
	}

}
