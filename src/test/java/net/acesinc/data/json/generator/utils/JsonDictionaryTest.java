package net.acesinc.data.json.generator.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JsonDictionaryTest {

	@Test
	public void toJsonTest() {
		Map<String,String> payload = new HashMap<>();
		payload.put("key1","value1");
		payload.put("key2","value2");
		
		String s = new JsonDictionary().toJson(payload);
		assertNotNull(s);
		assertEquals("{\"key1\":\"value1\",\"key2\":\"value2\"}", s);
	}
	
	@Test
	public void moreComplexTest() {
		String expected = "{\"list1\":[\"a\",\"b\",\"c\"],\"list2\":[\"x\",\"y\",\"z\"]}";
		Map<String,List<String>> payload = new HashMap<String,List<String>>();
		
		List<String> list1 = new ArrayList<String> ();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> list2 = new ArrayList<String> ();
		list2.add("x");
		list2.add("y");
		list2.add("z");
		
		payload.put("list1", list1);
		payload.put("list2", list2);
		
		String s = new JsonDictionary().toJson(payload);
		assertNotNull(s);
		assertEquals(expected, s);
	}
	
	@Test
	public void anotherTest() {
		assertNotNull(JsonDictionary.getInstance().getDictionary());
		assertTrue(JsonDictionary.getInstance().getDictionary().containsKey("states"));
		assertTrue(JsonDictionary.getInstance().getDictionary().containsKey("first-names"));
	}
	

}
