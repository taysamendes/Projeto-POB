package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

public class Satelite {
	private String nome;
	private double raio;
	private double per_orbital;
	private int ano_descoberta;
	private Planeta planeta;
	
	@ManyToMany(mappedBy="satelites", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private ArrayList<Astronomo> astronomos = new ArrayList<>();
	
	public Satelite() {};
	
	public Satelite(String nome, double raio, double per_orbital, int ano_descoberta) {
		super();
		this.nome = nome;
		this.raio = raio;
		this.per_orbital = per_orbital;
		this.ano_descoberta = ano_descoberta;
	}
	
	public void adicionarPlaneta(Planeta p) {
		this.planeta = p;
	}
	
	public void adicionarAstronomo(Astronomo a) {
		this.astronomos.add(a);
	}
	
	public void removerAstronomo(Astronomo a) {
		this.astronomos.remove(a);
	}
	
	// Getters and Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getPer_orbital() {
		return per_orbital;
	}

	public void setPer_orbital(int per_orbital) {
		this.per_orbital = per_orbital;
	}

	public int getAno_descoberta() {
		return ano_descoberta;
	}

	public void setAno_descoberta(int ano_descoberta) {
		this.ano_descoberta = ano_descoberta;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta p) {
		this.planeta = p;
	}
	

	public ArrayList<Astronomo> getAstronomos() {
		return astronomos;
	}

	public void setAstronomos(ArrayList<Astronomo> astronomos) {
		this.astronomos = astronomos;
	}
	

	@Override
	public String toString() {
		return "\nNome: " + nome + "\nRaio: " + raio + "\nPeriodo Orbital (dias): " + per_orbital + "\nAno descoberta: "
				+ ano_descoberta + "\nPlaneta: " + planeta.getNome();
	}


}
