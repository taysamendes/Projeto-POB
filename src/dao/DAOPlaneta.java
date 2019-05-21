package dao;
import java.util.List;
import com.db4o.query.Query;
import modelo.Planeta;

public class DAOPlaneta  extends DAO<Planeta>{
	//Leitura POR nome 
	public Planeta read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Planeta.class);
		q.descend("nome").constrain(nome);
		List<Planeta> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PLANETA
	 * 
	 **********************************************************/
	public List<Planeta> consultarPlanetasPorParteNome(String caracteres) {
	    Query q = manager.query();
	    q.constrain(Planeta.class);
	    q.descend("nome").constrain(caracteres).like();
	    List<Planeta> result = q.execute(); 
	    return result;
	}
	
	//lista os planetas que tem satelites que foram descobertos pelo astronomo que foi passado como parametro
	public List<Planeta> consultarPlanetaAstronomo(String nome){
		Query q = manager.query();
		q.constrain(Planeta.class);
		q.descend("satelites").descend("astronomos").descend("nome").constrain(nome);
		List<Planeta> result = q.execute();
		return result;
	}
}