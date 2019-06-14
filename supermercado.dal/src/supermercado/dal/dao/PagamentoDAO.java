package supermercado.dal.dao;

import javax.enterprise.context.RequestScoped;	

import supermercado.dal.dao.interfaces.IPagamentoDAO;
import supermercado.dal.entidade.MetodoPagamento;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class PagamentoDAO extends JPAGenericDAO<MetodoPagamento, Short>
implements IPagamentoDAO{

}
