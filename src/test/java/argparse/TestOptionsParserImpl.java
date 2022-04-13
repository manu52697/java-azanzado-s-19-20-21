package argparse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestOptionsParserImpl {

    @Test
    void testConstructor() {
        OptionsParserInterface parser1 = new OptionsParserImpl();
        OptionsParserImpl parser2 = new OptionsParserImpl();

        assertAll(
                () -> assertTrue(parser1 instanceof OptionsParserInterface),
                () -> assertTrue(parser1 instanceof OptionsParserImpl),
                () -> assertTrue(parser2 instanceof OptionsParserInterface)
        );
    }

    @Test
    void testAddOption() {
        String testName1 = "testname1";
        String testName2 = "testname2";

        String testHelpText2 = "Lorem Ipsum ...";

        OptionsParserInterface testParser = new OptionsParserImpl()
                .addOption(testName1)
                .addOption(testName2, testHelpText2);

        assertAll(
                () -> assertEquals(testParser, testParser.addOption("aaa")),
                () -> assertEquals(testName1, testParser.getOption(testName1).getName()),
                () -> assertEquals(testHelpText2, testParser.getOption(testName2).getHelp())
        );
    }

    @Test
    void testParse() {

        String testName = "help";
        String testAlias = "h";

        String[] testParseable = "--help test".split(" ");

        OptionsParserInterface parser = new OptionsParserImpl()
                .addOption(testName, "", testAlias)
                .parse(testParseable);

        assertEquals("test", parser.getFirstValue(testName));

    }
}
