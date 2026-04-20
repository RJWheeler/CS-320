import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("123", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIDTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main Street");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "ThisIsAVeryLongLastName", "1234567890", "123 Main Street");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    public void testPhoneInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main Street");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "123 Main Street, Apartment 123, SomeCity");
        });
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    public void testSettersValidation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertEquals("Invalid first name", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ThisIsAVeryLongLastName"));
        assertEquals("Invalid last name", ex2.getMessage());

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abc"));
        assertEquals("Invalid phone number", ex3.getMessage());

        Exception ex4 = assertThrows(IllegalArgumentException.class, () -> contact.setAddress("123 Main Street, Apartment 123, SomeCity"));
        assertEquals("Invalid address", ex4.getMessage());
    }
}