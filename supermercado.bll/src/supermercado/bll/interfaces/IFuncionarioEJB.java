package supermercado.bll.interfaces;

import java.util.*;
import supermercado.dal.entidade.*;
import supermercado.bll.util.*;

public interface IFuncionarioEJB {
	public Mensagem salvar(Funcionario funcionario);
	public Mensagem excluir(Integer idPessoa);
	public List<Funcionario> listar();
}
