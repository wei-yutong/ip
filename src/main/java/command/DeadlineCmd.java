package command;

import classes.DuckieException;
import classes.Storage;
import classes.TaskList;
import classes.Ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DeadlineCmd extends Command {
    private String cmd;

    /**
     * Constructor method.
     * @param cmd User input command.
     */
    public DeadlineCmd(String cmd){
        this.cmd = cmd;
    }

    /**
     * Execute method.
     * @param lst a TaskList object containing Task Objects.
     * @param ui a Ui object.
     * @param storage a storage object.
     * @throws DuckieException if user enters commands besides accepted ones.
     * @return
     */
    @Override
    public String execute(TaskList lst, Ui ui, Storage storage) throws DuckieException {

        if (!cmd.contains("/by")) {
            throw new DuckieException("oops! please specify deadline using '/by'");
        }

        String[] strD = cmd.trim().split("/by", 2);
        String inputDate = strD[1].trim();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HHmm", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse(inputDate);
        } catch (Exception e) {
            throw new DuckieException("please enter date in the format dd-mm-yyyy HHmm");
        }
        Deadline tempD = new Deadline(strD[0], date);

        lst.addTask(tempD);

        if (lst.getListSize() == 0) {
            return "there are no tasks in your list!";
        } else if (lst.getListSize() == 1) {
            return "ok! i've added this task:" + tempD.toString()
                    + "\n" + "you have " + lst.getListSize() + " task in your list! keep working!"
                    + "\n" + ui.customLine();
        } else {
            return "ok! i've added this task:" + tempD.toString()
                    + "\n" + "you have " + lst.getListSize() + " tasks in your list! keep working!"
                    + "\n" + ui.customLine();
        }
    }

    /**
     * Method to determine whether to exit program.
     * @return Returns false, program continues.
     */
    @Override
    public boolean isEnd() {
        return false;
    }
}
