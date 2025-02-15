package gestaopadaria.entities;

import java.util.ArrayList;
import java.util.List;

import gestaopadaria.enums.ModoPagamento;

public class CaixaVenda {
	
	List<ProdutoTotal> itensVenda = new ArrayList<ProdutoTotal>();
	private Double valorTotal;
	private ModoPagamento modoPagamento;
	
	
	public Double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}



	public List<ProdutoTotal> getItensVenda() {
		return itensVenda;
	}



	public ModoPagamento getModoPagamento() {
		return modoPagamento;
	}



	public void setModoPagamento(ModoPagamento modoPagamento) {
		this.modoPagamento = modoPagamento;
	}



	public void setItensVenda(List<ProdutoTotal> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	public void addItemVenda(ProdutoTotal produtoTotal) {
		this.itensVenda.add(produtoTotal);
	}



	@Override
	public String toString() {
		String produtoTotalString = "";
			for (ProdutoTotal produtoTotal : itensVenda) {
				produtoTotalString += " --- " + produtoTotal.toString() + "\n";
				
			};
			
			return "itensVenda=\n" +  produtoTotalString
				 +  "valorTotal=" + valorTotal + ", modoPagamento="
				+ modoPagamento +
				"\n------------------------------------------";
	}

	

	

	
	
}
