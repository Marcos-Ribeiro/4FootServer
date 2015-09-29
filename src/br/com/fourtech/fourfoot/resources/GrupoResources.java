package br.com.fourtech.fourfoot.resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.fourtech.fourfoot.dao.GrupoDAO;
import br.com.fourtech.fourfoot.dao.JogadorGrupoDAO;
import br.com.fourtech.fourfoot.db.ConnectionFactory;
import br.com.fourtech.fourfoot.model.Grupo;
import br.com.fourtech.fourfoot.model.JogadorGrupo;

@Path("grupo")
public class GrupoResources{

	@GET
	@Produces("application/json")
	public List<Grupo> getLista() {
		Connection conexao = new ConnectionFactory().getConnection();
		GrupoDAO dao = new GrupoDAO(conexao);
		return dao.getLista();
	}

//	@GET
//	@Path("{id}")
//	@Produces("application/json")
//	public Grupo getObject(@PathParam("id") Long id) {
//		Connection conexao = new ConnectionFactory().getConnection();
//		GrupoDAO dao = new GrupoDAO(conexao);
//		return dao.getObject(id);
//	}
	
	@GET
	@Path("jogador={id}")
	@Produces("application/json")
	public List<JogadorGrupo> getGruposJogador(@PathParam("id") Long id) {
		
		Connection conexao = new ConnectionFactory().getConnection();
		
		JogadorGrupoDAO daojg = new JogadorGrupoDAO(conexao);
		GrupoDAO daogru = new GrupoDAO(conexao);

		
		
		//JSONObject json = new JSONObject();
		
//		try{
//			List<JogadorGrupo> ljg = new ArrayList<JogadorGrupo>();
//		//	List<Grupo> lgr = new ArrayList<Grupo>();
//			//ljg = daojg.getGruposJogador(id);
//			
////			for (int i = 0; i < lgr.size(); i++) {								
////				lgr.add(daogru.getGruposJogador(ljg.get(i).getIdgrupo()));
////			}
//			//json.put("jogador_grupo", daojg.getGruposJogador(id));
//			//json.put("grupo", lgr);
//			
//		}catch(JSONException e){
//			e.printStackTrace();
//		}
		List<JogadorGrupo> ljg = new ArrayList<JogadorGrupo>();
		ljg = daojg.getGruposJogador(id);
		closeDb(conexao);
		
		return ljg;
		
	}

	@POST
	@Consumes("application/json")
	public void inserir(Grupo grupo) {
		Grupo novoGrupo = new Grupo();
		try {
			JSONObject jobj = new JSONObject(grupo);			
			novoGrupo.setNome(jobj.getString("nome").toString());
		
			Connection conexao = new ConnectionFactory().getConnection();
			GrupoDAO dao = new GrupoDAO (conexao);
			dao.inserir(novoGrupo);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}	
	}

	@PUT
	@Consumes("application/json; charset=UTF-8")
	public void alterar(Grupo grupo) {
		Grupo novoGrupo = new Grupo();
		try {
			JSONObject jobj = new JSONObject(grupo);	
			novoGrupo.setIdgrupo(jobj.getLong("idgrupo"));
			novoGrupo.setNome(jobj.getString("nome"));
		
			Connection conexao = new ConnectionFactory().getConnection();
			GrupoDAO dao = new GrupoDAO(conexao);
			dao.alterar(novoGrupo);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}	
	}

	@Path("{id}")
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String delete(@PathParam("id") Long id) {
		String str;
		try{
			Connection conexao = new ConnectionFactory().getConnection();
			GrupoDAO dao = new GrupoDAO(conexao);
			dao.deletar(id);
			str = "{\"categoria\":{\"msg\":\"Categoria exluída com sucesso!\"}}";
			return str;
		}catch(Exception e){
			str = "{\"categoria\":{\"msg\":\"" + e.getMessage() +"\"}}";
			return str;
		}
	}


	private void closeDb(Connection conexao){

		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}