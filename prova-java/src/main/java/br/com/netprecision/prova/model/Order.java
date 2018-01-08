package br.com.netprecision.prova.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

	private long id;
	private List<ProductEntity> products;
	private float finalPrice;
	private Boolean closed;

	public Order() {

	}

	public Order(long id, List<ProductEntity> products, float finalPrice, Boolean closed) {
		super();
		this.id = id;
		this.products = products;
		this.finalPrice = finalPrice;
		this.closed = closed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

}
