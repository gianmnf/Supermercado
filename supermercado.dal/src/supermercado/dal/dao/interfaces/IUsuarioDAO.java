package supermercado.dal.dao.interfaces;

import supermercado.dal.entidade.*;
import supermercado.dal.generics.IGenericDAO;

public interface IUsuarioDAO 
	extends IGenericDAO<Usuario, Integer> {

	
	public Usuario porLoginSenha(String login, String senha);
	
}
