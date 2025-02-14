package gestaopadaria.services;

import java.io.BufferedWriter;
import java.io.FileWriter;

import gestaopadaria.entities.Produto;
import gestaopadaria.interfaces.EstoqueInterface;
import gestaopadaria.interfaces.ProdutoInterface;

public class EstoqueService implements EstoqueInterface {

	@Override
	public void addProdutoEstoque(Produto produto) {
		// TODO Auto-generated method stub
		String path = "C:\\files\\produto.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			
			bw.write(produto.toString());
			bw.write("\n");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
