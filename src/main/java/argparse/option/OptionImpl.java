package argparse.option;

import java.nio.ByteBuffer;

public class OptionImpl implements OptionInterface{

    private final String optionName;
    private final String optionHelp;

    public OptionImpl(String optionName) {
        this.optionName = optionName;
        this.optionHelp = "";
    }

    public OptionImpl(String optionName, String optionHelp) {
        this.optionName = optionName;
        this.optionHelp = optionHelp;
    }

    @Override
    public String getName() {
        return this.optionName;
    }

    @Override
    public String getHelp() {
        return this.optionHelp;
    }
}
