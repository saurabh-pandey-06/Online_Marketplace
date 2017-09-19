package commands;

import authorize.Session;

/**
 * The UserRequest class acts as an invoker. It helps in
 * invoking the commands issued by a particular user.
 *
 * @author Saurabh
 * @version 1.0
 */

public class UserRequest {

    Command command;

    public UserRequest(Command command){
        this.command = command;
    }

    /**
     * Executing the user command through the command interface.
     *
     * @return boolean
     */
    public Session executeCommand(){

        return command.execute();
    }
}
