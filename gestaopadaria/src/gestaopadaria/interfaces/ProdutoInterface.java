package gestaopadaria.interfaces;

import java.util.List;

import gestaopadaria.entities.Produto;

public interface ProdutoInterface {

	public void addProduto(Produto produto);
	public List<Produto> listProduto();
	public Produto findProduto(String id);
}
