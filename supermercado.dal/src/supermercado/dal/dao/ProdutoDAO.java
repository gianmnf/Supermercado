package supermercado.dal.dao;

import supermercado.dal.dao.interfaces.IProdutoDAO;				
import supermercado.dal.entidade.Produto;
import supermercado.dal.generics.JPAGenericDAO;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ProdutoDAO extends JPAGenericDAO<Produto, Integer>
implements IProdutoDAO{

}
