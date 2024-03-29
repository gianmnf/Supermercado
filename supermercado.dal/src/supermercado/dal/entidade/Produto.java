package supermercado.dal.entidade;

import javax.persistence.*;		
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	
	@NotNull(message = "Informe o nome")
	private String nome;
	
	@NotNull(message = "Informe o pre�o")
	private Double preco;
	
	@NotNull(message = "Informe a qtd. em estoque")
	@Min(value = 1, message = "Quantidade de produtos inv�lida.")
	private Short quantidadeEstoque;
	
	@ManyToOne
	@JoinColumn(name = "idLinha")
	@NotNull(message = "Informe a linha")
	private Linha linha;
	
	@ManyToOne
	@JoinColumn(name = "idFornecedor")
	@NotNull(message = "Informe o fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "idPagamento")
	@NotNull(message = "Informe o m�todo de pagamento")
	private MetodoPagamento pagamento;
	

	@ManyToMany
	@JoinTable(name = "ProdutoCategoria",
			joinColumns = @JoinColumn(name = "idProduto"),
			inverseJoinColumns = @JoinColumn(name = "idCategoria"))
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "produto")
	private List<VendaProduto> vendaProdutos;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Short getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Short quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<VendaProduto> getVendaProdutos() {
		return vendaProdutos;
	}

	public void setVendaProdutos(List<VendaProduto> vendaProdutos) {
		this.vendaProdutos = vendaProdutos;
	}

	public MetodoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(MetodoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}	
	
	
	
	
}
