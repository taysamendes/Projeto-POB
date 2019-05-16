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
		Planeta p3;
		Planeta p4;
		Planeta p5;
		Planeta p6;
		Planeta p7;
		Satelite s;
		Satelite s2;
		Satelite s3;
		Satelite s4;
		Satelite s5;
		Satelite s6;
		Satelite s7;
		Satelite s8;
		Satelite s9;
		Satelite s10;
		Satelite s11;
		Satelite s12;
		Satelite s13;
		Satelite s14;
		Satelite s15;
		Satelite s16;
		Satelite s17;
		Satelite s18;
		Astronomo a1;
		Astronomo a2;
		Astronomo a3;
		Astronomo a4;
		Astronomo a5;
		Astronomo a6;
		Astronomo a7;
		Astronomo a8;
		try {

			System.out.println("Cadastrando...");

	           p=Fachada.cadastrarPlaneta("Terra", 23.56, 29.78, 5.9736e24, 14, 9.78);
			   p2=Fachada.cadastrarPlaneta("Marte", 24.37, 24.077, 6.4174e23, -63, 9.71);
			   p3=Fachada.cadastrarPlaneta("Jupiter", 9.8, 13.07, 1.8986e27, -108, 24.79);
			   p4=Fachada.cadastrarPlaneta("Saturno", 10.34, 9.69, 5.6846e26, -139, 10.44);
			   p5=Fachada.cadastrarPlaneta("Urano", 24, 6.81, 8.6810e2, -220, 8.69);
			   p6=Fachada.cadastrarPlaneta("Netuno", 16.6, 5.43, 1.0243e26, -201, 11.15);
			   p7=Fachada.cadastrarPlaneta("Plutao", 153.17, 4.66, 1.305e22, -229, 0.65);
	           
	           a1= Fachada.cadastrarAstronomo("Christy", "Estados Unidos", "14 de julho de 1938");
			   a2= Fachada.cadastrarAstronomo("Sheppard", "Estados Unidos", "1977");
			   a3= Fachada.cadastrarAstronomo("Lassell", "Inglaterra", "18 de junho de 1799");
			   a4= Fachada.cadastrarAstronomo("Herschel", "Alemanha", "15 de novembro de 1738");
			   a5= Fachada.cadastrarAstronomo("Huygens",  "Holanda", "14 de abril de 1629");
			   a6= Fachada.cadastrarAstronomo("Cassini", "Itália", "8 de junho de 1625");
			   a7= Fachada.cadastrarAstronomo("Galileu", "Itália", "15 de fevereiro de 1564");
			   a8= Fachada.cadastrarAstronomo("Hall", "Estados Unidos", "15 de outubro de 1829");
			   
			   s=Fachada.cadastrarSatelite("Lua", 1737.10, 27.32, 0001);
	           s2=Fachada.cadastrarSatelite("Fobos", 11.1, 0.319, 1877);
			   s3=Fachada.cadastrarSatelite("Deimos", 6.2, 1.262, 1877);
			   s4=Fachada.cadastrarSatelite("Io", 1818.1, 1.769, 1610);
			   s5=Fachada.cadastrarSatelite("Europa", 1560.7, 3.551, 1610);
			   s6=Fachada.cadastrarSatelite("Ganimedes", 2634.1, 7.155, 1610);
			   s7=Fachada.cadastrarSatelite("Calisto", 2408.4, 16.69, 1610);
			   s8=Fachada.cadastrarSatelite("Amalteia", 83.45, 0.498, 1892);
			   s9=Fachada.cadastrarSatelite("Tebe", 49.3, 0.675, 1979);
			   s10=Fachada.cadastrarSatelite("Mimas", 198.2, 0.942, 1789);
			   s11=Fachada.cadastrarSatelite("Titã", 2575.5, 15.95, 1655);
			   s12=Fachada.cadastrarSatelite("Reia", 764.5, 4.518, 1672);
			   s13=Fachada.cadastrarSatelite("Ariel", 578.9, 2.520, 1851);
			   s14=Fachada.cadastrarSatelite("Umbriel", 584.7, 4.144, 1851);
			   s15=Fachada.cadastrarSatelite("Titânia", 788.9, 8.706, 1787);
			   s16=Fachada.cadastrarSatelite("Deimos", 6.2, 1.262, 1877);
			   s17=Fachada.cadastrarSatelite("Nereida", 170, 360.14, 1949);
			   s18=Fachada.cadastrarSatelite("Caronte", 603.6, 6.387, 1978);

	           Fachada.adicionarSatelitePlaneta("Terra", "Lua");
	           Fachada.adicionarSatelitePlaneta("Marte", "Fobos");
			   Fachada.adicionarSatelitePlaneta("Marte", "Deimos");
			   Fachada.adicionarSatelitePlaneta("Jupiter", "Io");
			   Fachada.adicionarSatelitePlaneta("Jupiter", "Europa");
			   Fachada.adicionarSatelitePlaneta("Jupiter", "Ganimedes");
			   Fachada.adicionarSatelitePlaneta("Jupiter", "Calisto");
			   Fachada.adicionarSatelitePlaneta("Jupiter", "Amalteia");
			   Fachada.adicionarSatelitePlaneta("Saturno", "Mimas");
			   Fachada.adicionarSatelitePlaneta("Saturno", "Titan");
			   Fachada.adicionarSatelitePlaneta("Saturno", "Reia");
			   Fachada.adicionarSatelitePlaneta("Urano", "Ariel");
			   Fachada.adicionarSatelitePlaneta("Urano", "Umbriel");
			   Fachada.adicionarSatelitePlaneta("Urano", "Titania");
			   Fachada.adicionarSatelitePlaneta("Netuno", "Tritao");
			   Fachada.adicionarSatelitePlaneta("Netuno", "Nereida");
			   Fachada.adicionarSatelitePlaneta("Plutao", "Caronte");

		
			   Fachada.adicionarSateliteAstronomo("Fobos", "Hall");
			   Fachada.adicionarSateliteAstronomo("Deimos", "Hall");
			   Fachada.adicionarSateliteAstronomo("Io", "Galileu");
			   Fachada.adicionarSateliteAstronomo("Europa", "Galileu");
			   Fachada.adicionarSateliteAstronomo("Ganimedes", "Galileu");
			   Fachada.adicionarSateliteAstronomo("Calisto", "Galileu");
			   Fachada.adicionarSateliteAstronomo("Amalteia", "Barnard");
			   Fachada.adicionarSateliteAstronomo("Tebe", "Synnot");
			   Fachada.adicionarSateliteAstronomo("Mimas", "Herschel");
			   Fachada.adicionarSateliteAstronomo("Titan", "Huygens");
			   Fachada.adicionarSateliteAstronomo("Reia", "Cassini");			
			   Fachada.adicionarSateliteAstronomo("Ariel", "Lassell");
			   Fachada.adicionarSateliteAstronomo("Umbriel", "Lassell");
			   Fachada.adicionarSateliteAstronomo("Titania", "Herschel");
			   Fachada.adicionarSateliteAstronomo("Tritao", "Lassell");
			   Fachada.adicionarSateliteAstronomo("Nereida", "Kuiper");
			   Fachada.adicionarSateliteAstronomo("Caronte", "Christy");


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