package br.com.fourtech.fourfoot.resources;

import java.sql.Connection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.fourtech.fourfoot.dao.UsuarioDAO;
import br.com.fourtech.fourfoot.db.ConnectionFactory;
import br.com.fourtech.fourfoot.model.Usuario;

@Path("login")
public class LoginResources {

	@Path("{nome}/{senha}")
	@GET
	@Produces("application/json")
	public Usuario login(@PathParam("nome") String nome, @PathParam("senha") String senha){
		Connection conexao = new ConnectionFactory().getConnection();
		UsuarioDAO dao = new UsuarioDAO(conexao);		
		return dao.getLogin(nome, senha);
	}

}