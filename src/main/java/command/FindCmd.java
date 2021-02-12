package command;

import classes.*;

public class FindCmd extends Command {
    private String cmd;

    public FindCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String execute(TaskList lst, Ui ui, Storage storage) throws DuckieException {
        String[] cmdArr = cmd.trim().split(" ");
        String output = "";
        int taskSize = lst.getListSize();
        for (int i = 1; i < taskSize + 1; i++) {
            if (lst.getTask(i - 1).getDescription().contains(cmdArr[1])) {
                output = output + "\n" + String.format("%s. %s", i, lst.getTask(i - 1).toString());

            }
        }
        return output + "\n" + ui.customLine();
    }

    @Override
    public boolean isEnd() {
        return false;
    }
}
