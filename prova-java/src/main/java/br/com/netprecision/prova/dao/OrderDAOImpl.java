package br.com.netprecision.prova.dao;

import java.util.Map;

import javax.persistence.EntityManager;

import br.com.netprecision.prova.app.JPAEntityManager;
import br.com.netprecision.prova.model.OrderEntity;
import br.com.netprecision.prova.model.ProductEntity;

public class OrderDAOImpl implements OrderDAO {

	private JPAEntityManager jpaEntityManager = new JPAEntityManager();
	private EntityManager entityManager = jpaEntityManager.getEntityManager();

	@Override
	public long criarPedido() throws Exception {
		try {
			OrderEntity order = new OrderEntity();
			entityManager.getTransaction().begin();
			OrderEntity entity = entityManager.merge(order);
			entityManager.flush();
			entityManager.getTransaction().commit();
			entityManager.close();
			return entity.getId();
		} catch (Exception e) {
			throw new Exception("Erro ao adicionar pedido. " + e.getMessage());
		}

	}

	@Override
	public byte adicioneProdutoNoPedido(long id_pedido, String cd_produto, int qt_produto) throws Exception {
		try {
			OrderEntity order = entityManager.find(OrderEntity.class, id_pedido);
			ProductEntity product = entityManager.find(ProductEntity.class, cd_produto);

			if (order == null) {
				return -1;
			} else if (product == null) {
				return -2;
			} else {
				for (int i = 0; i < qt_produto; i++) {
					order.getProducts().add(product);
					order.setFinalPrice(order.getFinalPrice() + product.getPrice());
				}

				entityManager.getTransaction().begin();
				entityManager.merge(order);
				entityManager.getTransaction().commit();
				entityManager.close();

				return 0;
			}

		} catch (Exception e) {
			throw new Exception("Erro ao adicionar produto ao pedido. " + e.getMessage());
		}
	}

	@Override
	public byte retireProdutoDoPedido(long id_pedido, String cd_produto, int qt_retirada) throws Exception {
		try {

			int qtProducts = 0;
			OrderEntity order = entityManager.find(OrderEntity.class, id_pedido);
			ProductEntity product = entityManager.find(ProductEntity.class, cd_produto);

			if (order == null) {
				return -1;

			} else if (product == null) {
				return -2;

			} else if (!order.getProducts().isEmpty()) {
				for (ProductEntity p : order.getProducts()) {

					if (p.getCdProduct().equals(cd_produto)) {
						order.getProducts().remove(p);
						order.setFinalPrice(order.getFinalPrice() - p.getPrice());
						qtProducts++;
					}

					if (qtProducts == qt_retirada) {
						break;
					}
				}
				entityManager.getTransaction().begin();
				entityManager.merge(order);
				entityManager.getTransaction().commit();
				entityManager.close();
				return 0;
			} else {
				return -9;
			}

		} catch (Exception e) {
			throw new Exception("Erro ao remover produto do pedido. " + e.getMessage());
		}
	}

	@Override
	public float calculePrecoTotalPedido(long id_pedido) throws Exception {
		try {
			OrderEntity order = entityManager.find(OrderEntity.class, id_pedido);
			entityManager.close();
			if (order == null) {
				return -1;
			} else {
				return order.getFinalPrice();
			}

		} catch (Exception e) {
			throw new Exception("Erro ao calcular preço total: " + e.getMessage());
		}
	}

	@Override
	public float fechePedido(long id_pedido, float vl_pagamento) throws Exception {
		try {
			OrderEntity order = entityManager.find(OrderEntity.class, id_pedido);
			entityManager.close();
			if (order == null) {
				return -1;
			} else if (order.getFinalPrice() > vl_pagamento) {
				return -2;
			} else {
				return vl_pagamento - order.getFinalPrice();
			}
		} catch (Exception e) {
			throw new Exception("Erro ao finalizar pedido. " + e.getMessage());
		}
	}

	@Override
	public float calculePrecoTotalPedido(Map<String, Integer> produtos) throws Exception {
		float totalPrice = 0f;

		for (String key : produtos.keySet()) {

			ProductEntity product = entityManager.find(ProductEntity.class, key);

			if (product == null) {
				return -2;
			} else {
				// trazer do banco de dados
				totalPrice += product.getPrice();
			}
		}
		return totalPrice;
	}

}
