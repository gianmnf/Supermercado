package supermercado.bll.interfaces;

import java.util.List;
import supermercado.dal.entidade.Pessoa;

public interface IPessoaEJB {
	public List<Pessoa> listar();
}
