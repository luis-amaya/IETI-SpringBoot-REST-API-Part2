package co.edu.eci.ieti.dto;

public class TaskDto {

    private String name;
    private String description;
    private String status;
    private String assignedTo;
    private String dueDate;

    public TaskDto() {

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

    public void setStatus(String status) {
        this.status = status;
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

    public String toString() {
        return "{ Name: " + name + ", Description: " + description + ", Status: " + status + ", AssignedTo: "
                + assignedTo + ", DueDate: " + dueDate + "}";
    }
}
