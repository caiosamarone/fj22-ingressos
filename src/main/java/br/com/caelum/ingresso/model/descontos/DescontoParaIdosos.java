package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaIdosos implements Desconto{

	BigDecimal menos5reais = new BigDecimal("5.0");
	@Override
	public BigDecimal aplicaDesconto(BigDecimal precoOriginal) {
				return precoOriginal.subtract(menos5reais);
	}

}
