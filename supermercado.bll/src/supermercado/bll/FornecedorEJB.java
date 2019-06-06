package supermercado.bll;

import supermercado.bll.util.*;		
import supermercado.bll.interfaces.*;
import supermercado.dal.dao.interfaces.IFornecedorDAO;
import supermercado.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FornecedorEJB implements IFornecedorEJB{
	@Inject
	private IFornecedorDAO fornecedorDAO;
	
	@Override
	public Mensagem salvar(Fornecedor fornecedor) {

		try {
			fornecedorDAO.insertOrUpdate(fornecedor);
			return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),TipoMensagem.erro);
		}
	}

	@Override
	public Mensagem excluir(Short idFornecedor) {
		
		
		try {
			
			Fornecedor fornecedor = obterPorId(idFornecedor);
			
			if(fornecedor == null) {
				throw new Exception("Fornecedor inexistente.");
			}
			
			if(fornecedor.getProdutos().size() > 0) {
				throw new Exception("Existem fornecedores vinculados a essa marca");
			}
			
			fornecedorDAO.delete(fornecedor);
			return new Mensagem("Exclu�do com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem("N�o foi poss�vel excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}		
	}

	@Override
	public Fornecedor obterPorId(Short idFornecedor) {
		return fornecedorDAO.findById(idFornecedor);
	}

	@Override
	public List<Fornecedor> obterTodos() {
		return fornecedorDAO.findAll();
	}
}
