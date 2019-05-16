package aplicacaoTeste;


import fachada.Fachada;
import modelo.Planeta;
import modelo.Astronomo;
import modelo.Satelite;


public class Cadastrar {

   public Cadastrar(){
       Fachada.inicializar();
       Planeta p;
       Planeta p2;
       Satelite s;
       Astronomo a1;
       Astronomo a2;
       try {
    	   
           System.out.println("Cadastrando...");
           
           s=Fachada.cadastrarSatelite("Lua", 1737.10, 27.32, 0);

           p=Fachada.cadastrarPlaneta("Terra", 24, 107.200, 5.9736e24, 14, 9.78);
           p2=Fachada.cadastrarPlaneta("Marte", 24, 107.200, 5.9736e24, 14, 9.78);
           
           a1= Fachada.cadastrarAstronomo("Mayara", "brasileira", "27/09/1995");
           a2= Fachada.cadastrarAstronomo("Taysa", "brasileira", "03/07/1993");
           
			Fachada.adicionarSatelitePlaneta("Terra", "Lua");

           


          
          
       } catch (Exception e) {System.out.println(e.getMessage());}


       Fachada.finalizar();
       System.out.println("fim do programa");
   }


   public void cadastrar(){

   }   


   //=================================================
   public static void main(String[] args) {
       new Cadastrar();
   }
}