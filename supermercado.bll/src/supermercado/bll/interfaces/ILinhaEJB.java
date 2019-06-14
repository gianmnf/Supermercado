package supermercado.bll.interfaces;

import java.util.List;		

import supermercado.dal.entidade.Linha;
import supermercado.bll.util.Mensagem;

public interface ILinhaEJB {

	public Mensagem salvar(Linha linha);
	public Mensagem excluir(Short idLinha);
	public List<Linha> listar();
	
}
