package aplicacaoTeste;

import fachada.Fachada;
import modelo.Planeta;
import modelo.Astronomo;
import modelo.Satelite;


public class Atualizar {
	public Atualizar(){
		Fachada.inicializar();
		Planeta p;
		Astronomo a;
		Satelite s;

		try {

			p = Fachada.readPlaneta("Marte");
			p.setNome("Planeta Vermelho");
			Fachada.atualizarPlaneta(p);
			
			a = Fachada.readAstronomo("Galileu");
			a.setNome("Galileu Galilei");
			Fachada.atualizarAstronomo(a);

			s = Fachada.readSatelite("Lua");
			s.setNome("Lua da Terra");
			Fachada.atualizarSatelite(s);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("Fim do programa.");
	}
	public static void main(String[] args) {
		new Atualizar();
	}

}
