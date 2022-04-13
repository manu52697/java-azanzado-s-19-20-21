package argparse;

import argparse.option.OptionInterface;

import java.util.List;
import java.util.Map;

public interface OptionsParserInterface {

    OptionsParserInterface addOption(OptionInterface option);
    OptionsParserInterface addOption(OptionInterface option, String ...alias);

    OptionsParserInterface addOption(String optionName);
    OptionsParserInterface addOption(String optionName, String helpText);
    OptionsParserInterface addOption(String optionName, String helpText, String ...alias);

    OptionInterface getOption(String optionName);

    OptionsParserInterface parse(String[] args);
    OptionsParserInterface parse(List<String> args);

    Map<String, List<String>> getValues();
    List<String> getValues(String optionName);

    default String getFirstValue(String optionName){
        return getValues(optionName).get(0);
    }

}
