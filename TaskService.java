import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<String, Task> tasks;

    public TaskService() {
        tasks = new HashMap<>();
    }

    // Add task
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskID(), task);
    }

    // Delete task
    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskID);
    }

    // Update name
    public void updateName(String taskID, String name) {
        getTask(taskID).setName(name);
    }

    // Update description
    public void updateDescription(String taskID, String description) {
        getTask(taskID).setDescription(description);
    }

    // Helper method
    private Task getTask(String taskID) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return task;
    }
}