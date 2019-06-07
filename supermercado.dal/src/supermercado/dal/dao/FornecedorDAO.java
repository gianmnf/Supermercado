package supermercado.dal.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import supermercado.dal.dao.interfaces.IFornecedorDAO;
import supermercado.dal.entidade.Fornecedor;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class FornecedorDAO
		extends JPAGenericDAO<Fornecedor, Short>
		implements IFornecedorDAO {

	@Override
	public List<Fornecedor> findByFornecedor(String nomeFornecedor) {
		
		TypedQuery<Fornecedor> query =
					em.createQuery("select f from Fornecedor as f where f.marca.descricao = :nomeFornecedor order by f.marca.descricao",Fornecedor.class);
		
		query.setParameter("nomeFornecedor", nomeFornecedor);
		
		return query.getResultList();
	}

	
}
