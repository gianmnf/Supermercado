package supermercado.test;

import java.util.*;	
import javax.ejb.embeddable.*;
import javax.naming.*;

import supermercado.dal.entidade.*;
import supermercado.dal.dao.*;
import supermercado.dal.dao.interfaces.IFornecedorDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		p.put("supermercadoDB", "new://Resource?type=DataSource");
		p.put("supermercadoDB.JdbcDriver", "com.mysql.jdbc.Driver");
		p.put("supermercadoDB.JdbcUrl","jdbc:mysql://localhost:3306/supermercado");
		p.put("supermercadoDB.userName","root");
		p.put("supermercadoDB.password","root");
		
		
		Context context = EJBContainer.createEJBContainer(p).getContext();
		
		IFornecedorDAO FornecedorDAO = (IFornecedorDAO) context
				.lookup("java:global/supermercado.dal/FornecedorDAO");
		
		List<Fornecedor> Fornecedores = FornecedorDAO.findByFornecedor("Uberlandia Refrescos");
		
		for (Fornecedor Fornecedor : Fornecedores) {
			System.out.println(Fornecedor.getDescricao());
			System.out.println(Fornecedor.getMarca().getDescricao());
		}
		
		
		
	
	}
}
