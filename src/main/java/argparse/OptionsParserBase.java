package argparse;

import argparse.option.OptionImpl;
import argparse.option.OptionInterface;

import java.util.*;

public abstract class OptionsParserBase implements OptionsParserInterface{


    /**
     * Maps the name of an option to the option instance
     */
    Map<String, OptionInterface> namesMapping = new HashMap<>();


    /**
     * Maps an alias to an option name
     */
    Map<String, String> aliasMapping = new HashMap<>();


    /**
     * Maps an option name against it´s parsed value, empty string {@code ""} if the option wasn't present in the input,
     * and {@code t} if the option name/alias was followed by other name/alias
     */
    Map<String, List<String>> valuesMapping = new HashMap<>();

    public OptionsParserBase() {
    }

    private void addAlias(String name, String ...aliases){
        Arrays.asList(aliases).forEach(
                alias -> this.aliasMapping.put(alias, name)
        );
    }

    // Impl methods

    @Override
    public OptionsParserInterface addOption(OptionInterface option) {
        this.namesMapping.put(option.getName(), option);
        return this;
    }

    @Override
    public OptionsParserInterface addOption(OptionInterface option, String... alias) {
        addOption(option);

        addAlias(option.getName(), alias);

        return this;
    }

    @Override
    public OptionsParserInterface addOption(String optionName) {
        return addOption(optionName, "");

    }

    @Override
    public OptionsParserInterface addOption(String optionName, String helpText) {
        OptionInterface option = new OptionImpl(optionName, helpText);
        addOption(option);

        return this;
    }

    @Override
    public OptionsParserInterface addOption(String optionName, String helpText, String ...alias) {
        addAlias(optionName, alias);

        return addOption(optionName, helpText);
    }

    @Override
    public OptionInterface getOption(String optionName) {
        return this.namesMapping.getOrDefault(optionName, null);
    }

    @Override
    public abstract OptionsParserInterface parse(String[] args);

    @Override
    public Map<String, List<String>> getValues() {
        return this.valuesMapping;
    }

    @Override
    public List<String> getValues(String optionName) {
        return this.valuesMapping.get(optionName);
    }
}
