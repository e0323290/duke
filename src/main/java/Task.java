import java.lang.*;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✘"); //return tick or X symbols
    }

    public String getStatusIcon2() {
        return (isDone ? "1" : "0"); //return tick or X symbols
    }

    public void markAsDone() {
        isDone = true;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return "x";
    }
}