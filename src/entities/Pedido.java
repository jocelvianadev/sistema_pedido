package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.PedidoStatus;

public class Pedido {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private PedidoStatus status;
	
	//Composição/Associações
	private Cliente cliente;
	private List<ItemPedido> items = new ArrayList<ItemPedido>();
	
	//Construtor padrão vazio
	public Pedido() {}

	//Construtor padrão com argumentos
	public Pedido(Date momento, PedidoStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}
	//Getters e Setters

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}
	
	//=========================================
	//Métodos operacionais
	public void adicionarItem(ItemPedido item) {
		items.add(item);
	}
	
	public void removerItem(ItemPedido item) {
		items.remove(item);
	}
	
	public double total() {
		double soma = 0;
		for(ItemPedido item: items) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens pedidos: \n");
		for(ItemPedido item : items) {
			sb.append(item + "\n");
		}
		sb.append("Valor total: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
}
