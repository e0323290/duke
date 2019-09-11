/**
 * Returns the description of the event and shows the status of
 * whether the event task is completed
 *
 */

public class Event extends Task{
    protected String date;

    /**
     * @param description gives the index, status of the task, what the task is
     *                    and the date and time of the task if applicable
     * @param date the date of the event
     */
    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    /**
     * @return description of event in the format required previously
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at:" + date + ")";
    }

    /**
     * @return description of event in the required format
     */
    public String getDescription() {
        return "[E]" + "[" + getStatusIcon() + "] " + super.getDescription() + " (at: " + date  + ")";
    }

    /**
     * @return description of saving event in the required format
     */
    public String getFormat() {
        return "E | " + getStatusIcon2() + " | " + super.getDescription() + " | " + date;
    }
}
