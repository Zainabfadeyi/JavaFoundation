package test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import src.FireDrillFour.AssignmentThree;

import java.util.*;

public class AssignmentThreeTest {

    Map<String, List<String>> zones;

    @Before
    public void setUp() {
        zones = new HashMap<>();
        zones.put("North Central", Arrays.asList("Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"));
        zones.put("North East",    Arrays.asList("Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"));
        zones.put("North West",    Arrays.asList("Kaduna", "Katsina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"));
        zones.put("South East",    Arrays.asList("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"));
        zones.put("South-South",   Arrays.asList("Akwa-Ibom", "Bayelsa", "Cross-River", "Delta", "Edo", "Rivers"));
        zones.put("South West",    Arrays.asList("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"));
    }



    @Test
    public void testFindZone_Benue() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "Benue"));
    }

    @Test
    public void testFindZone_FCT() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "FCT"));
    }

    @Test
    public void testFindZone_Kogi() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "Kogi"));
    }

    @Test
    public void testFindZone_Kwara() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "Kwara"));
    }

    @Test
    public void testFindZone_Nasarawa() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "Nasarawa"));
    }

    @Test
    public void testFindZone_Niger() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "Niger"));
    }

    @Test
    public void testFindZone_Plateau() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "Plateau"));
    }



    @Test
    public void testFindZone_Adamawa() {
        assertEquals("North East", AssignmentThree.findZone(zones, "Adamawa"));
    }

    @Test
    public void testFindZone_Bauchi() {
        assertEquals("North East", AssignmentThree.findZone(zones, "Bauchi"));
    }

    @Test
    public void testFindZone_Borno() {
        assertEquals("North East", AssignmentThree.findZone(zones, "Borno"));
    }

    @Test
    public void testFindZone_Gombe() {
        assertEquals("North East", AssignmentThree.findZone(zones, "Gombe"));
    }

    @Test
    public void testFindZone_Taraba() {
        assertEquals("North East", AssignmentThree.findZone(zones, "Taraba"));
    }

    @Test
    public void testFindZone_Yobe() {
        assertEquals("North East", AssignmentThree.findZone(zones, "Yobe"));
    }



    @Test
    public void testFindZone_Kaduna() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Kaduna"));
    }

    @Test
    public void testFindZone_Katsina() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Katsina"));
    }

    @Test
    public void testFindZone_Kano() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Kano"));
    }

    @Test
    public void testFindZone_Kebbi() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Kebbi"));
    }

    @Test
    public void testFindZone_Sokoto() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Sokoto"));
    }

    @Test
    public void testFindZone_Jigawa() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Jigawa"));
    }

    @Test
    public void testFindZone_Zamfara() {
        assertEquals("North West", AssignmentThree.findZone(zones, "Zamfara"));
    }



    @Test
    public void testFindZone_Abia() {
        assertEquals("South East", AssignmentThree.findZone(zones, "Abia"));
    }

    @Test
    public void testFindZone_Anambra() {
        assertEquals("South East", AssignmentThree.findZone(zones, "Anambra"));
    }

    @Test
    public void testFindZone_Ebonyi() {
        assertEquals("South East", AssignmentThree.findZone(zones, "Ebonyi"));
    }

    @Test
    public void testFindZone_Enugu() {
        assertEquals("South East", AssignmentThree.findZone(zones, "Enugu"));
    }

    @Test
    public void testFindZone_Imo() {
        assertEquals("South East", AssignmentThree.findZone(zones, "Imo"));
    }



    @Test
    public void testFindZone_AkwaIbom() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "Akwa-Ibom"));
    }

    @Test
    public void testFindZone_Bayelsa() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "Bayelsa"));
    }

    @Test
    public void testFindZone_CrossRiver() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "Cross-River"));
    }

    @Test
    public void testFindZone_Delta() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "Delta"));
    }

    @Test
    public void testFindZone_Edo() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "Edo"));
    }

    @Test
    public void testFindZone_Rivers() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "Rivers"));
    }



    @Test
    public void testFindZone_Ekiti() {
        assertEquals("South West", AssignmentThree.findZone(zones, "Ekiti"));
    }

    @Test
    public void testFindZone_Lagos() {
        assertEquals("South West", AssignmentThree.findZone(zones, "Lagos"));
    }

    @Test
    public void testFindZone_Osun() {
        assertEquals("South West", AssignmentThree.findZone(zones, "Osun"));
    }

    @Test
    public void testFindZone_Ondo() {
        assertEquals("South West", AssignmentThree.findZone(zones, "Ondo"));
    }

    @Test
    public void testFindZone_Ogun() {
        assertEquals("South West", AssignmentThree.findZone(zones, "Ogun"));
    }

    @Test
    public void testFindZone_Oyo() {
        assertEquals("South West", AssignmentThree.findZone(zones, "Oyo"));
    }



    @Test
    public void testFindZone_LowercaseInput() {
        assertEquals("South West", AssignmentThree.findZone(zones, "lagos"));
    }

    @Test
    public void testFindZone_UppercaseInput() {
        assertEquals("South West", AssignmentThree.findZone(zones, "LAGOS"));
    }

    @Test
    public void testFindZone_MixedCaseInput() {
        assertEquals("South West", AssignmentThree.findZone(zones, "LaGoS"));
    }

    @Test
    public void testFindZone_LowercaseNorthCentral() {
        assertEquals("North Central", AssignmentThree.findZone(zones, "benue"));
    }

    @Test
    public void testFindZone_LowercaseSouthSouth() {
        assertEquals("South-South", AssignmentThree.findZone(zones, "rivers"));
    }



    @Test
    public void testFindZone_InvalidState() {
        assertNull(AssignmentThree.findZone(zones, "London"));
    }

    @Test
    public void testFindZone_EmptyString() {
        assertNull(AssignmentThree.findZone(zones, ""));
    }

    @Test
    public void testFindZone_RandomString() {
        assertNull(AssignmentThree.findZone(zones, "Abcdefgh"));
    }

    @Test
    public void testFindZone_NumberInput() {
        assertNull(AssignmentThree.findZone(zones, "12345"));
    }

    @Test
    public void testFindZone_WhitespaceInput() {
        assertNull(AssignmentThree.findZone(zones, "   "));
    }
}