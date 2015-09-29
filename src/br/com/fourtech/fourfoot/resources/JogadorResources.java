package br.com.fourtech.fourfoot.resources;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.fourtech.fourfoot.dao.JogadorDAO;
import br.com.fourtech.fourfoot.db.ConnectionFactory;
import br.com.fourtech.fourfoot.model.Jogador;

@Path("jogador")
public class JogadorResources{

	@GET
	@Produces("application/json")
	public List<Jogador> getLista() {
		Connection conexao = new ConnectionFactory().getConnection();
		JogadorDAO dao = new JogadorDAO(conexao);
		return dao.getLista();
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Jogador getObject(@PathParam("id") Long id) {
		Connection conexao = new ConnectionFactory().getConnection();
		JogadorDAO dao = new JogadorDAO(conexao);
		return dao.getObject(id);
	}

	@POST
	@Consumes("application/json")
	public void inserir(Jogador jogador){
		
		Connection conexao = new ConnectionFactory().getConnection();
		JogadorDAO dao = new JogadorDAO(conexao);
		dao.inserir(jogador);
		
	}

	@PUT
	@Consumes("application/json")
	public void alterar(Jogador jogador) {
		
		Connection conexao = new ConnectionFactory().getConnection();
		JogadorDAO dao = new JogadorDAO(conexao);
		dao.alterar(jogador);
		
	}

	@DELETE
	@Consumes("application/json")
	public void deletar(Long id) {

		Connection conexao = new ConnectionFactory().getConnection();
		JogadorDAO dao = new JogadorDAO(conexao);
		dao.deletar(id);
		
	}
}