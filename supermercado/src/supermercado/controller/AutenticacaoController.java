package supermercado.controller;

import javax.inject.*;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;

import supermercado.bll.interfaces.IUsuarioEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;
import supermercado.dal.entidade.*;
import supermercado.util.FacesUtil;

@Named
@SessionScoped
public class AutenticacaoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private boolean usuarioAutenticado;
	
	@EJB
	private IUsuarioEJB usuarioEJB;
	
	@Inject
	private FacesUtil facesUtil;
	
	@Inject
	private FacesContext facesContext;
	
	public AutenticacaoController() {
		this.usuario = new Usuario();
	}
	
	public void autenticar() throws IOException {
		
		Mensagem mensagem = usuarioEJB.autenticar(usuario);
		
		if(mensagem.getTipo() == TipoMensagem.erro) {
			facesUtil.addMessage(mensagem);
		}else {
			usuarioAutenticado = true;
			facesContext
				.getExternalContext()
				.redirect("index.xhtml");
		}
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(boolean usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}
	
	
	
	
	
}
