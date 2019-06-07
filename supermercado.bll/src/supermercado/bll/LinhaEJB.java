package supermercado.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.dal.dao.interfaces.ILinhaDAO;
import supermercado.dal.entidade.Linha;
import supermercado.bll.interfaces.ILinhaEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;

@Stateless
public class LinhaEJB implements ILinhaEJB{

	@Inject
	private ILinhaDAO linhaDAO;
	
	@Override
	public Mensagem salvar(Linha linha) {
		
		try {
			
			linhaDAO.insertOrUpdate(linha);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Short idLinha) {
		
		try {
			
			Linha linha = linhaDAO.findById(idLinha);
			
			if(linha == null) {
				throw new Exception("Linha já foi excluída.");
			}
			
			if(linha.getProdutos().size() > 0) {
				throw new Exception("Essa linha possui produtos vinculados");
			}
			
			linhaDAO.delete(linha);
			
			return new Mensagem("Linha excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Linha> listar() {
		return linhaDAO.findAll();
	}

}
