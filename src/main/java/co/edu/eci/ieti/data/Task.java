package co.edu.eci.ieti.data;

import co.edu.eci.ieti.dto.TaskDto;
import co.edu.eci.ieti.exceptions.TaskException;

public class Task {
    private String id;
    private String name;
    private String description;
    private String status;
    private String assignedTo;
    private String dueDate;
    private String created;

    public Task() {

    }

    public Task(TaskDto taskDto) throws TaskException {
        name = taskDto.getName();
        description = taskDto.getDescription();
        assignedTo = taskDto.getAssignedTo();
        dueDate = taskDto.getDueDate();
        try {
            TaskStatus.valueOf(taskDto.getStatus());
            status = taskDto.getStatus();
        } catch (Exception e) {
            throw new TaskException(TaskException.TASK_WRONG_STATUS);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws TaskException {
        try {
            TaskStatus.valueOf(status);
            this.status = status;
        } catch (Exception e) {
            throw new TaskException(TaskException.TASK_WRONG_STATUS);
        }
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
