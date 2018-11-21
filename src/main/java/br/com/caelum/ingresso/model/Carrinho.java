package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
//component serve para dizer ao Spring que esta classe podera ser manipulada e injetada
//SessionScope serve para criar uma "Sessao" no java
@Component
@SessionScope
public class Carrinho {
	
	//ja cria uma lista de ingressos vazia (carrinho vazio).
	private List<Ingresso> ingressos = new ArrayList<>();
	
	
	//adiciona um ingresso no carrinho
	public void add(Ingresso ingresso){
		ingressos.add(ingresso);
	}


	public List<Ingresso> getIngressos() {
		return ingressos;
	}


	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	//verifica se um lugar ja esta no carrinho ou não e retorna um boolean
	public boolean isSelecionado(Lugar lugar){
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
	}
	
	//retorna o total a pagar (O stream utiliza a logica de um for. queremos apenas o Preco do ingresso
	//o reduce pega apenas um valor total e adiciona pra todos os outros precos. caso não tenha nada, 
	//retorna 0 para o Total
	public BigDecimal getTotal(){
		return ingressos.stream().map(Ingresso::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}
	
	public Compra toCompra(){
		return new Compra(ingressos);
	}
}
