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

	public static Planeta cadastrarPlaneta(String nome, double per_rotacao, double vel_orbital, double massa,
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
		daoplaneta.update(p);
		s.adicionarPlaneta(p);
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
		daoastronomo.update(a);
		s.adicionarAstronomo(a);
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
	public static Planeta readPlaneta(String nome) throws Exception {
		Planeta pla = daoplaneta.read(nome);
		if(pla == null)
				throw new Exception("Planeta nao encontrado");
		return pla;
	}

	public static Astronomo readAstronomo(String nome) throws Exception {
		Astronomo ast = daoastronomo.read(nome);
		if(ast == null)
				throw new Exception("Astronomo nao encontrado");
		return ast;
	}

	public static Satelite readSatelite(String nome) throws Exception {
		Satelite sat = daosatelite.read(nome);
		if(sat == null)
				throw new Exception("Satelite nao encontrado");
		return sat;
	}

    public static void atualizarPlaneta(Planeta p) throws Exception{
        DAO.begin();                   
        p=daoplaneta.update(p);      
        DAO.commit();   
	}
	public static void atualizarAstronomo(Astronomo a) throws Exception{
        DAO.begin();                   
        a=daoastronomo.update(a);      
        DAO.commit();   
	}
	public static void atualizarSatelite(Satelite s) throws Exception{
        DAO.begin();                   
        s=daosatelite.update(s);      
        DAO.commit();   
    }

	/*--------- REMOÇÕES ----------*/

    public static void excluirPlaneta(String nome) throws Exception {
        DAO.begin();
        Planeta p = daoplaneta.read(nome);
        if (p==null) 
            throw new Exception("excluir planeta - nome inexistente:" + nome);
 
        for(Satelite s : p.getSatelites()) {
        	s.setPlaneta(null);
        	daosatelite.update(s);
        }
        	
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
	
	    String texto = "\nConsultar planetas por parte do nome:"+nome;
	    if (result.isEmpty())  
	        texto += "consulta vazia";
	    else
	        for(Planeta p: result)texto += "\n" + p;
	    return texto;
	}
	
	public static String descobertaMaisAntigaDoAstronomo(String nome) {
		String result = "";
		List<Satelite> sat = daosatelite.descobertaMaisAntigaDoAstronomo(nome);
		int maisvelho = 9999;

		for(Satelite s : sat) {
			if(s.getAno_descoberta() < maisvelho)
				maisvelho = s.getAno_descoberta();
		}
			result += Integer.toString(maisvelho);
					
		return "A descoberta mais antiga do astronomo " + nome + " foi no ano de " + result + "\n";
	}
	
	//lista os planetas que tem satelites que foram descobertos pelo astronomo que foi passado como parametro
	public static String consultarPlanetaAstronomo(String nome){
		List<Planeta> p = daoplaneta.consultarPlanetaAstronomo(nome);
		String result = "";
		
		for(Planeta pla : p)
			result += pla.getNome()+"\n";
		return "Os planetas que possuem satelites que foram descobertos pelo astronomo "+nome+" sao:\n"+ result;
	}	
	
	public static String sateliteMaisAntigo(String nome) {
		List<Satelite> sat = daosatelite.sateliteMaisAntigo(nome);
		int maisvelho = 9999;
		Satelite satelitevelho = null;
		
		for(Satelite s : sat) {
			if(s.getAno_descoberta() < maisvelho) {
				maisvelho = s.getAno_descoberta();
				satelitevelho  = s;
			}
		}		
		
		return "O satelite mais antigo de "+ nome + " � " + satelitevelho.getNome() + " que foi descoberto em "
					+satelitevelho.getAno_descoberta()+" por "+satelitevelho.getAstronomos().get(0).getNome();	
		
	}
	
}
	

