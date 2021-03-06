package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {

	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Sessao sessao){
		manager.persist(sessao);
	}
	public List<Sessao> buscaSessoesDaSala(Sala sala){
		TypedQuery<Sessao> createQuery = manager.createQuery("select s from Sessao s where s.sala = :sala", Sessao.class);
		createQuery.setParameter("sala", sala);
		return createQuery.getResultList();
	}
	public List<Sessao> buscaSessoesDoFilme(Filme filme){
		TypedQuery<Sessao> createQuery = manager.createQuery("select s from Sessao s where s.filme= :filme", Sessao.class);
		createQuery.setParameter("filme", filme);
		return createQuery.getResultList();
	}

	public Sessao findOne(Integer id){
		return manager.find(Sessao.class,id);
	}
}
