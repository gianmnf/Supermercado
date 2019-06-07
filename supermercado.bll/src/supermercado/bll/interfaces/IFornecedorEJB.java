package supermercado.bll.interfaces;

import java.util.List;	

import supermercado.dal.entidade.Fornecedor;
import supermercado.bll.util.Mensagem;

public interface IFornecedorEJB {

	public Mensagem salvar(Fornecedor fornecedor);
	public Mensagem excluir(Short idFornecedor);
	public List<Fornecedor> listar();
}
