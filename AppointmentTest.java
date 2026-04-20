import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appt = new Appointment("001", futureDate, "Doctor visit");

        assertEquals("001", appt.getAppointmentID());
        assertEquals(futureDate, appt.getAppointmentDate());
        assertEquals("Doctor visit", appt.getDescription());
    }

    @Test
    public void testInvalidID() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Test");
        });

        assertEquals("Invalid appointment ID", ex.getMessage());
    }

    @Test
    public void testPastDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("001", pastDate, "Test");
        });

        assertEquals("Invalid appointment date", ex.getMessage());
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("001", futureDate, null);
        });

        assertEquals("Invalid description", ex.getMessage());
    }

    @Test
    public void testSetters() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appt = new Appointment("001", futureDate, "Doctor");

        Date newDate = new Date(System.currentTimeMillis() + 200000);
        appt.setAppointmentDate(newDate);
        assertEquals(newDate, appt.getAppointmentDate());

        appt.setDescription("Updated");
        assertEquals("Updated", appt.getDescription());
    }
}