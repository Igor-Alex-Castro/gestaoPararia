package gestaopadaria.entities;

import java.math.BigDecimal;

import gestaopadaria.enums.Tipo;

public class ProdutoTotal  extends Produto{
	
	

	private Double totalItem;

	public ProdutoTotal(BigDecimal cod, String nome, double valorPorItem, double quantidade, Tipo tipo,
			Double totalItem) {
		super(cod, nome, valorPorItem, quantidade, tipo);
		this.totalItem = totalItem;
	}

	public Double getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Double totalItem) {
		this.totalItem = totalItem;
	}

	@Override
	public String toString() {
		return  "cod="+ getCod() + ",nome=" + getNome() + ""
				+ ",valorPorItem=" + getTotalItem() + ",quantidade=" + getQuantidade() + 
				"tipo=" + getTipo() + "totalItem" + totalItem;
	}
	
	
	
}
