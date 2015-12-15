package net.acesinc.data.json.generator.types;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TypeHandlerFactoryTest {

	private TypeHandlerFactory factory;
	private Map<String, Object> vals;
	
	@Before
	public void setUp() {
		factory = TypeHandlerFactory.getInstance();
		vals = new LinkedHashMap<>();
	}
	
	@Test
	public void testAlphaNumericType() {
		TypeHandler handler = factory.getTypeHandler("alphaNumeric(10)", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof AlphaNumericType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testAlphaType() {
		TypeHandler handler = factory.getTypeHandler("alpha(5)", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof AlphaType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testBooleanType() {
		TypeHandler handler = factory.getTypeHandler("boolean()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof BooleanType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testCounterType() {
		TypeHandler handler = factory.getTypeHandler("counter('one')", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof CounterType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testDateType() {
		TypeHandler handler = factory.getTypeHandler("date()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof DateType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testDoubleType() {
		TypeHandler handler = factory.getTypeHandler("double(80000.44)", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof DoubleType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testFirstNameType() {
		TypeHandler handler = factory.getTypeHandler("firstName()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof FirstName);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testIntegerType() {
		TypeHandler handler = factory.getTypeHandler("integer(10, 20)", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof IntegerType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testLastNameType() {
		TypeHandler handler = factory.getTypeHandler("lastName()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof LastName);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testLongType() {
		TypeHandler handler = factory.getTypeHandler("long(895043890865)", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof LongType);
		assertNotNull(handler.getNextRandomValue());
	}	
	
	@Test
	public void testNowType() {
		TypeHandler handler = factory.getTypeHandler("now()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof NowType);
		assertNotNull(handler.getNextRandomValue());
	}	
	
	@Test
	public void testRandomType() {
		TypeHandler handler = factory.getTypeHandler("random('one', 'two', 'three')", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof RandomType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testSsnType() {
		TypeHandler handler = factory.getTypeHandler("ssn()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof SsnType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testTimestampType() {
		TypeHandler handler = factory.getTypeHandler("timestamp(\"2015/03/01\")", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof TimestampType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testUuidType() {
		TypeHandler handler = factory.getTypeHandler("uuid()", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof UuidType);
		assertNotNull(handler.getNextRandomValue());
	}
	
	@Test
	public void testDictionaryType() {
		TypeHandler handler = factory.getTypeHandler("dictionary([states])", vals, "");
		assertNotNull(handler);
		assertTrue(handler instanceof DictionaryType);
		assertNotNull(handler.getNextRandomValue());
	}
	

}
