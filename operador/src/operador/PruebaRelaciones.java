package operador;

public class PruebaRelaciones {
	
	public static void main(String [] args) {
		
		int operador1=20;
		int operador2=40;
		int operador3=20;
		boolean resultado1;
		boolean resultado2;
        boolean resultado3;
        boolean resultado4;
        boolean resultado5;
        boolean resultado6;
        boolean resultado7;
        boolean resultado8;

        resultado1=operador1==operador2;//¿es igual?
        resultado2=operador1==operador3;//¿es igual?
        resultado3=operador1!=operador2;//¿es distinto?
        resultado4=operador1>operador2;//¿es mayor?
        resultado5=operador1>operador3; //¿es mayor? 
        resultado6=operador1<operador2; //¿es mayor?
        resultado7=operador1<=operador3; //¿es mayor o igual?
        resultado8=operador1>=operador2;//¿es mayor o igual?
        
        System.out.println("¿" +operador1+"es igual a "+operador2+"?"+ resultado1);
        System.out.println("¿" +operador1+" es igual a "+operador1+"?"+ resultado2);
        System.out.println("¿" +operador1+" es distinto a "+operador2+"?" + resultado3);
        System.out.println("¿"+operador1+" es mayor que "+operador2+"? " +resultado4);
        System.out.println("¿"+operador1+" es mayor que "+operador1+"? " +resultado5);
        System.out.println("¿" +operador2+" es mayor que "+operador1+"? " +resultado6);
        System.out.println("¿"+operador1+" es mayor o igual que "+operador1+"? " +resultado7);
        System.out.println("¿"+operador1+" es mayor o igual a "+operador2+"? " +resultado8);
	}

}
