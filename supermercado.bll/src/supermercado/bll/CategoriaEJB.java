package supermercado.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.dal.dao.interfaces.ICategoriaDAO;
import supermercado.dal.entidade.Categoria;
import supermercado.bll.interfaces.ICategoriaEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;;

@Stateless
public class CategoriaEJB implements ICategoriaEJB{

	@Inject
	private ICategoriaDAO categoriaDAO;
	
	@Override
	public Mensagem salvar(Categoria categoria) {
		
		try {
			
			categoriaDAO.insertOrUpdate(categoria);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
	}

	@Override
	public Mensagem excluir(Short idCategoria) {
		
		try {
			
			Categoria categoria = categoriaDAO.findById(idCategoria);
			
			if(categoria == null) {
				throw new Exception("Categoria já foi excluída.");
			}
			
			if(categoria.getProdutos().size() > 0) {
				throw new Exception("Essa categoria possui produtos vinculados");
			}
			
			categoriaDAO.delete(categoria);
			
			return new Mensagem("Categoria Excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Categoria> listar() {
		return categoriaDAO.findAll();
	}

}
