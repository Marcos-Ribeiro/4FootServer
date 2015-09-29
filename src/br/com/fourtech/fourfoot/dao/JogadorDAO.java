package br.com.fourtech.fourfoot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fourtech.fourfoot.crud.Crud;
import br.com.fourtech.fourfoot.model.Jogador;

public class JogadorDAO implements Crud<Jogador>{

	Connection conexao;
	
	SimpleDateFormat dtformat = new SimpleDateFormat("dd/MM/yyyy");

	public JogadorDAO(Connection conexao) {
		this.conexao = conexao;
	}

	
	@Override
	public List<Jogador> getLista() {
		String sql = "SELECT * FROM jogador ORDER BY nome;";
		List<Jogador> listaJogador = new ArrayList<Jogador>();
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Jogador jogador = new Jogador();
				
				jogador.setIdJogador(rs.getLong("idjogador"));
				jogador.setApelido(rs.getString("apelido"));
				jogador.setPosicao(rs.getString("posicao"));
				jogador.setDataNascimento(dtformat.format(rs.getDate("datanascimento")));
				
				listaJogador.add(jogador);
				
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listaJogador;
	}

	@Override
	public Jogador getObject(Long id) {
		Jogador jogador = new Jogador();
		String sql = "SELECT * FROM jogador WHERE idusuario = ?;";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				jogador.setIdJogador(rs.getLong("idjogador"));
				jogador.setApelido(rs.getString("apelido"));
				jogador.setPosicao(rs.getString("posicao"));
				jogador.setDataNascimento(dtformat.format(rs.getDate("datanascimento")));
								
			}
						
		}catch (SQLException e){
			e.printStackTrace();
		}
		return jogador;
	}


	@Override
	public void alterar(Jogador jogador) {
		String sql = "UPDATE jogador SET "
				+ " apelido = ?,"
				+ " posicao = ?,"
				+ " datanascimento = ? "
				+ " WHERE idjogador = ?;";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, jogador.getApelido());
			ps.setString(2, jogador.getPosicao());
			ps.setDate(3, new Date(dtformat.parse(jogador.getDataNascimento()).getTime()));
			ps.setLong(4, jogador.getIdJogador());
			
			ps.execute();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM jogador WHERE idjogador = ?;";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Jogador jogador) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO jogador "
				+ " apelido,"
				+ " posicao,"
				+ " datanascimento)"
				+ " VALUES "
				+ "(?,"
				+ "	?,"
				+ "	?);";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, jogador.getApelido());
			ps.setString(3, jogador.getPosicao());			
			ps.setDate(4, new Date(dtformat.parse(jogador.getDataNascimento()).getTime()));
			
			ps.execute();
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO = " + e.getMessage().replaceAll("\"", ""));
		}
	}	
}

