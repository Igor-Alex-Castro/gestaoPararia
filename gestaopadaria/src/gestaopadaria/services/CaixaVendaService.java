package gestaopadaria.services;

import java.io.BufferedWriter;
import java.io.FileWriter;

import gestaopadaria.entities.CaixaVenda;
import gestaopadaria.entities.ProdutoTotal;

public class CaixaVendaService {
	
		
	public void addCompra(CaixaVenda caixaVenda) {
		
		String path = "C:\\files\\CaixaVenda.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			
			bw.write(caixaVenda.toString());
			bw.write("\n");
			
			System.out.println("Compra registrada");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public Double totalCompra(CaixaVenda caixaVenda) {
		Double soma = 0.0;
		for (ProdutoTotal item : caixaVenda.getItensVenda()) {
			
			soma += item.getQuantidade() * item.getValorPorItem();
			
		} 
		
		return soma;
	}
}
