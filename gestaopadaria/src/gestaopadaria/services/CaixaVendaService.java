package gestaopadaria.services;

import java.io.BufferedWriter;
import java.io.FileWriter;

import gestaopadaria.entities.CaixaVenda;

public class CaixaVendaService {
	
		
	public void addCompra(CaixaVenda caixaVenda) {
		
		String path = "C:\\files\\produto.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			
			bw.write(caixaVenda.toString());
			bw.write("\n");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
