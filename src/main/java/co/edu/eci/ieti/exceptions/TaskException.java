package co.edu.eci.ieti.exceptions;

public class TaskException extends Exception {

    public static final String TASK_CREATE_EXCEPTION = "Task has already been created.";
    public static final String TASK_DOES_NOT_EXIST = "Task doesn't exist.";
    public static final String TASK_WRONG_STATUS = "The status isn't valid.";

    public TaskException(String message) {
        super(message);
    }
}
