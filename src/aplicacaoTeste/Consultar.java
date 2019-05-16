package aplicacaoTeste;

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			
		System.out.println(Fachada.descobertaMaisAntigaDoAstronomo("Lassell"));	
		//System.out.println(Fachada.SateliteMaiorPeriodoOrbital());
		//System.out.println(Fachada.PlanetaMaisSatelites());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}