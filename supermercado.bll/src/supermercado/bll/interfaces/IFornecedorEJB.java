package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;

public interface IFornecedorEJB {

		public Mensagem salvar(Fornecedor fornecedor);
		
		public Mensagem excluir(Short idFornecedor);
		
		public Fornecedor obterPorId(Short idFornecedor);
		
		public List<Fornecedor> obterTodos();

}