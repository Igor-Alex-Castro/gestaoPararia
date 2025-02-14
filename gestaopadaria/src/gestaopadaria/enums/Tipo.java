package gestaopadaria.enums;

public enum Tipo {
	LIQUIDO("LIQUIDO"),
	PESO("PESO"),
	UNIDADE("UNIDADE");
	
	private String valoEnum;

	Tipo(String valorEnum) {
		this.valoEnum = valorEnum;
	}

	public String getValoEnum() {
		return valoEnum;
	}
	
	
}
