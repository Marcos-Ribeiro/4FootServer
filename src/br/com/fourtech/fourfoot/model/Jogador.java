package br.com.fourtech.fourfoot.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jogador {

	private Long idjogador;
	private String apelido;
	private String dataNascimento;
	private String posicao;

	public Long getIdJogador() {
		return idjogador;
	}
	public void setIdJogador(Long idjogador) {
		this.idjogador = idjogador;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

}