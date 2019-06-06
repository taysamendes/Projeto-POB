package modelo;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Planeta {
	private String nome; 
	private double per_rotacao;
	private double vel_orbital;
	private double massa;
	private double temperatura;
	private double gravidade;
	
	@OneToMany(mappedBy="planeta", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private ArrayList<Satelite> satelites = new ArrayList<Satelite>();
	
	public Planeta() {};
	
	public Planeta(String nome, double per_rotacao, double vel_orbital, double massa, double temperatura, double gravidade) {
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

	public double getPer_rotacao() {
		return per_rotacao;
	}

	public void setPer_rotacao(double per_rotacao) {
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
//        String results = "+";
//        for (int i = 0; i < this.satelites.size(); i++) {
//            results += " " + this.satelites.get(i);
//        }
//        return results;
		return "\nNome: " + nome + "\nPeriodo de Rotacao (horas/minutos): " + per_rotacao + "\nVelocidade Orbital (km/s): " + vel_orbital + "\nMassa: "
				+ massa + "\nTemperatura: " + temperatura + " °C \nGravidade: " + gravidade;
	}
	
	public String satzada(ArrayList<Satelite> s) {
        String results = "+";
        for (int i = 0; i < this.satelites.size(); i++) {
            results += " " + this.satelites.get(i);
        }
        return results;
	}
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

