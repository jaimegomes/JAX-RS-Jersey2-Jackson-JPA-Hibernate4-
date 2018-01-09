package br.com.netprecision.prova.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.netprecision.prova.dao.OrderDAOImpl;

/**
 * @author Jaime
 *
 */
@Path("/products")
public class OrderResource {

	private OrderDAOImpl orderDAOImpl;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/criarPedido")
	public long criarPedido() throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.criarPedido();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/adicioneProdutoNoPedido/{id_pedido}/{cd_produto}/{qt_produto}")
	public byte adicioneProdutoNoPedido(@PathParam("id_pedido") long id_pedido,
			@PathParam("cd_produto") String cd_produto, @PathParam("qt_produto") int qt_produto) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.adicioneProdutoNoPedido(id_pedido, cd_produto, qt_produto);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/retireProdutoDoPedido/{id_pedido}/{cd_produto}/{qt_retirada}")
	public byte retireProdutoDoPedido(@PathParam("id_pedido") long id_pedido,
			@PathParam("cd_produto") String cd_produto, @PathParam("qt_retirada") int qt_retirada) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.retireProdutoDoPedido(id_pedido, cd_produto, qt_retirada);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/calculePrecoTotalPedido/{id_pedido}")
	public float calculePrecoTotalPedido(@PathParam("id_pedido") long id_pedido) throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.calculePrecoTotalPedido(id_pedido);
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/fechePedido/{id_pedido}/{vl_pagamento}")
	public float fechePedido(@PathParam("id_pedido") long id_pedido, @PathParam("vl_pagamento") float vl_pagamento)
			throws Exception {
		orderDAOImpl = new OrderDAOImpl();
		return orderDAOImpl.fechePedido(id_pedido, vl_pagamento);

	}

	// TODO PROBELA NO @QueryParam com o map, ver como resolver
	/*
	 * @GET
	 * 
	 * @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 * 
	 * @Path("/calculePrecoTotalPedido/") public float
	 * calculePrecoTotalPedido(@QueryParam("produtos") Map<String, Integer>
	 * produtos) throws Exception { orderDAOImpl = new OrderDAOImpl(); return
	 * orderDAOImpl.calculePrecoTotalPedido(produtos); }
	 */

}
