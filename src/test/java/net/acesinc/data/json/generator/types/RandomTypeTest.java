/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.acesinc.data.json.generator.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class RandomTypeTest {
	
	private TypeHandler instance;
	
	@Before
	public void setUp() {
		instance = new RandomType();
	}

	@Test
	public void testGetName() {
		assertEquals(RandomType.TYPE_NAME, instance.getName());
	}
	
	@Test
	public void testSingleValueList() {
		instance.setLaunchArguments(new String[] {"\"Highlander\""});
		assertEquals("Highlander", instance.getNextRandomValue());
	}
	
	@Test
	public void testMultiValueList() {
		String[] values = {"\"Michaelangelo\"", "\"Donatello\"", "\"Rafael\"", "\"Leonardo\""};
		
		instance.setLaunchArguments(values);
		
		Set<String> set = new HashSet<String> ();
		
		for (String s: values) {
			set.add(StringUtils.remove(s, '"'));
		}
		
		for (int idx = 0; idx < 10; idx++) {
			assertTrue(set.contains(instance.getNextRandomValue()));
		}
	}
	
}
