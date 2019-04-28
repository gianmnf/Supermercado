package supermercado.dal.dao;

import supermercado.dal.dao.interfaces.*;				
import supermercado.dal.entidade.*;
import supermercado.dal.generics.*;

import javax.enterprise.context.*;

@RequestScoped
public class MarcaDAO extends JPAGenericDAO<Marca, Short>
implements IMarcaDAO{

}
