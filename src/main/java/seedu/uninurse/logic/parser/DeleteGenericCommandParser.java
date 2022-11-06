package seedu.uninurse.logic.parser;

import static seedu.uninurse.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIXES_OPTION_ALL;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_OPTION_CONDITION_INDEX;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_OPTION_MEDICATION_INDEX;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_OPTION_PATIENT_INDEX;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_OPTION_REMARK_INDEX;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_OPTION_TAG_INDEX;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_OPTION_TASK_INDEX;

import seedu.uninurse.logic.commands.DeleteGenericCommand;
import seedu.uninurse.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates either a new DeleteGenericCommand
 * object based on option values.
 */
public class DeleteGenericCommandParser implements Parser<DeleteGenericCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteGenericCommand
     * and returns an DeleteGenericCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteGenericCommand parse(String args) throws ParseException {
        requireAllNonNull(args);

        ArgumentMultimap options = ParserUtil.parseOptions(args, PREFIXES_OPTION_ALL);
        args = ParserUtil.eraseOptions(args, PREFIXES_OPTION_ALL);

        if (ParserUtil.optionsOnlyContains(options,
                PREFIX_OPTION_PATIENT_INDEX)) {
            return new DeletePatientCommandParser().parse(
                    options.getValue(PREFIX_OPTION_PATIENT_INDEX).get() + " " + args);
        }

        if (ParserUtil.optionsOnlyContains(options,
                PREFIX_OPTION_PATIENT_INDEX, PREFIX_OPTION_TASK_INDEX)) {
            return new DeleteTaskCommandParser().parse(
                    options.getValue(PREFIX_OPTION_PATIENT_INDEX).get() + " "
                            + options.getValue(PREFIX_OPTION_TASK_INDEX).get() + " " + args);
        }

        if (ParserUtil.optionsOnlyContains(options,
                PREFIX_OPTION_PATIENT_INDEX, PREFIX_OPTION_TAG_INDEX)) {
            return new DeleteTagCommandParser().parse(
                    options.getValue(PREFIX_OPTION_PATIENT_INDEX).get() + " "
                            + options.getValue(PREFIX_OPTION_TAG_INDEX).get() + " " + args);
        }

        if (ParserUtil.optionsOnlyContains(options,
                PREFIX_OPTION_PATIENT_INDEX, PREFIX_OPTION_CONDITION_INDEX)) {
            return new DeleteConditionCommandParser().parse(
                    options.getValue(PREFIX_OPTION_PATIENT_INDEX).get() + " "
                            + options.getValue(PREFIX_OPTION_CONDITION_INDEX).get() + " " + args);
        }

        if (ParserUtil.optionsOnlyContains(options,
                PREFIX_OPTION_PATIENT_INDEX, PREFIX_OPTION_MEDICATION_INDEX)) {
            return new DeleteMedicationCommandParser().parse(
                    options.getValue(PREFIX_OPTION_PATIENT_INDEX).get() + " "
                            + options.getValue(PREFIX_OPTION_MEDICATION_INDEX).get() + " " + args);
        }

        if (ParserUtil.optionsOnlyContains(options,
                PREFIX_OPTION_PATIENT_INDEX, PREFIX_OPTION_REMARK_INDEX)) {
            return new DeleteRemarkCommandParser().parse(
                    options.getValue(PREFIX_OPTION_PATIENT_INDEX).get() + " "
                            + options.getValue(PREFIX_OPTION_REMARK_INDEX).get() + " " + args);
        }

        throw new ParseException(ParserUtil.MESSAGE_INVALID_OPTIONS);
    }
}
