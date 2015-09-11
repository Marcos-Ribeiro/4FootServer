package br.com.fourtech.fourfoot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fourtech.fourfoot.crud.Crud;
import br.com.fourtech.fourfoot.model.Grupo;

public class GrupoDAO implements Crud<Grupo>{

	Connection conexao;
	
	public GrupoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public List<Grupo> getLista() {
		String sql = "SELECT * FROM grupo ORDER BY nome;";
		List<Grupo> listaGrupo = new ArrayList<Grupo>();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Grupo grupo = new Grupo(); 
				
				grupo.setIdgrupo(rs.getLong("idgrupo"));
				grupo.setNome(rs.getString("nome"));
				
				listaGrupo.add(grupo);
			}
			
			ps.close();
			rs.close();
			conexao.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaGrupo;
		
	}

	@Override
	public Grupo getObject(Long id) {
		Grupo grupo = new Grupo();
		
		String sql = "SELECT * FROM grupo WHERE idgrupo = ?;";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				
				grupo.setIdgrupo(rs.getLong("idgrupo"));
				grupo.setNome(rs.getString("nome"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grupo;
	}

	@Override
	public void inserir(Grupo grupo) {
		String sql = "INSERT INTO grupo "
				+ "(nome)"
				+ " VALUES "
				+ "(?);";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, grupo.getNome());
			
			ps.execute();
			
			ps.close();
			conexao.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO = " + e.getMessage().replaceAll("\"", ""));
		}		
	}

	@Override
	public void alterar(Grupo grupo) {
		String sql = "UPDATE grupo SET "
				+ " nome = ?"
				+ " WHERE idgrupo = ?;";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, grupo.getNome());
			
			ps.execute();
			
			ps.close();
			conexao.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM grupo WHERE idgrupo = ?;";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			
			ps.execute();
			
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
