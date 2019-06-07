package supermercado.dal.dao;


import javax.enterprise.context.RequestScoped;

import supermercado.dal.dao.interfaces.IMarcaDAO;
import supermercado.dal.entidade.Marca;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class MarcaDAO 
	extends JPAGenericDAO<Marca, Short>
	implements IMarcaDAO{


	
}
