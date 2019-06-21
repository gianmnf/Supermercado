package supermercado.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import supermercado.bll.interfaces.IPessoaEJB;
import supermercado.dal.entidade.Pessoa;

@Named
@RequestScoped
public class PessoaController {


	@EJB
	private IPessoaEJB pessoaEJB;

	public List<Pessoa> todos(){
		return pessoaEJB.listar();
	}
}
