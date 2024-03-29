package supermercado.bll;

import java.util.List;		

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.dal.dao.interfaces.IProdutoDAO;
import supermercado.dal.entidade.Produto;
import supermercado.bll.interfaces.IProdutoEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;

@Stateless
public class ProdutoEJB implements IProdutoEJB{

	@Inject
	private IProdutoDAO produtoDAO;
	
	@Override
	public Mensagem salvar(Produto produto) {
		
		try {
		
			produtoDAO.insertOrUpdate(produto);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idProduto) {
		
		try {
			
			Produto produto = produtoDAO.findById(idProduto);
			
			if(produto == null) {
				throw new Exception("Produto j� foi exclu�do.");
			}
			
	
			
			produtoDAO.delete(produto);
			
			return new Mensagem("Produto exclu�do.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Produto> listar() {
		return produtoDAO.findAll();
	}
	
	@Override
	public Produto obter(Integer idProduto) {
		// TODO Auto-generated method stub
		return produtoDAO.findById(idProduto);
	}

}
