package net.acesinc.data.json.generator.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class DictionaryTypeTest {

	@Test
	public void testGetName() {
		DictionaryType instance = new DictionaryType();
		assertEquals(DictionaryType.TYPE_NAME, instance.getName());
	}
	
	// Get a random state from the list
	@Test
	public void testGetState() {
		
		String[] launchArguments = {"[states]"};
		
		DictionaryType instance = new DictionaryType();
		instance.setLaunchArguments(launchArguments);
		
		Map json = (Map) instance.getNextRandomValue();
		assertNotNull(json);
		System.out.println(json);
	}
	
	@Test
	public void testGetFirstName() {
		String[] launchArguments = {"[first-names]"};
		
		DictionaryType instance = new DictionaryType();
		instance.setLaunchArguments(launchArguments);
		
		String name = (String) instance.getNextRandomValue();
		System.out.println(name);
		assertNotNull(name);
	}
	
	@Test
	public void testGetSSN() {
		String[] launchArguments = {"[soc-security-nums]"};
		
		DictionaryType instance = new DictionaryType();
		instance.setLaunchArguments(launchArguments);
		
		String name = (String) instance.getNextRandomValue();
		System.out.println(name);
		assertNotNull(name);
	}
	
	@Test
	public void testGetAccountNumber() {
		String[] launchArguments = {"[account-numbers]"};
		
		DictionaryType instance = new DictionaryType();
		instance.setLaunchArguments(launchArguments);
		
		Object name = instance.getNextRandomValue();
		System.out.println(name);
		assertNotNull(name);
	}
	
	@Test
	public void testGetAddress() {
		String[] launchArguments = {"[addresses]"};
		
		DictionaryType instance = new DictionaryType();
		instance.setLaunchArguments(launchArguments);
		
		Map json = (Map) instance.getNextRandomValue();
		assertNotNull(json);
		System.out.println(json);
	}
}
