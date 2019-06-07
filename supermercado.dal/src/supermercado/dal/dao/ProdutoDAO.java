package supermercado.dal.dao;


import javax.enterprise.context.RequestScoped;

import supermercado.dal.dao.interfaces.IProdutoDAO;
import supermercado.dal.entidade.Produto;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class ProdutoDAO 
	extends JPAGenericDAO<Produto, Integer>
	implements IProdutoDAO{


	
}
