package supermercado.controller;

import java.util.List;	

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import supermercado.bll.interfaces.ICategoriaEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;
import supermercado.dal.entidade.Categoria;

@Named
@RequestScoped
public class CategoriaController {

	private Categoria categoria;
	
	@EJB
	private ICategoriaEJB categoriaEJB;
	
	@Inject
	private FacesContext context;
	
	public CategoriaController() {
		this.categoria = new Categoria();
	}
	
	public void salvar() {
		
		Mensagem msg = categoriaEJB.salvar(categoria);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.categoria = new Categoria();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Categoria> todos(){
		return categoriaEJB.obterTodos();
	}
	
	public void editar(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public void excluir(Short idCategoria) {
		
		Mensagem msg = categoriaEJB.excluir(idCategoria);
		
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

	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
