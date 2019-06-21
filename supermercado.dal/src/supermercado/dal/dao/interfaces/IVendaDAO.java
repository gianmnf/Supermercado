package supermercado.dal.dao.interfaces;

import java.util.Date;	
import java.util.List;

import supermercado.dal.entidade.Venda;
import supermercado.dal.generics.IGenericDAO;

public interface IVendaDAO 
	extends IGenericDAO<Venda,Integer>{
	
	List<Venda> listar(Date data);
	List<?> listar(int ano);

}
