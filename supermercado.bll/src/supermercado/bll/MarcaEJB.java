package supermercado.bll;

import java.util.List;

import javax.inject.Inject;

import supermercado.bll.util.*;			
import supermercado.bll.interfaces.*;
import supermercado.dal.dao.interfaces.IMarcaDAO;
import supermercado.dal.entidade.*;

import javax.ejb.Stateless;

@Stateless
public class MarcaEJB implements IMarcaEJB{
	@Inject
	private IMarcaDAO marcaDAO;
	
	@Override
	public Mensagem salvar(Marca marca) {

		try {
			
			//Abre conex�o
			marcaDAO.insertOrUpdate(marca);

		
		}catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),TipoMensagem.erro);
		}finally {
			//Fecha conex�o
		}
		
		return new Mensagem("Salvo com sucesso.", TipoMensagem.sucesso);
	}

	@Override
	public Mensagem excluir(Short idMarca) {
		
		
		try {
			
			Marca marca = obterPorId(idMarca);
			
			if(marca == null) {
				throw new Exception("Marca inexistente.");
			}
			
			if(marca.getFornecedores().size() > 0) {
				throw new Exception("Existem fornecedores vinculados a essa marca");
			}
			
			marcaDAO.delete(marca);
			
			return new Mensagem("Exclu�do com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem("N�o foi poss�vel excluir: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public Marca obterPorId(Short idMarca) {
		return marcaDAO.findById(idMarca);
	}

	@Override
	public List<Marca> obterTodos() {
		return marcaDAO.findAll();
	}
}
