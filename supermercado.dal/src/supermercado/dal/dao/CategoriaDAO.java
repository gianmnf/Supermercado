package supermercado.dal.dao;

import javax.enterprise.context.RequestScoped;

import supermercado.dal.dao.interfaces.ICategoriaDAO;
import supermercado.dal.entidade.Categoria;
import supermercado.dal.generics.JPAGenericDAO;

@RequestScoped
public class CategoriaDAO 
	extends JPAGenericDAO<Categoria, Short>
	implements ICategoriaDAO{


	
}
