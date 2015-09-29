package br.com.fourtech.fourfoot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fourtech.fourfoot.model.Usuario;

public class UsuarioDAO {

	private Connection conexao;
	
	public UsuarioDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Usuario getLogin(String nome, String senha){
		String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?;";
		Usuario usuarioLogado = new Usuario();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				usuarioLogado.setIdusuario(rs.getLong("idusuario"));
				usuarioLogado.setNome(rs.getString("nome"));
				usuarioLogado.setSenha(rs.getString("senha"));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage().replaceAll("\"", ""));
		}
				
		return usuarioLogado;
	}
}
