/**
 * Returns the description of the deadline and shows the status of
 * whether the deadline task is completed
 *
 */
public class Deadline extends Task {

    protected String by;

    /**
     * @param description gives the index, status of the task, what the task is
     *                    and the date and time of the task if applicable
     * @param by the date that the deadline must be completed by
     *
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * @return description of deadline in the format required previously
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * @return description of deadline in the required format
     */
    public String getDescription() {
        return "[D]" + "[" + getStatusIcon() + "] " + super.getDescription() + " (by: " + by + ")";
    }

    /**
     * @return description of saving deadline in the required format
     */
    public String getFormat() {
        return "D | " + getStatusIcon2() + " | " + super.getDescription() + " | " + by;
    }
}