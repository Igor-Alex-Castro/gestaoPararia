package gestaopadaria.controllers;

import java.math.BigDecimal;

import gestaopadaria.entities.Produto;
import gestaopadaria.services.ProdutoService;

public class ProdutoController {
	
	ProdutoService produtoService = new ProdutoService();
	
	
	public void addProdutos(Produto produto) {
		produtoService.addProduto(produto);
	}
	
	public Produto findProduto(String id) {
		return produtoService.findProduto(id);
	}
}
