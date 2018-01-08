/**
 * 
 */
package br.com.netprecision.prova.resource;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.netprecision.prova.dao.OrderDAOImpl;

/**
 * @author Jaime
 *
 */
@Path("/products")
public class OrderResource {

	private OrderDAOImpl orderDAOImpl;

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/criarPedido")
	public long criarPedido() throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.criarPedido();
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/adicioneProdutoNoPedido/{id_pedido}/{cd_produto}/{qt_produto}")
	public byte adicioneProdutoNoPedido(@PathParam("id_pedido") long id_pedido,
			@PathParam("cd_produto") String cd_produto, @PathParam("qt_produto") int qt_produto) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.adicioneProdutoNoPedido(id_pedido, cd_produto, qt_produto);
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/retireProdutoDoPedido/{id_pedido}/{cd_produto}/{qt_retirada}")
	public byte retireProdutoDoPedido(@PathParam("id_pedido") long id_pedido,
			@PathParam("cd_produto") String cd_produto, @PathParam("qt_retirada") int qt_retirada) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.retireProdutoDoPedido(id_pedido, cd_produto, qt_retirada);
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/calculePrecoTotalPedido/{id_pedido}")
	public float calculePrecoTotalPedido(@PathParam("id_pedido") long id_pedido) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.calculePrecoTotalPedido(id_pedido);
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/fechePedido/{id_pedido}/{vl_pagamento}")
	public float fechePedido(@PathParam("id_pedido") long id_pedido, @PathParam("vl_pagamento") float vl_pagamento)
			throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.fechePedido(id_pedido, vl_pagamento);

	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/calculePrecoTotalPedido/")
	public float calculePrecoTotalPedido(Map<String, Integer> produtos) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.calculePrecoTotalPedido(produtos);
	}

}
