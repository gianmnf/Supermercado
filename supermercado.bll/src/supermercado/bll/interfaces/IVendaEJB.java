package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;

public interface IVendaEJB {
	
		public Mensagem salvar(Venda venda);
		
		public Mensagem excluir(Short idVenda);
		
		public Venda obterPorId(Short idVenda);
		
		public List<Venda> obterTodos();
		
}