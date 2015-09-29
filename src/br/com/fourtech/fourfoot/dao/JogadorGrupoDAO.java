package br.com.fourtech.fourfoot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fourtech.fourfoot.model.JogadorGrupo;

public class JogadorGrupoDAO{

	Connection conexao;
	
	public JogadorGrupoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<JogadorGrupo> getGruposJogador(Long idJogador) {
		JogadorGrupo jgrupo = new JogadorGrupo();
		List<JogadorGrupo> lista = new ArrayList<JogadorGrupo>();
		
		String sql = "SELECT * FROM jogador_grupo WHERE idjogador = ?;";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, idJogador);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				
				jgrupo.setIdgrupo(rs.getLong("idgrupo"));
				jgrupo.setIdjogador(rs.getLong("idjogador"));
				jgrupo.setAdministrador(rs.getBoolean("administrador"));
				
				lista.add(jgrupo);
				
			}
			ps.close();
			rs.close();
			return lista;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
