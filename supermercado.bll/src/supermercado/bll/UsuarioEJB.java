package supermercado.bll;

import supermercado.dal.entidade.*;	
import supermercado.bll.interfaces.*;
import supermercado.bll.util.*;
import supermercado.dal.dao.interfaces.*;

import javax.ejb.*;
import javax.inject.*;

@Stateless
public class UsuarioEJB implements IUsuarioEJB {

	@Inject
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public Mensagem autenticar(Usuario usuario) {
		
		try {
			
			String senhaCript = SHA1.encryptPassword(usuario.getSenha());
			
			Usuario usuarioValidacao 
				= usuarioDAO.porLoginSenha(usuario.getLogin(), senhaCript);
			
			if(usuarioValidacao == null) {
				
				return new Mensagem("Login ou senha inválidos.",
									TipoMensagem.erro);
				
			}else {
				
				return new Mensagem("Autenticação realizada.",
						TipoMensagem.sucesso);
			}
			
		}catch(Exception ex) {
			return new Mensagem(ex.getMessage(),TipoMensagem.erro);
		}
		
	}

}
