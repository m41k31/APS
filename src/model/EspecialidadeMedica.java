package model;

public class EspecialidadeMedica {
	private int codigoEspecialidadeMedica;
	private int codigoPessoa;
	
	public EspecialidadeMedica(int codigoEspecialidadeMedica, int codigoPessoa) {
		this.codigoEspecialidadeMedica = codigoEspecialidadeMedica;	
		this.codigoPessoa = codigoPessoa;
	}

	public int getCodigoespMedica() {
		return codigoEspecialidadeMedica;
	}

	public void setCodigoespMedica(int codigoEspecialidadeMedica) {
		this.codigoEspecialidadeMedica = codigoEspecialidadeMedica;
	}
	
	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

}