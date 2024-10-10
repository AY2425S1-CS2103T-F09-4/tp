package tuteez.logic.parser;

import static tuteez.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import tuteez.commons.core.index.Index;
import tuteez.logic.commands.DeleteCommand;
import tuteez.logic.parser.exceptions.ParseException;
import tuteez.model.person.Name;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        try {
            if (args.trim().matches("\\d+")) {
                Index index = ParserUtil.parseIndex(args);
                return new DeleteCommand(index);
            } else {
                Name name = ParserUtil.parseName(args);
                return new DeleteCommand(name);
            }
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }
}
