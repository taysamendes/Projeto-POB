package dao;
import java.util.List;
import com.db4o.query.Query;

import modelo.Satelite;

public class DAOSatelite  extends DAO<Satelite>{
	//Leitura POR nome 
	public Satelite read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Satelite.class);
		q.descend("nome").constrain(nome);
		List<Satelite> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	

	public List<Satelite> descobertaMaisAntigaDoAstronomo(String nome) {

		Query q = manager.query();
		q.constrain(Satelite.class);
		q.descend("planeta").descend("satelites").descend("astronomos").descend("nome").constrain(nome);
	    List<Satelite> result = q.execute(); 
	    	return result;
	}
	
	//O SATELITE MAIS ANTIGO DE UM DADO PLANETA E O NOME DO ASTRONOMO
	public List<Satelite> sateliteMaisAntigo(String nome) {

		Query q = manager.query();
		q.constrain(Satelite.class);
		q.descend("astronomos").descend("satelites").descend("planeta").descend("nome").constrain(nome);
	    List<Satelite> result = q.execute(); 
	    	return result;
	}
	
}
