package tuteez.logic.parser;

import static java.util.Objects.requireNonNull;

import tuteez.commons.exceptions.IllegalValueException;
import static tuteez.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static tuteez.logic.parser.CliSyntax.PREFIX_REMARK;

import tuteez.commons.core.index.Index;
import tuteez.logic.commands.RemarkCommand;
import tuteez.logic.parser.exceptions.ParseException;
import tuteez.model.person.Remark;

public class RemarkCommandParser implements Parser<RemarkCommand> {

    @Override
    public RemarkCommand parse(String userInput) throws ParseException {
       requireNonNull(userInput);
       ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_REMARK);

       Index index;
       try {
           index = ParserUtil.parseIndex(argumentMultimap.getPreamble());
       } catch (IllegalValueException ive) {
           throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE), ive);
       }

       String remark = argumentMultimap.getValue(PREFIX_REMARK).orElse("");

       return new RemarkCommand(index, new Remark(remark));
    }
}
