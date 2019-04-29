package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;

public interface IMarcaEJB {
	
		public Mensagem salvar(Marca marca);
		
		public Mensagem excluir(Short idMarca);
		
		public Marca obterPorId(Short idMarca);
		
		public List<Marca> obterTodos();
		
}
