package aplicacaoTeste;

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			
		System.out.println("\n\nDescoberta mais antiga de um Astronomo:");	
		System.out.println(Fachada.descobertaMaisAntigaDoAstronomo("Hall"));	
		System.out.println("------------------------------------------------");
		System.out.println("Planetas que possuem satélites que foram descobertos por um Astronomo: ");
		System.out.println(Fachada.consultarPlanetaAstronomo("Lassell"));
		System.out.println("------------------------------------------------");
		System.out.println("Satelite mais antigo de um planeta e quem o descobriu");
		System.out.println(Fachada.sateliteMaisAntigo("Jupiter"));
		System.out.println("------------------------------------------------");
		System.out.println(Fachada.consultarPlanetasPorParteNome("te"));
		
		

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