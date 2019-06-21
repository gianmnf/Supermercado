package supermercado.bll.interfaces;

import java.util.Date;	
import java.util.List;

import supermercado.bll.relatorio.GraficoLinha;
import supermercado.bll.util.Mensagem;
import supermercado.dal.entidade.Venda;

public interface IVendaEJB {
	public Mensagem salvar(Venda venda);
	public List<Venda> listar(Date data);
	List<GraficoLinha> listar(int ano);
}
