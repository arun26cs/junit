package junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathutilsTest {

	@Test
	void test() {
		Mathutils mathutil = new Mathutils();
		int expected = 2;
		int actual=mathutil.add(1, 1);
		assertEquals(expected, actual);
		
		
	}
	@Test
	void testDiv() {
		Mathutils mathutil = new Mathutils(); 
		//System.out.println(mathutil.div(1,0));
		assertThrows(ArithmeticException.class, ()-> mathutil.div(1,0),"Divide by zero eror");
		
		
	}

}
