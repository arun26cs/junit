package junittest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathutilsTest {

	Mathutils mathutil;
	TestInfo ti;
	TestReporter tr;
	
	@BeforeAll
	void intiall() {
		System.out.println("before all");
	}
	@BeforeEach
	void init(TestInfo ti,TestReporter tr) {
		mathutil=new Mathutils();
		this.ti=ti;
		this.tr=tr;
		
	}
	@AfterEach
	void printAfterEach() {
		System.out.println(ti.toString()+" "+tr.toString());
		
	}
	@Test
	@Tag("Add")
	@DisplayName("test add function")
	void test() {
		//Mathutils mathutil = new Mathutils();
		int expected = 2;
		int actual=mathutil.add(1, 1);
		assertEquals(expected, actual);
		/*
		 * DefaultTestInfo [displayName = 'repetition 1 of 3', tags = [Mult], testClass = class junittest.MathutilsTest, testMethod = void junittest.MathutilsTest.repeatedTest(org.junit.jupiter.api.RepetitionInfo)] org.junit.jupiter.engine.extension.TestReporterParameterResolver$$Lambda$327/0x00000008400e9c40@44a3ec6b
DefaultRepetitionInfo [currentRepetition = 2, totalRepetitions = 3]
DefaultTestInfo [displayName = 'repetition 2 of 3', tags = [Mult], testClass = class junittest.MathutilsTest, testMethod = void junittest.MathutilsTest.repeatedTest(org.junit.jupiter.api.RepetitionInfo)] org.junit.jupiter.engine.extension.TestReporterParameterResolver$$Lambda$327/0x00000008400e9c40@2698dc7
DefaultRepetitionInfo [currentRepetition = 3, totalRepetitions = 3]
DefaultTestInfo [displayName = 'repetition 3 of 3', tags = [Mult], testClass = class junittest.MathutilsTest, testMethod = void junittest.MathutilsTest.repeatedTest(org.junit.jupiter.api.RepetitionInfo)] org.junit.jupiter.engine.extension.TestReporterParameterResolver$$Lambda$327/0x00000008400e9c40@43d7741f
DefaultTestInfo [displayName = 'MultiplyTest positive', tags = [Mult], testClass = class junittest.MathutilsTest$TestMultiply, testMethod = void junittest.MathutilsTest$TestMultiply.multiplyPositive()] org.junit.jupiter.engine.extension.TestReporterParameterResolver$$Lambda$327/0x00000008400e9c40@48a242ce
DefaultTestInfo [displayName = 'MultiplyTest negatrive', tags = [Mult], testClass = class junittest.MathutilsTest$TestMultiply, testMethod = void junittest.MathutilsTest$TestMultiply.multiplyNegative()] org.junit.jupiter.engine.extension.TestReporterParameterResolver$$Lambda$327/0x00000008400e9c40@133e16fd

		 * 
		 * */
		
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
	@Tag("Mult")
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
			assertEquals(-2, mathutil.mul(-1, 2),"should be negative");
		}
		
	}
	
	
	@RepeatedTest(3)
	@Tag("Mult")
	@DisplayName("Repeated test for the multiply")
	void repeatedTest(RepetitionInfo ri) {
		System.out.println(ri.toString());
		assertEquals(-2, mathutil.mul(-1, 2),"should be negative");
	}
	
	/*
	 	DefaultRepetitionInfo [currentRepetition = 1, totalRepetitions = 3]
DefaultRepetitionInfo [currentRepetition = 2, totalRepetitions = 3]
DefaultRepetitionInfo [currentRepetition = 3, totalRepetitions = 3]

	 */
	

}
