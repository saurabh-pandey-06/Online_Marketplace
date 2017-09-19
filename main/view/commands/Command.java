package commands;

import authorize.Session;

/**
 * The Command Interface provides a common interface
 * for implementing all the commands in the system.
 * It declares a specific function (execute) whose
 * implementation is provided by each of the concrete
 * commands.
 *
 * @author Saurabh
 * @version 1.0
 */
public interface Command {

    public Session execute();
}
