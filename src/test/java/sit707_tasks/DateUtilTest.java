package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateUtilTest {
	
	@Test
    public void testStudentIdentity() {
        String studentId = "s224143611";
        org.junit.Assert.assertNotNull("s224143611", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Akshar Antala";
        org.junit.Assert.assertNotNull("Akshar Antala", studentName);
    }
      

    @Test
    public void testValidDate_IncrementDay() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        assertEquals(2, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test
    public void testValidDate_DecrementDay() {
        DateUtil date = new DateUtil(2, 1, 2024);
        date.decrement();
        assertEquals(1, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDay_IncrementDay() {
        DateUtil date = new DateUtil(32, 1, 2024);
        date.increment();
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDay_DecrementDay() {
        DateUtil date = new DateUtil(0, 1, 2024);
        date.decrement();
    }

    @Test
    public void testBoundaryValue_IncrementDay() {
        DateUtil date = new DateUtil(28, 1, 2024);
        date.increment();
        assertEquals(29, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test
    public void testBoundaryValue_DecrementDay() {
        DateUtil date = new DateUtil(29, 1, 2024);
        date.decrement();
        assertEquals(28, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2024, date.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidMonth() {
        new DateUtil(1, 13, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidYear() {
        new DateUtil(1, 1, 2025);
    }
}