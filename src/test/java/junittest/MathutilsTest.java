package junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathutilsTest {

	Mathutils mathutil;
	
	@BeforeAll
	void intiall() {
		System.out.println("before all");
	}
	@BeforeEach
	void init() {
		mathutil=new Mathutils();
	}
	@Test
	void test() {
		//Mathutils mathutil = new Mathutils();
		int expected = 2;
		int actual=mathutil.add(1, 1);
		assertEquals(expected, actual);
		
		
	}
	@Test
	void testDiv() {
		//Mathutils mathutil = new Mathutils(); 
		//System.out.println(mathutil.div(1,0));
		assertThrows(ArithmeticException.class, ()-> mathutil.div(1,0),"Divide by zero eror");
		
		
	}

}
