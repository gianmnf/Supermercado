package supermercado.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import supermercado.bll.interfaces.IPessoaEJB;
import supermercado.dal.dao.interfaces.IPessoaDAO;
import supermercado.dal.entidade.Pessoa;

@Stateless
public class PessoaEJB implements IPessoaEJB{

	@Inject
	private IPessoaDAO pessoaDAO;
	
	@Override
	public List<Pessoa> listar() {
		return pessoaDAO.findAll();
	}

}
