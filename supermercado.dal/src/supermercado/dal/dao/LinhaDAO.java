package supermercado.dal.dao;


import javax.enterprise.context.RequestScoped;

import supermercado.dal.dao.interfaces.ILinhaDAO;
import supermercado.dal.entidade.Linha;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class LinhaDAO 
	extends JPAGenericDAO<Linha, Short>
	implements ILinhaDAO{


	
}
