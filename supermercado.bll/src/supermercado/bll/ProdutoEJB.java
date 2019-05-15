package supermercado.bll;

import supermercado.bll.util.*;		
import supermercado.bll.interfaces.*;
import supermercado.dal.dao.interfaces.IProdutoDAO;
import supermercado.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProdutoEJB implements IProdutoEJB{
	@Inject
	private IProdutoDAO produtoDAO;
	
	@Override
	public Mensagem salvar(Produto produto) {

		try {
			produtoDAO.insertOrUpdate(produto);
			return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
	}

	@Override
	public Mensagem excluir(Short idProduto) {
		
		
		try {
			
			Produto produto = obterPorId(idProduto);
			
			if(produto == null) {
				throw new Exception("Produto inexistente.");
			}
			
			produtoDAO.delete(produto);
			
			return new Mensagem("Exclu�do com sucesso.",
					MensagemStatus.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem("N�o foi poss�vel excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
	}

	@Override
	public Produto obterPorId(Short idProduto) {
		return produtoDAO.findById(idProduto);
	}


	@Override
	public List<Produto> obterTodos() {
		return produtoDAO.findAll();
	}
}
