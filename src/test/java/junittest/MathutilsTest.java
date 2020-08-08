package junittest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

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
	@DisplayName("test add function")
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
	
	@Test
	@Disabled
	void disableTest() {
		fail("this is a fail test");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	void enableOnOSLinux() {
		fail("this is a fail test");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@EnabledOnJre(JRE.JAVA_8)
	void enableOnJRELinux() {
		fail("this is a fail test");
	}
	
	@Test
	@DisplayName("test assumeture and eert true")
	void assumeTest() {
		assumeTrue(1==1);
		assertTrue(1==1);
	}
	
	@Test
	@DisplayName("Assertion for all the testcase for add")
	void assertAllMultiply() {
		assertAll(
				()->assertEquals(0, mathutil.div(0, 2)),
				()->assertThrows(ArithmeticException.class, ()->mathutil.div(2,0),"error"),
				()->assertEquals(2, mathutil.div(4, 2))
				);
		
	}
	
	@Nested
	@DisplayName("Nested test")
	class TestMultiply{
		
		@Test
		@DisplayName("MultiplyTest positive")
		void multiplyPositive(){
			assertEquals(2, mathutil.mul(1, 2));
		}
		
		@Test
		@DisplayName("MultiplyTest negatrive")
		void multiplyNegative(){
			assertEquals(2, mathutil.mul(-1, 2),"should be negative");
		}
		
	}
	

}
