package br.com.fourtech.fourfoot.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Grupo {

	private Long idgrupo;
	private String nome;
	
	public Long getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
