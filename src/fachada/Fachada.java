package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOAstronomo;
import dao.DAOPlaneta;
import dao.DAOSatelite;
import modelo.Astronomo;
import modelo.Planeta;
import modelo.Satelite;

public class Fachada {
	private static DAOPlaneta daoplaneta = new DAOPlaneta();
	private static DAOSatelite daosatelite = new DAOSatelite();
	private static DAOAstronomo daoastronomo = new DAOAstronomo();

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	/*--------- CADASTROS ----------*/

	public static Planeta cadastrarPlaneta(String nome, int per_rotacao, double vel_orbital, double massa,
			double temperatura, double gravidade) throws Exception {
		DAO.begin();
		Planeta p = daoplaneta.read(nome);
		if (p != null)
			throw new Exception("cadastrar planeta - planeta ja cadastrado:" + nome);

		p = new Planeta(nome, per_rotacao, vel_orbital, massa, temperatura, gravidade);
		daoplaneta.create(p);
		DAO.commit();
		return p;
	}

	public static Satelite cadastrarSatelite(String nome, double raio, double per_orbital, int ano_descoberta)
		throws Exception {
		DAO.begin();
		Satelite s = daosatelite.read(nome);
		if (s != null)
			throw new Exception("cadastrar satelite - satelite ja cadastrado:" + nome);

		s = new Satelite(nome, raio, per_orbital, ano_descoberta);
		daosatelite.create(s);
		DAO.commit();
		return s;
	}

	public static Astronomo cadastrarAstronomo(String nome, String nacionalidade, String nascimento) throws Exception {
		DAO.begin();
		Astronomo a = daoastronomo.read(nome);
		if (a != null)
			throw new Exception("cadastrar astronomo - astronomo ja cadastrado:" + nome);

		a = new Astronomo(nome, nacionalidade, nascimento);
		daoastronomo.create(a);
		DAO.commit();
		return a;
	}

	/*--------- LISTAGENS  ----------*/

	public static String listarPlanetas() {
		List<Planeta> planetas = daoplaneta.readAll();
		String texto = "-----------listagem de Planetas-----------\n";
		for (Planeta pl : planetas) {
			texto += pl + "\n";
		}
		return texto;
	}

	public static String listarAstronomos() {
		List<Astronomo> astronomos = daoastronomo.readAll();
		String texto = "-----------listagem de Astronomos-----------\n";
		for (Astronomo a : astronomos) {
			texto += a + "\n";
		}
		return texto;
	}

	public static String listarSatelites() {
		List<Satelite> satelites = daosatelite.readAll();
		String texto = "-----------listagem de Satelites---------\n";
		for (Satelite s : satelites) {
			texto += "\n" + s;
		}
		return texto;
	}
		/*--------- RELACIONAMENTOS ----------*/

	public static void adicionarSatelitePlaneta(String planeta, String satelite) throws Exception {
		DAO.begin();
		Planeta p = daoplaneta.read(planeta);
		if (p == null)
			throw new Exception("adicionar planeta - planeta nao cadastrado: " +planeta);
		Satelite s = daosatelite.read(satelite);
		if (s == null)
			throw new Exception("adicionar satelite - satelite nao cadastrado: " + satelite);

		p.adicionarSatelite(s);
		s.adicionarPlaneta(p);
		daoplaneta.update(p);
		daosatelite.update(s);
		DAO.commit();
	}
	
	public static void adicionarSateliteAstronomo(String satelite,String astronomo) throws Exception {
		DAO.begin();
		Satelite s = daosatelite.read(satelite);
		if (s == null)
			throw new Exception("adicionar satelite - satelite nao cadastrado: " +satelite);
		
		Astronomo a = daoastronomo.read(astronomo);
		if (a == null)
			throw new Exception("adicionar astronomo - astronomo nao cadastrado: " + astronomo);

		a.adicionarSatelite(s);
		s.adicionarAstronomo(a);
		daoastronomo.update(a);
		daosatelite.update(s);
		DAO.commit();
	}
	/*--------- EXCLUSÃO DE RELACIONAMENTOS ----------*/

