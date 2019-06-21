package supermercado.bll;

import java.util.ArrayList;	
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import supermercado.bll.interfaces.IVendaEJB;
import supermercado.bll.relatorio.GraficoLinha;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;
import supermercado.dal.dao.interfaces.IVendaDAO;
import supermercado.dal.entidade.Venda;
import supermercado.dal.entidade.VendaProduto;

@Stateless
public class VendaEJB implements IVendaEJB{

	@Inject
	private IVendaDAO vendaDAO;
	
    @Override
    public Mensagem salvar(Venda venda) {
        try {
            for (VendaProduto vp : venda.getVendaProdutos()) {
                vp.setVenda(venda);
            }

            vendaDAO.insertOrUpdate(venda);
            return new Mensagem("Venda salva.",
					TipoMensagem.sucesso);
        } catch (Exception ex) {
        	return new Mensagem(ex.getMessage(), TipoMensagem.erro);
        }
    }

    public List<Venda> listar(Date data) {
        return vendaDAO.listar(data);
    }
    
    
    public List<GraficoLinha> listar(int ano) {

        List<GraficoLinha> vendas = new ArrayList<>();

		List<?> list =  vendaDAO.listar(ano);
		
		for (Object object : list) {
			Object[] objects = (Object[])object;
			vendas.add(new GraficoLinha((Integer) objects[0], (Double) objects[1]));
		}

        return vendas;
    }

}
