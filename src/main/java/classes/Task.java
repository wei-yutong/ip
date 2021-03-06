package classes;

/**
 * Task encapsulates a task with String description and boolean isDone.
 * It supports getting the status of the task and marking it as done.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Construct a Task object with a given description and isDone set to false.
     * @param description The description of this task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Get the current status of the task.
     * @return Returns a cross if done, otherwise whitespace.
     */
    public String getStatus() {
        return (isDone ? "\u2718" : " ");
    }

    /**
     * Method to get the isDone status of a Task as a String
     * @return Returns String "done" if isDone is true, "not done" otherwise.
     */
    public String getIsDone() {
        if (this.isDone) {
            return "done";
        } else {
            return "not done";
        }
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the status of the task to true.
     */
    public void markDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description;
    }
}
