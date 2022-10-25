package seedu.uninurse.logic.parser;

import static seedu.uninurse.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.uninurse.logic.parser.CliSyntax.PREFIX_CONDITION;
import static seedu.uninurse.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.uninurse.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.uninurse.testutil.Assert.assertThrows;
import static seedu.uninurse.testutil.TypicalConditions.CONDITION_DIABETES;
import static seedu.uninurse.testutil.TypicalConditions.TYPICAL_CONDITION_DIABETES;
import static seedu.uninurse.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.uninurse.logic.commands.AddConditionCommand;

/**
 * Contains unit tests for {@code AddConditionCommandParser}.
 */
public class AddConditionCommandParserTest {

    private final AddConditionCommandParser parser = new AddConditionCommandParser();

    @Test
    public void parse_nullArgs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> parser.parse(null));
    }

    @Test
    public void parse_validArgs_success() {
        String args = INDEX_FIRST_PERSON.getOneBased() + " " + PREFIX_CONDITION + TYPICAL_CONDITION_DIABETES;
        assertParseSuccess(parser, args, new AddConditionCommand(INDEX_FIRST_PERSON, CONDITION_DIABETES));
        assertParseSuccess(parser, " " + args + " ",
                new AddConditionCommand(INDEX_FIRST_PERSON, CONDITION_DIABETES));
    }

    @Test
    public void parse_invalidPatientIndex_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddConditionCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "a " + PREFIX_CONDITION + TYPICAL_CONDITION_DIABETES, expectedMessage);
        assertParseFailure(parser, "0 " + PREFIX_CONDITION + TYPICAL_CONDITION_DIABETES, expectedMessage);
    }

    @Test
    public void parse_missingPatientIndex_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddConditionCommand.MESSAGE_USAGE);
        assertParseFailure(parser, PREFIX_CONDITION + TYPICAL_CONDITION_DIABETES, expectedMessage);
    }

    @Test
    public void parse_emptyCondition_failure() {
        String args = "1 " + PREFIX_CONDITION;
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddConditionCommand.MESSAGE_USAGE);
        assertParseFailure(parser, args, expectedMessage);
    }

    @Test
    public void parse_missingConditionPrefix_failure() {
        String expectedMessage = AddConditionCommandParser.MESSAGE_MISSING_CONDITION;
        assertParseFailure(parser, "1" , expectedMessage);
    }
}
