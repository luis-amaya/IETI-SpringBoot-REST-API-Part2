package co.edu.eci.ieti.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import co.edu.eci.ieti.data.Task;
import co.edu.eci.ieti.dto.TaskDto;
import co.edu.eci.ieti.exceptions.TaskException;
import co.edu.eci.ieti.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    HashMap<String, Task> tasksMap = new HashMap<>();

    private static final AtomicInteger genId = new AtomicInteger(0);
    private static final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public Task create(Task task) throws TaskException {
        for (Task savedTask : tasksMap.values()) {
            if (savedTask.equals(task)) {
                throw new TaskException(TaskException.TASK_CREATE_EXCEPTION);
            }
        }

        task.setId(String.valueOf(genId.incrementAndGet()));
        task.setCreated(dateToString());
        tasksMap.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(String id) throws TaskException {
        Task task = tasksMap.get(id);
        if (task == null)
            throw new TaskException(TaskException.TASK_DOES_NOT_EXIST);
        return task;
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasksMap.values());
    }

    @Override
    public boolean deleteById(String id) {
        boolean bol = false;
        if (tasksMap.remove(id) != null) {
            bol = true;
        }
        return bol;
    }

    @Override
    public Task update(TaskDto taskDto, String id) throws TaskException {
        Task updatedTask = new Task();
        if (tasksMap.containsKey(id)) {
            Task oldTask = tasksMap.get(id);
            updatedTask.setId(id);
            updatedTask.setAssignedTo(taskDto.getAssignedTo());
            updatedTask.setCreated(oldTask.getCreated());
            updatedTask.setDescription(taskDto.getDescription());
            updatedTask.setDueDate(taskDto.getDueDate());
            updatedTask.setName(taskDto.getName());
            updatedTask.setStatus(taskDto.getStatus());
        } else {
            throw new TaskException(TaskException.TASK_WRONG_STATUS);
        }

        return updatedTask;
    }

    private String dateToString() {
        return date.format(LocalDateTime.now()).toString();
    }

}
