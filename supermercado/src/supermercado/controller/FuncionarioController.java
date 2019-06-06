package supermercado.controller;

import javax.enterprise.context.*;	
import javax.inject.*;
import supermercado.dal.entidade.*;

import javax.ejb.*;
import supermercado.bll.interfaces.*;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;

import java.util.*;
import supermercado.util.*;

@Named
@RequestScoped
public class FuncionarioController {

	private Funcionario funcionario;
	
	@EJB
	private IFuncionarioEJB funcionarioEJB;
	
	@Inject
	private FacesUtil facesUtil;
	
	public FuncionarioController() {
		novoFuncionario();
	}
	
	public void salvar() {
		Mensagem mensagem = funcionarioEJB.salvar(funcionario);
		if(mensagem.getTipo() == TipoMensagem.sucesso) {
			novoFuncionario();
		}
		
		facesUtil.addMessage(mensagem);
	}
	
	public List<Funcionario> listar(){
		return funcionarioEJB.listar();
	}
	
	private void novoFuncionario() {
		this.funcionario = new Funcionario();
		this.funcionario.setUsuario(new Usuario());
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}