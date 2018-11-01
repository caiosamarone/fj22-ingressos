package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Desconto;
import br.com.caelum.ingresso.model.descontos.DescontoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoParaEstudantes;
import br.com.caelum.ingresso.model.descontos.DescontoParaIdosos;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public enum TipoDeIngresso {
INTEIRO(new SemDesconto()),
ESTUDANTE(new DescontoParaEstudantes()),
BANCO(new DescontoParaBancos()),
IDOSO(new DescontoParaIdosos());

	private final Desconto desconto;
	
	 TipoDeIngresso(Desconto desconto){
		 this.desconto = desconto;
	 }
	 
	
	 public String getDescricao(){
		 return desconto.getDescricao();
	 }
	 
	 public BigDecimal aplicaDesconto(BigDecimal valor){
		 return desconto.aplicaDesconto(valor);
	 }
}
