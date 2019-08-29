public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String getDescription() {
        return "[T]" + "[" + getStatusIcon() + "] " + super.getDescription();

    }

}