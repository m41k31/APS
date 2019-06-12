package model;

public class Cargos {
	private int codigoCargo;
	private int codigoPessoa;
	
	public Cargos(int codigoCargo, int codigoPessoa) {
		this.codigoCargo = codigoCargo;
		this.codigoPessoa = codigoPessoa;
	}
	
	public int getCodigoCargo() {
		return codigoCargo;	
	}
	
	public void setCodigoCargo( int codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

}