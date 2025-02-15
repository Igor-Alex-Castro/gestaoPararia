package gestaopadaria.controllers;

import gestaopadaria.entities.CaixaVenda;

import gestaopadaria.services.CaixaVendaService;

public class CaixaVendaController {
	
	CaixaVendaService caixaVendaService =  new CaixaVendaService();
	
	public void addCompra(CaixaVenda caixaVenda)  {
		
		caixaVendaService.addCompra(caixaVenda);;
	}
	
	public Double totalVenda(CaixaVenda caixaVenda) {
		return caixaVendaService.totalCompra(caixaVenda);
	}
	
}
