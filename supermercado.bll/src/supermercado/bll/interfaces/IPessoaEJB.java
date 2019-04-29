package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;

public interface IPessoaEJB {
	
		public Mensagem salvar(Pessoa pessoa);
		
		public Mensagem excluir(Short idPessoa);
		
		public Pessoa obterPorId(Short idPessoa);
		
		public List<Pessoa> obterTodos();
		
}