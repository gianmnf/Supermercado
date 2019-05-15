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
			return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
	}

	public Mensagem excluir(Short idCategoria) {
		
		
		try {
			
			Categoria categoria = obterPorId(idCategoria);
			
			if(categoria == null) {
				throw new Exception("Categoria inexistente.");
			}
			
			if(categoria.getProdutos().size() > 0) {
				throw new Exception("Essa categoria possui produtos vinculados a ela.");
			}
			categoriaDAO.delete(categoria);
			return new Mensagem("Categoria Excluída.",
					MensagemStatus.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
	}

	public Categoria obterPorId(Short idCategoria) {
		return categoriaDAO.findById(idCategoria);
	}


	public List<Categoria> obterTodos() {
		return categoriaDAO.findAll();
	}
}
