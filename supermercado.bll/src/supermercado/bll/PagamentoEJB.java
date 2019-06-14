package supermercado.bll;

import java.util.List;			

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.dal.dao.interfaces.IPagamentoDAO;
import supermercado.dal.entidade.MetodoPagamento;
import supermercado.bll.interfaces.IPagamentoEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;

@Stateless
public class PagamentoEJB implements IPagamentoEJB{

	@Inject
	private IPagamentoDAO pagamentoDAO;
	
	@Override
	public Mensagem salvar(MetodoPagamento pagamento) {
		
		try {
			
			pagamentoDAO.insertOrUpdate(pagamento);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Short idPagamento) {
		
		try {
			
			MetodoPagamento pagamento = pagamentoDAO.findById(idPagamento);
			
			if(pagamento == null) {
				throw new Exception("Método já foi excluído.");
			}
			
			if(pagamento.getProdutos().size() > 0) {
				throw new Exception("Esse método de pagamento possui produtos vinculados");
			}
			
			pagamentoDAO.delete(pagamento);
			
			return new Mensagem("Método de pagamento Excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<MetodoPagamento> listar() {
		return pagamentoDAO.findAll();
	}

}
