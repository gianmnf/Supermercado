package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;

public interface IProdutoEJB {
	
		public Mensagem salvar(Produto produto);
		
		public Mensagem excluir(Short idProduto);
		
		public Produto obterPorId(Short idProduto);
		
		public List<Produto> obterTodos();
		
}