	public static void excluirSatelitePlaneta(String planeta, String satelite) throws Exception{
		
		DAO.begin();
		Planeta p = daoplaneta.read(planeta);
		if (p == null)
			throw new Exception("excluir planeta - planeta nao cadastrado:" +planeta);
		Satelite s = daosatelite.read(satelite);
		if (s == null)
			throw new Exception("excluir satelite - satelite nao cadastrado:" +satelite);
		
		s = p.localizarSatelite(satelite);
		if(s==null) 
			throw new Exception("excluir satelite - planeta nao possui este satelite: "+satelite);
		
		p.removerSatelite(s);
		daoplaneta.update(p);
		daosatelite.delete(s);
		DAO.commit();
	}
	
	public static void excluirSateliteAstronomo(String astronomo, String satelite) throws Exception{
		
		DAO.begin();
		Astronomo a = daoastronomo.read(astronomo);
		if (a == null)
			throw new Exception("excluir astronomo - astronomo nao cadastrado:" + astronomo);
		Satelite s = daosatelite.read(satelite);
		if (s == null)
			throw new Exception("excluir satelite - satelite nao cadastrado:" + satelite);	
		s = a.localizarSatelite(satelite);
		if(s==null) 
			throw new Exception("excluir satelite - astronomo nao possui este satelite: "+satelite);
		
		a.removerSatelite(s);
		daoastronomo.update(a);
		daosatelite.delete(s);
		DAO.commit();
	}
	
	/*--------- UPDATES ----------*/

    public static void atualizarPlaneta(String nome, String novonome) throws Exception{
        DAO.begin();        
        Planeta p = daoplaneta.read(nome);    
        if (p==null)
            throw new Exception("alterar planeta - nome inexistente:" + nome);
 
        p.setNome(novonome);            
        p=daoplaneta.update(p);      
        DAO.commit();   
    }
 
    public static void atualizarSatelite(String nome, String novonome) throws Exception{
        DAO.begin();        
        Satelite s = daosatelite.read(nome);    
        if (s==null)
            throw new Exception("alterar satelite - nome inexistente:" + nome);
 
        s.setNome(novonome);            
        s=daosatelite.update(s);      
        DAO.commit();   
    }
 


    public static void atualizarAstronomo(String nome, String novonome) throws Exception{
        DAO.begin();        
        Astronomo a = daoastronomo.read(nome);    
        if (a==null)
            throw new Exception("alterar astronomo - nome inexistente:" + nome);
 
        a.setNome(novonome);            
        a=daoastronomo.update(a);      
        DAO.commit();   
    }
	
	/*--------- REMOÇÕES ----------*/

    public static void excluirPlaneta(String nome) throws Exception {
        DAO.begin();
        Planeta p = daoplaneta.read(nome);
        if (p==null) 
            throw new Exception("excluir planeta - nome inexistente:" + nome);
 
        daoplaneta.delete(p);
        DAO.commit();
    }
	
	public static void excluirSatelite(String nome) throws Exception {
		DAO.begin();
        Satelite s = daosatelite.read(nome);
        if (s==null) 
            throw new Exception("excluir satelite - satelite inexistente:" + nome);
 
        daosatelite.delete(s);
		DAO.commit();
	}

	public static void excluirAstronomo(String nome) throws Exception {
		DAO.begin();
        Astronomo a = daoastronomo.read(nome);
        if (a==null) 
            throw new Exception("excluir astronomo - astronomo inexistente:" + nome);
 
        daoastronomo.delete(a);
		DAO.commit();
	}


	/*--------- CONSULTAS ----------*/
	public static String consultarPlanetasPorParteNome(String nome) {
	    List<Planeta> result = daoplaneta.consultarPlanetasPorParteNome(nome);
	
	    String texto = "\nConsultar pessoas por parte do nome:"+nome;
	    if (result.isEmpty())  
	        texto += "consulta vazia";
	    else
	        for(Planeta p: result)texto += "\n" + p;
	    return texto;
	}
	
	
	
	
	
}
	
