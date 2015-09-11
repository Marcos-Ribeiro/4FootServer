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

import br.com.fourtech.fourfoot.crud.Crud;
import br.com.fourtech.fourfoot.dao.GrupoDAO;
import br.com.fourtech.fourfoot.db.ConnectionFactory;
import br.com.fourtech.fourfoot.model.Grupo;

@Path("grupo")
public class GrupoResources implements Crud<Grupo>{

	@GET
	@Produces("application/json")
	@Override
	public List<Grupo> getLista() {
		Connection conexao = new ConnectionFactory().getConnection();
		GrupoDAO dao = new GrupoDAO(conexao);
		return dao.getLista();
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	@Override
	public Grupo getObject(@PathParam("id") Long id) {
		Connection conexao = new ConnectionFactory().getConnection();
		GrupoDAO dao = new GrupoDAO(conexao);
		return dao.getObject(id);
	}

	@POST
	@Consumes("application/json")
	@Override
	public void inserir(Grupo grupo) {
		Connection conexao = new ConnectionFactory().getConnection();
		GrupoDAO dao= new GrupoDAO(conexao);
		dao.inserir(grupo);		
	}

	@PUT
	@Consumes("application/json")
	@Override
	public void alterar(Grupo grupo) {
		Connection conexao= new ConnectionFactory().getConnection();
		GrupoDAO dao = new GrupoDAO(conexao);
		dao.alterar(grupo);		
	}

	@DELETE
	@Path("{id}")
	@Override
	public void deletar(@PathParam("id") Long id) {
		Connection conexao = new ConnectionFactory().getConnection();
		GrupoDAO dao = new GrupoDAO(conexao);
		dao.deletar(id);
	}

	
}
