package aplicacaoTeste;

import fachada.Fachada;

public class Deletar {
	public Deletar() {
		Fachada.inicializar();
		
		try {
			System.out.println("deletando...");
			
			Fachada.excluirPlaneta("Terra");
			Fachada.excluirAstronomo("Sheppard");
			Fachada.excluirSatelite("Lua");
			Fachada.excluirSateliteAstronomo("Umbriel", "Lassell");
			Fachada.excluirSatelitePlaneta("Urano", "Umbriel");

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("Fim do programa.");
	}
	
    public static void main(String[] args) {
        new Deletar();
    }
}
