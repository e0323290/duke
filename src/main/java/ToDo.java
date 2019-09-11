/**
 * Returns the description of the todo and shows the status of
 * whether the todo task is completed
 *
 */
public class ToDo extends Task {
    /**
     * @param description the task that is supposed to be done
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * @return description of todo in the format required previously
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * @return description of todo in the required format
     */
    public String getDescription() {
        return "[T]" + "[" + getStatusIcon() + "] " + super.getDescription();

    }

    /**
     * @return description of saving todo in the required format
     */
    public String getFormat() {
        return "T | " + getStatusIcon2() + " | " + super.getDescription();
    }
}
