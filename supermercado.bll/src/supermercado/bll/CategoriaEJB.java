package supermercado.bll;

import supermercado.bll.util.*;		
import supermercado.bll.interfaces.*;
import supermercado.dal.dao.interfaces.ICategoriaDAO;
import supermercado.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CategoriaEJB implements ICategoriaEJB{
	@Inject
	private ICategoriaDAO categoriaDAO;
	
	public Mensagem salvar(Categoria categoria) {

		try {
			categoriaDAO.insertOrUpdate(categoria);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	public Mensagem excluir(Short idCategoria) {
		
		
		try {
			
			Categoria categoria = obterPorId(idCategoria);
			
			if(categoria == null) {
				throw new Exception("Categoria inexistente.");
			}
			
			categoriaDAO.delete(categoria);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				MensagemStatus.sucesso);
		
	}

	public Categoria obterPorId(Short idCategoria) {
		return categoriaDAO.findById(idCategoria);
	}


	public List<Categoria> obterTodos() {
		return categoriaDAO.findAll();
	}
}
