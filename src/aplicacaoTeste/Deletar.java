package aplicacaoTeste;

import fachada.Fachada;

public class Deletar {
	public Deletar() {
		Fachada.inicializar();
		
		try {
            System.out.println("deletando...");
//			Fachada.excluirPlaneta("Terra");
			Fachada.excluirAstronomo("Taysa");
			Fachada.excluirSatelite("Lua");
			Fachada.listarPlanetas();
			
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
