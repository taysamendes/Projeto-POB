package aplicacaoTeste;

import fachada.Fachada;


public class Atualizar {
	public Atualizar(){
		Fachada.inicializar();

		try {
			System.out.println("alterando...");
			System.out.println("Digite o nome do planeta, a opcao e a alteracao que deseja fazer");
			System.out.println("1 --- Alterar Nome\n2 --- Alterar Periodo de rotacao\n3 --- Alterar Velocidade\n");
			Fachada.atualizarPlaneta("Terra plana","Terra");
			
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
