package supermercado.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.dal.dao.interfaces.IFornecedorDAO;
import supermercado.dal.entidade.Fornecedor;
import supermercado.bll.interfaces.IFornecedorEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;


@Stateless
public class FornecedorEJB implements IFornecedorEJB {

	@Inject
	private IFornecedorDAO fornecedorDAO;
	
	@Override
	public Mensagem salvar(Fornecedor fornecedor) {

		try {
			fornecedorDAO.insertOrUpdate(fornecedor);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),TipoMensagem.erro);
		}
		
		return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
	}

	@Override
	public Mensagem excluir(Short idFornecedor) {
		
		
		try {
			
			Fornecedor fornecedor = fornecedorDAO.findById(idFornecedor);
			
			if(fornecedor == null) {
				throw new Exception("Fornecedor inexistente.");
			}
			
			if(fornecedor.getProdutos().size() > 0) {
				throw new Exception("Existem produtos vinculados a essa marca");
			}
			
			fornecedorDAO.delete(fornecedor);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
		return new Mensagem("Excluído com sucesso.",
				TipoMensagem.sucesso);
		
	}


	@Override
	public List<Fornecedor> listar() {
		return fornecedorDAO.findAll();
	}

}
