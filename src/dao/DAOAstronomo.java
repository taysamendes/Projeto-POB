package dao;
import java.util.List;

import com.db4o.query.Query;

import modelo.Astronomo;

public class DAOAstronomo extends DAO<Astronomo> {
	//Leitura POR nome 
	public Astronomo read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Astronomo.class);
		q.descend("nome").constrain(nome);
		List<Astronomo> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
/**********************************************************
 * 
 * TODAS AS CONSULTAS DE ASTRONOMO
 * 
 **********************************************************/

	public  List<Astronomo> consultarAstronomoPorParteNome(String caracteres) {
	    Query q = manager.query();
	    q.constrain(Astronomo.class);
	    q.descend("nome").constrain(caracteres).like();
	    List<Astronomo> result = q.execute(); 
	    	return result;
	}

}