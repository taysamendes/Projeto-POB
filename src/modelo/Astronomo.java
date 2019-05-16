package modelo;
import java.util.ArrayList;

public class Astronomo {
	private String nome;
	private String nacionalidade;
	private String nascimento;
	private ArrayList<Satelite> satelites = new ArrayList<>();
	
	public Astronomo(String nome, String nacionalidade, String nascimento) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public ArrayList<Satelite> getSatelites() {
		return satelites;
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + "\nNacionalidade: " + nacionalidade + "\nData de Nascimento: " + nascimento;
	}

	/*-------NOSSAS FUNCOES-----------*/
	
	public void adicionarSatelite(Satelite s) {
		s.adicionarAstronomo(this);
		this.satelites.add(s);
	}
	
	public void removerSatelite(Satelite s) {
		s.removerAstronomo(this);
		this.satelites.remove(s);
	}
	
	public Satelite localizarSatelite(String nome) {
		for(Satelite s : satelites) 
			if(s.getNome().equals(nome))
				return s;
		return null;
	}
}