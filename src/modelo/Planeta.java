package modelo;

import java.util.ArrayList;

public class Planeta {
	private String nome; 
	private int per_rotacao;
	private double vel_orbital;
	private double massa;
	private double temperatura;
	private double gravidade;
	private ArrayList<Satelite> satelites = new ArrayList<>();
	
	public Planeta(String nome, int per_rotacao, double vel_orbital, double massa, double temperatura, double gravidade) {
		this.nome = nome;
		this.per_rotacao = per_rotacao;
		this.vel_orbital = vel_orbital;
		this.massa = massa;
		this.temperatura = temperatura;
		this.gravidade = gravidade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPer_rotacao() {
		return per_rotacao;
	}

	public void setPer_rotacao(int per_rotacao) {
		this.per_rotacao = per_rotacao;
	}

	public double getVel_orbital() {
		return vel_orbital;
	}

	public void setVel_orbital(double vel_orbital) {
		this.vel_orbital = vel_orbital;
	}

	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getGravidade() {
		return gravidade;
	}

	public void setGravidade(double gravidade) {
		this.gravidade = gravidade;
	}

	public ArrayList<Satelite> getSatelites() {
		return satelites;
	}


	@Override
	public String toString() {
		return "Planeta \nNome: " + nome + "\nPeríodo de Rotação: " + per_rotacao + "h\nVelocidade Orbital: " + vel_orbital + "km/h\nMassa: "
				+ massa + "kg\nTemperatura: " + temperatura + "°C\nGravidade: " + gravidade + "m/s²\nLuas: " + satelites;
	}
	/*------------------------------------------------------------------------------------------------------NOSSAS FUNÇÕES------------------------------------------------------------------------------------------------------*/
	public void adicionarSatelite(Satelite s) {
		s.setPlaneta(this);
		this.satelites.add(s);
	}
	
	public void removerSatelite(Satelite s) {
		s.setPlaneta(null);
		this.satelites.remove(s);
	}
	
	public Satelite localizarSatelite(String nome) {
		for(Satelite s : satelites) 
			if(s.getNome().equals(nome))
				return s;
		return null;
	}
	
	
	
}

