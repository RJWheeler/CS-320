import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        // Adding the same ID again should throw exception
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
        assertEquals("Contact ID already exists", ex.getMessage());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("001");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.deleteContact("001"));
        assertEquals("Contact ID not found", ex.getMessage());
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("001", "Jane");
        assertEquals("Jane", contact.getFirstName());
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "X"));
        assertEquals("Contact ID not found", ex.getMessage());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("001", "Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("001", "0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("001", "456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}