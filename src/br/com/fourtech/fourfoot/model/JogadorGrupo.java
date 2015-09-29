package br.com.fourtech.fourfoot.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JogadorGrupo {

	private Long idjogador;
	private Long idgrupo;
	private boolean administrador;
	
	public Long getIdjogador() {
		return idjogador;
	}
	public void setIdjogador(Long idjogador) {
		this.idjogador = idjogador;
	}
	public Long getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
}

