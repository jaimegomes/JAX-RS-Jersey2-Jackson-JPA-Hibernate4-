package br.com.netprecision.prova.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private long id;
	private String cdProduct;
	private String product;
	private float price;
	private OrderEntity idOrder;

	public Product() {

	}

	public Product(long id, String cdProduct, String product, float price, OrderEntity idOrder) {
		super();
		this.id = id;
		this.cdProduct = cdProduct;
		this.product = product;
		this.price = price;
		this.idOrder = idOrder;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCdProduct() {
		return cdProduct;
	}

	public void setCdProduct(String cdProduct) {
		this.cdProduct = cdProduct;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public OrderEntity getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(OrderEntity idOrder) {
		this.idOrder = idOrder;
	}

}
