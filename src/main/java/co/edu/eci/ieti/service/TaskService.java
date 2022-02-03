package co.edu.eci.ieti.service;

import java.util.List;

import co.edu.eci.ieti.data.Task;
import co.edu.eci.ieti.dto.TaskDto;
import co.edu.eci.ieti.exceptions.TaskException;

public interface TaskService {
    Task create(Task task) throws TaskException;

    Task findById(String id) throws TaskException;

    List<Task> getAll();

    boolean deleteById(String id) throws TaskException;

    Task update(TaskDto taskDto, String id) throws TaskException;
}
