package supermercado.bll;

import supermercado.bll.util.*;			
import supermercado.bll.interfaces.*;
import supermercado.dal.dao.interfaces.ILinhaDAO;
import supermercado.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LinhaEJB implements ILinhaEJB{
	@Inject
	private ILinhaDAO linhaDAO;
	
	@Override
	public Mensagem salvar(Linha linha) {

		try {
			linhaDAO.insertOrUpdate(linha);
			return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		}
	}

	@Override
	public Mensagem excluir(Short idLinha) {
		
		
		try {
			
			Linha linha = obterPorId(idLinha);
			
			if(linha == null) {
				throw new Exception("Linha inexistente.");
			}
			
			linhaDAO.delete(linha);
			return new Mensagem("Excluído com sucesso.",
					MensagemStatus.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem("Não foi possível excluir: " 
					+ ex.getMessage(), MensagemStatus.erro);
		}
		
	}

	@Override
	public Linha obterPorId(Short idLinha) {
		return linhaDAO.findById(idLinha);
	}


	@Override
	public List<Linha> obterTodos() {
		return linhaDAO.findAll();
	}
}
