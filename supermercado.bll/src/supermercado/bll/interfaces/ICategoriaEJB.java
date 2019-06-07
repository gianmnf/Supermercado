package supermercado.bll.interfaces;

import java.util.List;	

import supermercado.dal.entidade.Categoria;
import supermercado.bll.util.Mensagem;

public interface ICategoriaEJB {

	public Mensagem salvar(Categoria categoria);
	public Mensagem excluir(Short idCategoria);
	public List<Categoria> listar();
	
}
