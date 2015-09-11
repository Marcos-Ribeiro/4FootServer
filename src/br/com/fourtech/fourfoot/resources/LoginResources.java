package br.com.fourtech.fourfoot.resources;

import java.sql.Connection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.fourtech.fourfoot.dao.JogadorDAO;
import br.com.fourtech.fourfoot.db.ConnectionFactory;
import br.com.fourtech.fourfoot.model.Jogador;

@Path("login")
public class LoginResources {

	@Path("{nome}/{senha}")
	@GET
	@Produces("application/json")
	public Jogador login(@PathParam("nome") String nome, @PathParam("senha") String senha){
		Connection conexao = new ConnectionFactory().getConnection();
		JogadorDAO dao = new JogadorDAO(conexao);		
		return dao.login(nome, senha);
	}
//	
//	@GET
//	@Path("teste")
//	@Produces("application/json")
//	public String teste(){
//		return "TESTE";
//	}
}
