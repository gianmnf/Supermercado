package supermercado.bll.interfaces;

import java.util.List;

import supermercado.dal.entidade.Produto;
import supermercado.bll.util.Mensagem;

public interface IProdutoEJB {

	public Mensagem salvar(Produto produto);
	public Mensagem excluir(Integer idProduto);
	public List<Produto> listar();
	public Produto obter(Integer idProduto);
	
}
