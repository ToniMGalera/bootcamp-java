package Proyecto.Maven.Tareas.com.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
class CalcSumaRestaMult {

	static double op1;
	static double op2;

	static void setUpBeforeClass() throws Exception {

		op1 = 3;
		op2 = 2;

	}

	@Test
	void testSuma() {

		double esperado = 5;
		double calculado = op1 + op2;
		assertEquals(esperado, calculado);
	}
	
	private void assertEquals(double esperado, double calculado) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void testResta() {
		
		double esperado = 1;
		double calculado = op1 - op2;
		assertEquals(esperado, calculado);
	}
	
	@Test
	void testMultiplicacion() {
		double esperado = 6;
		double calculado = op1 * op2;
		assertEquals(esperado, calculado);
		
	}
}