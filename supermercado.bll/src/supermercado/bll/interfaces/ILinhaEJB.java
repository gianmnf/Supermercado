package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;

public interface ILinhaEJB {
	
		public Mensagem salvar(Linha linha);
		
		public Mensagem excluir(Short idLinha);
		
		public Linha obterPorId(Short idLinha);
		
		public List<Linha> obterTodos();
		
}