package argparse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionsParserImpl extends OptionsParserBase{


    @Override
    public OptionsParserInterface parse(String[] args) {
        return parse(Arrays.asList(args));
    }

    @Override
    public OptionsParserInterface parse(List<String> args) {

        Set<String> keywords = this.namesMapping.keySet();

        List<String> detectedKeywords = args.stream()
                .filter(str -> str.startsWith("-"))
                .map(str -> str.replaceAll("-", ""))
                .map(str -> this.aliasMapping.getOrDefault(str, str))
                .filter(keywords::contains)
                .collect(Collectors.toList());

        List<Integer> indexes = args.stream()
                .filter(str -> str.startsWith("-"))
                .map(args::indexOf)
                .collect(Collectors.toList());

        if (detectedKeywords.size() != indexes.size()) {

            String unknownOption = indexes.stream()
                    .map(args::get)
                    .map(str -> str.replaceAll("-", ""))
                    .filter(str -> !keywords.contains(str))
                    .filter(str -> !this.aliasMapping.containsKey(str))
                    .findFirst().orElseThrow();

            throw new IllegalArgumentException("Unknown option: " + unknownOption);
        }

        if (!indexes.contains(0)) throw new IllegalArgumentException("Unknown option: " + args.get(0));

        for (int i = 0; i < args.size(); i++) {

            if (indexes.contains(i)) {
                String keyword = detectedKeywords.get(i);
                List<String> arguments = new ArrayList<>();
                i++;

                if (indexes.contains(i)) arguments.add("t");

                while (!indexes.contains(i)) {
                    if (i < args.size()){
                        arguments.add(args.get(i));
                        i++;
                    }else {
                        break;
                    }
                }
                this.valuesMapping.put(keyword, arguments);
                i--;
            }
        }

        return this;
    }
}
