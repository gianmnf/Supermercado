package supermercado.bll.interfaces;

import java.util.List;	

import supermercado.dal.entidade.Marca;
import supermercado.bll.util.Mensagem;

public interface IMarcaEJB {

	public Mensagem salvar(Marca marca);
	public Mensagem excluir(Short idMarca);
	public List<Marca> listar();
	
}
