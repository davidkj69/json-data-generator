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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrewserff
 */
public class DateTypeTest {

    private String minDate = "2015/05/01T00:00:00";
    private String maxDate = "2015/05/05T23:59:59";

    private Date min;
    private Date max;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");
    private SimpleDateFormat sdfMs = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss.SSS");

    public DateTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            min = sdf.parse(minDate);
            max = sdf.parse(maxDate);
        } catch (ParseException pe) {

        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNextRandomValue method, of class DateType.
     */
    @Test
    public void testGetNextRandomValueWithMin() {
        System.out.println("getNextRandomValue");
        String[] launchArguments = {minDate};
        DateType instance = new DateType();
        

        //test it 1000 times
        for (int i = 0; i < 1000; i++) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.MILLISECOND, 0);
            Date now = cal.getTime();
            
            instance.setLaunchArguments(launchArguments);
            
            Date result = instance.getNextRandomValue();
            assertTrue("Testing that " + result + " is after " + min, result.after(min) || result.equals(min));
            assertTrue("Testing that " + result + " is before " + now, result.before(now) || result.equals(now));
        }
    }

    @Test
    public void testGetNextRandomValueWithMinAndMax() {
        System.out.println("getNextRandomValue");
        String[] launchArguments = {minDate, maxDate};
        DateType instance = new DateType();
        

        //test it 1000 times
        for (int i = 0; i < 1000; i++) {
            instance.setLaunchArguments(launchArguments);
            Date result = instance.getNextRandomValue();
            assertTrue("Testing that " + result + " is after " + min, result.after(min) || result.equals(min));
            assertTrue("Testing that " + result + " is before " + max, result.before(max) || result.equals(max));
        }
    }

    @Test
    public void testGetNextRandomValueWithTimeOffset() {
        System.out.println("getNextRandomValue");
        String[] launchArguments = {"'-5_m'", "'-4_m'"};
        DateType instance = new DateType();
        

        //test it 1000 times
        for (int i = 0; i < 1000; i++) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.MILLISECOND, 0);
            Date now = cal.getTime();
            Date min = new Date(now.getTime() - (5 * 60 * 1000));
            Date max = new Date(now.getTime() - (4 * 60 * 1000));

            instance.setLaunchArguments(launchArguments);
            
            Date result = instance.getNextRandomValue();
            assertTrue("Testing that " + sdfMs.format(result) + " is after " + sdfMs.format(min), result.after(min) || result.equals(min));
            assertTrue("Testing that " + sdfMs.format(result) + " is before " + sdfMs.format(max), result.before(max) || result.equals(max));
        }
    }

    /**
     * Test of getName method, of class DateType.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        DateType instance = new DateType();
        String expResult = "date";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

}
