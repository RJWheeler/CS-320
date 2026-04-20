import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    public void setup() {
        service = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("001", "Homework", "Finish assignment");
        service.addTask(task);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task);
        });
        assertEquals("Task ID already exists", ex.getMessage());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("001", "Homework", "Finish assignment");
        service.addTask(task);

        service.deleteTask("001");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("001");
        });
        assertEquals("Task ID not found", ex.getMessage());
    }

    @Test
    public void testUpdateName() {
        Task task = new Task("001", "Homework", "Finish assignment");
        service.addTask(task);

        service.updateName("001", "Updated");
        assertEquals("Updated", task.getName());
    }

    @Test
    public void testUpdateDescription() {
        Task task = new Task("001", "Homework", "Finish assignment");
        service.addTask(task);

        service.updateDescription("001", "New description");
        assertEquals("New description", task.getDescription());
    }

    @Test
    public void testUpdateInvalidID() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("999", "Test");
        });
        assertEquals("Task ID not found", ex.getMessage());
    }
}