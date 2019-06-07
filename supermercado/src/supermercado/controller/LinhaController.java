package supermercado.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import supermercado.bll.interfaces.ILinhaEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;
import supermercado.dal.entidade.Linha;

@Named
@RequestScoped
public class LinhaController {

	private Linha linha;
	
	@EJB
	private ILinhaEJB linhaEJB;
	
	@Inject
	private FacesContext context;
	
	public LinhaController() {
		this.linha = new Linha();
	}
	
	public void salvar() {
		
		Mensagem msg = linhaEJB.salvar(linha);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.linha = new Linha();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Linha> todos(){
		return linhaEJB.listar();
	}
	
	public void editar(Linha linha) {
		this.linha = linha;
	}
	
	
	public void excluir(Short idLinha) {
		
		Mensagem msg = linhaEJB.excluir(idLinha);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
		
	}

	
	
	
	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}
	
	
	
}
