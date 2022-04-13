package argparse.option;

import argparse.option.OptionImpl;
import argparse.option.OptionInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOptionImpl {

    @Test
    void testGetName() {

        String testName = "testname";
        OptionInterface option1 = new OptionImpl(testName);
        OptionImpl option2 = new OptionImpl(testName);

        assertAll(
                () -> assertEquals(testName, option1.getName()),
                () -> assertEquals(testName, option2.getName())
        );
    }

    @Test
    void testGetHelp() {
        String testName = "testname";
        String testHelpText = "Lorem Ipsum...";

        OptionInterface option1 = new OptionImpl(testName, testHelpText);
        OptionImpl option2 = new OptionImpl(testName, testHelpText);

        assertAll(
                () -> assertEquals(testHelpText, option1.getHelp()),
                () -> assertEquals(testHelpText, option2.getHelp())
        );

    }
}
