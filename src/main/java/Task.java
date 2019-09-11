import java.lang.*;

/**
 * Returns the description of the tasks (deadline, event, todo) and gives
 * the status of the whether the task is completed or not.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * @param description describes the task that is called
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * @return a tick or cross symbol
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * @return a tick or cross symbol
     */
    public String getStatusIcon2() {
        return (isDone ? "1" : "0"); //return tick or X symbols
    }

    public void markAsDone() {
        isDone = true;
    }

    /**
     * @return description of specific tasks
     */
    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return "x";
    }
}