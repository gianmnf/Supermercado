package supermercado.dal.dao;

import supermercado.dal.dao.interfaces.*;
import supermercado.dal.entidade.*;
import supermercado.dal.generics.*;

import javax.enterprise.context.*;

import javax.persistence.*;

import java.util.*;

@RequestScoped
public class UsuarioDAO 
		extends JPAGenericDAO<Usuario, Integer>
		implements IUsuarioDAO{

	@Override
	public Usuario porLoginSenha(String login, String senha) {
		
		TypedQuery<Usuario> query 
			= em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha",Usuario.class);
		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		List<Usuario> usuario = query.getResultList();
		
		if(usuario.isEmpty()) {
			return null;
		}else {
			return usuario.get(0);
		}
		
		
	}
	
	

}
