import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("001", "Homework", "Finish assignment");
        assertEquals("001", task.getTaskID());
        assertEquals("Homework", task.getName());
        assertEquals("Finish assignment", task.getDescription());
    }

    @Test
    public void testTaskIDTooLong() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task", "Desc");
        });
        assertEquals("Invalid task ID", ex.getMessage());
    }

    @Test
    public void testNameInvalid() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Task("001", null, "Desc");
        });
        assertEquals("Invalid name", ex.getMessage());
    }

    @Test
    public void testDescriptionInvalid() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Task("001", "Task", null);
        });
        assertEquals("Invalid description", ex.getMessage());
    }

    @Test
    public void testSettersValidation() {
        Task task = new Task("001", "Homework", "Finish assignment");

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertEquals("Invalid name", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertEquals("Invalid description", ex2.getMessage());
    }
}