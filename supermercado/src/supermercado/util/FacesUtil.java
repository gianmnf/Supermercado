package supermercado.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import supermercado.bll.util.Mensagem;
import supermercado.bll.util.TipoMensagem;

@RequestScoped
public class FacesUtil {

	@Inject
	private FacesContext context;
	
	public void addMessage(Mensagem msg) {
		if(msg.getTipo() == TipoMensagem.sucesso) {
			context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								msg.getTexto(), null));
		}else {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(), null));
		}
	}
}
