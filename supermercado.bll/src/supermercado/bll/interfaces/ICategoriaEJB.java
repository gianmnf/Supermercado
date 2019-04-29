package supermercado.bll.interfaces;

import supermercado.bll.util.*;
import supermercado.dal.entidade.*;

import java.util.*;


public interface ICategoriaEJB {
	public Mensagem salvar(Categoria categoria);
	
	public Mensagem excluir(Short idCategoria);
	
	public Categoria obterPorId(Short idCategoria);
	
	public List<Categoria> obterTodos();
}
