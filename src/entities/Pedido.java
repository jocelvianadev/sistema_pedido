package entities;

import java.util.Date;

import entities.enums.PedidoStatus;

public class Pedido {
	private Date momento;
	private PedidoStatus status;
	
	//Construtor padrão vazio
	public Pedido() {}

	//Construtor padrão com argumentos
	public Pedido(Date momento, PedidoStatus status) {
		this.momento = momento;
		this.status = status;
	}
	//Getters e Setters

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
	
	
}
