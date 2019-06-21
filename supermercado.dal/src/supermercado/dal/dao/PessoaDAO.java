package supermercado.dal.dao;

import javax.enterprise.context.RequestScoped;	

import supermercado.dal.dao.interfaces.IPessoaDAO;
import supermercado.dal.entidade.Pessoa;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class PessoaDAO 
	extends JPAGenericDAO<Pessoa, Integer>
	implements IPessoaDAO{


	
}