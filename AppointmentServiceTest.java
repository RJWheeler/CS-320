import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    public void setup() {
        service = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appt = new Appointment("001", futureDate, "Meeting");

        service.addAppointment(appt);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appt);
        });

        assertEquals("Appointment ID already exists", ex.getMessage());
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appt = new Appointment("001", futureDate, "Meeting");

        service.addAppointment(appt);
        service.deleteAppointment("001");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("001");
        });

        assertEquals("Appointment ID not found", ex.getMessage());
    }
}