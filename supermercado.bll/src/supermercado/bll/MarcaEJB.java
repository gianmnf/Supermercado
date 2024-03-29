package supermercado.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.dal.dao.interfaces.IMarcaDAO;
import supermercado.dal.entidade.Marca;
import supermercado.bll.interfaces.IMarcaEJB;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;

@Stateless
public class MarcaEJB implements IMarcaEJB{

	@Inject
	private IMarcaDAO marcaDAO;
	
	@Override
	public Mensagem salvar(Marca marca) {
		
		try {
			
			//abre a conex�o
			marcaDAO.insertOrUpdate(marca);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
			//fecha a conex�o
		}
	}

	@Override
	public Mensagem excluir(Short idMarca) {
		
		try {
			
			Marca marca = marcaDAO.findById(idMarca);
			
			if(marca == null) {
				throw new Exception("Marca j� foi exclu�da.");
			}
			
			if(marca.getFornecedor().size() > 0) {
				throw new Exception("Essa marca possui fornecedores vinculados");
			}
			
			marcaDAO.delete(marca);
			
			return new Mensagem("Marca exclu�da.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Marca> listar() {
		return marcaDAO.findAll();
	}

}
