/**
 * 
 */
package br.com.netprecision.prova.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jaime
 *
 */
@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "cdProduct")
	private String cdProduct;
	@Column(name = "productName")
	private String product;
	@Column(name = "price")
	private float price;
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	@ManyToOne
	private OrderEntity idOrder;

	public ProductEntity() {
	}

	/**
	 * @param cdProduct
	 * @param product
	 * @param price
	 */
	public ProductEntity(String cdProduct, String product, float price) {
		super();
		this.cdProduct = cdProduct;
		this.product = product;
		this.price = price;
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
	 * @return the cdProduct
	 */
	public String getCdProduct() {
		return cdProduct;
	}

	/**
	 * @param cdProduct
	 *            the cdProduct to set
	 */
	public void setCdProduct(String cdProduct) {
		this.cdProduct = cdProduct;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the idOrder
	 */
	public OrderEntity getIdOrder() {
		return idOrder;
	}

	/**
	 * @param idOrder
	 *            the idOrder to set
	 */
	public void setIdOrder(OrderEntity idOrder) {
		this.idOrder = idOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [cdProduct=" + cdProduct + ", product=" + product + ", price=" + price + "]";
	}

}
