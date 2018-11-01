package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;


public class DescontoTest {
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		Lugar lugar = new Lugar ("A",1);
		Sala sala = new Sala("Sala 01", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120), "Comedia", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("32.50");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	@Test
	//deve conceder 30 porcento de desconto para ingresso de cliente de Bancos
	public void deveConcederDescontoParaBanco(){
		Lugar lugar = new Lugar ("A",1);
		Sala sala = new Sala("Sala 01", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120), "Comedia", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.BANCO,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("22.75");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	//deve conceder 50 porcento de desconto para ingresso de Estudantes
	public void deveConcederDescontoParaEstudante(){
		Lugar lugar = new Lugar ("A",1);
		Sala sala = new Sala("Sala 01", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120), "Comedia", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	//deve conceder 5 reais de desconto para ingresso de Idosos
	public void deveConcederDescontoParaIdosos(){
		Lugar lugar = new Lugar ("A",1);
		Sala sala = new Sala("Sala 01", new BigDecimal("20.5"));
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120), "Comedia", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.IDOSO,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("27.50");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
