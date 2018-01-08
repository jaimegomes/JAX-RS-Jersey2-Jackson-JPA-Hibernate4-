/**
 * 
 */
package br.com.netprecision.prova.dao;

import java.util.Map;

/**
 * Interface OrderDAO
 * 
 * @author Jaime
 *
 */
public interface OrderDAO {

	public long criarPedido() throws Exception;

	public byte adicioneProdutoNoPedido(long id_pedido, String cd_produto, int qt_produto) throws Exception;

	public byte retireProdutoDoPedido(long id_pedido, String cd_produto, int qt_retirada) throws Exception;

	public float calculePrecoTotalPedido(long id_pedido) throws Exception;

	public float fechePedido(long id_pedido, float vl_pagamento) throws Exception;

	public float calculePrecoTotalPedido(Map<String, Integer> produtos) throws Exception;
}
