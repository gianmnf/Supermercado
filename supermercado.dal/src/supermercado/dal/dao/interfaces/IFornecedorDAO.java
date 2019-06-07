package supermercado.dal.dao.interfaces;

import supermercado.dal.entidade.*;
import supermercado.dal.generics.*;

import java.util.*;

public interface IFornecedorDAO
		extends IGenericDAO<Fornecedor, Short>{

	public List<Fornecedor> findByFornecedor(String nomeFornecedor);
}
