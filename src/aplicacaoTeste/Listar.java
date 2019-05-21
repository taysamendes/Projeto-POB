package aplicacaoTeste;

import fachada.Fachada;

public class Listar {
	public Listar() {
		Fachada.inicializar();
		
		try {
			System.out.println(Fachada.listarPlanetas());
			System.out.println(Fachada.listarSatelites());
			System.out.println(Fachada.listarAstronomos());
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("Fim do programa.");
	}
	
    public static void main(String[] args) {
        new Listar();
    }
}
