package modelo;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Planeta p1 = new Planeta("Terra",24,107.200,5.972e24,14,9.7);
		System.out.println(p1.toString());
		Satelite l1 = new Satelite("Lua",1737.10,27, 3500);
		System.out.println(l1.toString());
		Astronomo a1 = new Astronomo("Galileu Galilei", "Itália", "15/02/1564");
		System.out.println(a1.toString());
	}

}
