package com.pfariasmunoz.commandsreferencecards;

/**
 * Created by Pablo Farias on 24-09-16.
 */

public class Command {

    /** Determines if the constructor has a title **/
    private static final String NULL_TITLE = null;

    /** Command for each function **/
    private String mCommand;

    /** Functions of the command **/
    private String mFunction;

    /** section title if it is its first element **/
    private String mSectionTitle = NULL_TITLE;

    /**
     * Create a new Command object
     *
     * @param command is the command the user wants to remember (such as "pwd" for linux)
     * @param function is what the command is for.
     */
    public Command(String command, String function) {
        mCommand = command;
        mFunction = function;
    }

    /**
     * Create a new Command object
     *
     * @param sectionTitle is the title in each section of the list of word and commands.
     * @param command is the command the user wants to remember (such as "pwd" for linux)
     * @param function is what the command is for.
     */
    public Command(String command, String function, String sectionTitle) {
        mCommand = command;
        mFunction = function;
        mSectionTitle = sectionTitle;
    }

    /**
     *
     * @return the command for each section of the list view.
     */
    public String getCommand() {
        return mCommand;
    }

    /**
     *
     * @return the function of the command.
     */
    public String getFunction() {
        return mFunction;
    }

    /**
     *
     * @return whether or not there is title (if the command is the first element of the list)
     */
    public boolean hasSectionTitle() {
        return mSectionTitle != NULL_TITLE;
    }

    public String getSectionTitle() {
        return mSectionTitle;
    }
}
