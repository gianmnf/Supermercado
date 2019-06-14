package supermercado.bll.interfaces;

import supermercado.dal.entidade.MetodoPagamento;

import java.util.List;

import supermercado.bll.util.Mensagem;

public interface IPagamentoEJB {
	public Mensagem salvar(MetodoPagamento pagamento);
	public Mensagem excluir(Short idPagamento);
	public List<MetodoPagamento> listar();
}
