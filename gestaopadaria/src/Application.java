import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import gestaopadaria.controllers.CaixaVendaController;
import gestaopadaria.controllers.ProdutoController;
import gestaopadaria.entities.CaixaVenda;


import gestaopadaria.entities.Produto;
import gestaopadaria.entities.ProdutoTotal;
import gestaopadaria.enums.ModoPagamento;
import gestaopadaria.enums.Tipo;

public class Application {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		ProdutoController produtoController = new ProdutoController();
		
		
		Boolean conti = true;
		String opt = "";
		do {
			
			
			System.out.println("[1] FUNCIONARIO ");
			System.out.println("[2] PRODUTO ");
			System.out.println("[3] VENDA");
			String menu = scanner.nextLine();
		
			CaixaVenda caixaVenda = new CaixaVenda();			
			if(menu.equals("3")) {
				
				venda(scanner, produtoController, caixaVenda, opt, conti );
				//System.out.println("Digite o codigo do produto");
			}
			
			System.out.println("Deseja continuar [S/N]: ");
			 opt = scanner.nextLine();
			
			if(opt.equalsIgnoreCase("s")){
				conti =  false;
			}else {
				conti = true;
			}
			
		} while (conti);
		
	}
	
	public static void venda(Scanner scanner, ProdutoController produtoController,
			CaixaVenda caixaVenda, String opt, Boolean conti) {
		System.out.println("--- INICIO VENDA ---");
		Boolean isItem = true;
		
		//int contador = 1;
		
		
		do{
			 
		conti =	inseriItemsVenda(scanner, produtoController, caixaVenda, opt, conti);
			
		}while(conti);
	}
	
	public static Boolean inseriItemsVenda(Scanner scanner, ProdutoController produtoController, 
			CaixaVenda caixaVenda, String opt, Boolean conti) {
		System.out.print("Digite o id do produto: ");
		String id = scanner.nextLine();
		
		
		 Produto produto = produtoController.findProduto(id);
		
		
		System.out.println("id - " + id + " / " + produto.getNome());
		System.out.println();
		
		int quantidade = 0;
		if(produto.getTipo() == Tipo.UNIDADE) {
			 //scanner.nextLine();
			System.out.print("Quantidade:  ");
			 quantidade = scanner.nextInt();
			
		}
		
		Double valorItem = quantidade*produto.getValorPorItem();
		
		ProdutoTotal produtoTotal = new ProdutoTotal(new BigDecimal(id), produto.getNome(),
				produto.getValorPorItem(), quantidade, produto.getTipo(), valorItem);
	
		caixaVenda.addItemVenda(produtoTotal);
		
		mostraLista(caixaVenda.getItensVenda());
	
		System.out.println();
		scanner.nextLine();
		System.out.print("Deseja inserir mais produtos [S/N]:");
		opt = scanner.nextLine();
		

		if(opt.equalsIgnoreCase("s")){
			return true;
		}else {
			System.out.println();
			System.out.println("Digite [1] para finalizar");
			System.out.println("Digite [2] para corrigir");
			opt = scanner.nextLine();
			if(opt.equals("2")) {
				//scanner.nextLine();
			
				corrigiVenda(scanner, caixaVenda);
				mostraLista(caixaVenda.getItensVenda());
				//venda(scanner, produtoController, caixaVenda, id, conti);
				return true;
			}else {
				finalizarVenda(caixaVenda, scanner);
				
				return  false;
			}
		}
	}
	
	public static void finalizarVenda(CaixaVenda caixaVenda, Scanner scanner) {
		CaixaVendaController caixaController =  new CaixaVendaController();
		caixaVenda.setValorTotal(caixaController.totalVenda(caixaVenda));
		

		System.out.println("Qual a forma de pagamento: ");
		System.out.println("[1] - PIX ");
		System.out.println("[2] - DINHEIRO");
		System.out.println("[3] - DEBITO");
		System.out.println("[4] - CREDITO");
		
		ModoPagamento[] modoPagamentos = ModoPagamento.values();
	
		int posModoPagemto = scanner.nextInt();
		scanner.nextLine();
		
		caixaVenda.setModoPagamento(modoPagamentos[posModoPagemto -1 ]);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		caixaVenda.setLocalDate(localDateTime);
		
		caixaController.addCompra(caixaVenda);
		

	}
	
	public static void corrigiVenda(Scanner scanner, CaixaVenda caixaVenda){
		//System.out.println();
	
		System.out.println("Qual pos do item para alteracao? ");
		int pos = scanner.nextInt();
		caixaVenda.getItensVenda().remove(pos-1);
		System.out.println("Item removido da lista");
		scanner.nextLine();
		
	}
	
	public static void mostraLista(List<ProdutoTotal> listProdutoTotal) {
		if(listProdutoTotal.size() == 0) {
			System.out.println("Lista vazia");
		}
		
		System.out.println("-----LISTA DE PRODUTOS----");
		System.out.println();
		int cont = 1;
		if(listProdutoTotal.size() == 0) {
			System.out.println("Lista vazia");
		}else {
			System.out.println("POS-ID -- NOME ITEM --------- QUANT-PRECO --");
			for (ProdutoTotal prod : listProdutoTotal) {
				
				System.out.println(cont + " -> " + prod.getCod() + " -- " + prod.getNome() + " -- " + prod.getQuantidade() + " -- " + prod.getTotalItem());
				cont+=1;
			}
		}
		
	}
}
