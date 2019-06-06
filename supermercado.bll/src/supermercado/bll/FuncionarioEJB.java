package supermercado.bll;

import java.util.*;
import supermercado.bll.interfaces.*;
import supermercado.bll.util.Mensagem;
import supermercado.bll.util.SHA1;
import supermercado.bll.util.TipoMensagem;
import supermercado.dal.dao.interfaces.*;
import supermercado.dal.entidade.*;
import javax.ejb.*;
import javax.inject.*;

@Stateless
public class FuncionarioEJB implements IFuncionarioEJB{

	@Inject
	private IFuncionarioDAO funcionarioDAO;
	
	@Override
	public Mensagem salvar(Funcionario funcionario) {
		try {
			String cpfSemMascara = funcionario.getCpfMascara()
					.replace(".","")
					.replace("-","");
			
			funcionario.setCpf(Long.parseLong(cpfSemMascara));
			Usuario usuario = funcionario.getUsuario();
			usuario.setFuncionario(funcionario);
			
			String senha = SHA1.encryptPassword(usuario.getSenha());
			usuario.setSenha(senha);
			funcionarioDAO.insertOrUpdate(funcionario);
			
			return new Mensagem("Funcionário Salvo",
					TipoMensagem.sucesso);
					
		}catch(Exception e) {
			return new Mensagem(e.getMessage(), TipoMensagem.erro);
		}
	}
	
	@Override
	public Mensagem excluir(Integer idPessoa) {
		try {
			Funcionario funcionario = funcionarioDAO.findById(idPessoa);
			
			if(funcionario == null) {
				return new Mensagem("Funcionário não existe.",
						TipoMensagem.erro);
			}
			
			if(funcionario.getVendas().size() > 0) {
				return new Mensagem("Funcionário já realizou localizações.",
						TipoMensagem.erro);
			}
			
			funcionarioDAO.delete(funcionario);
			
			return new Mensagem("Funcionário Excluído.",
					TipoMensagem.sucesso);
		}catch(Exception ex){
			return new Mensagem(ex.getMessage(),
					TipoMensagem.erro);
		}
	}
	
	@Override
	public List<Funcionario> listar(){
		return funcionarioDAO.findAll();
	}
	
}
