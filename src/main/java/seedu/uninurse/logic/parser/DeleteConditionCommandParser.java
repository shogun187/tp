package seedu.uninurse.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.uninurse.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;

import seedu.uninurse.commons.core.index.Index;
import seedu.uninurse.logic.commands.DeleteConditionCommand;
import seedu.uninurse.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteConditionCommand object.
 */
public class DeleteConditionCommandParser implements Parser<DeleteConditionCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteConditionCommand
     * and returns a DeleteConditionCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteConditionCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        try {
            List<Index> indices = ParserUtil.parseTwoIndex(argMultimap.getPreamble());

            return new DeleteConditionCommand(indices.get(0), indices.get(1));
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteConditionCommand.MESSAGE_USAGE), pe);
        }
    }
}
