package gestaopadaria.enums;

public enum ModoPagamento {
	PIX("PIX"),
	DINHEIRO("DINHEIRO"),
	DEBITO("DEBITO"),
	CREDITO("CREDITO");
	
	
	private String valoEnum;

	ModoPagamento(String valorEnum) {
		this.valoEnum = valorEnum;
	}

	public String getValoEnum() {
		return valoEnum;
	}
	
}
