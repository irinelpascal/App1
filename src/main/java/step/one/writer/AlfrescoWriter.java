package step.one.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static step.one.constants.ApplicationConstants.ALFRESCO;
import static step.one.constants.ApplicationConstants.FIZZ;
import static step.one.util.ApplicationUtil.checkIfNumberDivisibleBy_3_Or_5_Or_15_AndPopulateList;

public class AlfrescoWriter implements Writer {

    private static final Logger LOG = Logger.getLogger(AlfrescoWriter.class.getName());
    private WriterProcessor writerProcessor;

    public AlfrescoWriter(WriterProcessor writerProcessor) {
        this.writerProcessor = writerProcessor;
    }

    @Override
    public List<String> getMalformedStream() {
        //we get the original stream here so we can manipulate the data inside from it's current state
        List<Integer> originalStream = writerProcessor.getOriginalStream();
        List<String> strings = new ArrayList<>();

        originalStream.stream()
                .forEach(integer -> {
                    checkIfNumberDivisibleBy_3_Or_5_Or_15_AndPopulateList(integer, strings, String.valueOf(integer), String.valueOf(integer));
                });

        List<String> collect = strings.stream()
                .filter(string -> string.length() != 0)
                .map(string -> {
                    if (string.contains("3")) {
                        string = string.replace(string, ALFRESCO);
                    }
                    return string;
                }).collect(Collectors.toList());

        return collect.stream()
                .map(string -> {
                    try {
                        if (Integer.parseInt(string) % 3 == 0) {
                            string = string.replace(string, FIZZ);
                        }
                    } catch (NumberFormatException e) {
                        LOG.info("Number format exception has been caught for " + string);
                    }
                    return string;
                }).collect(Collectors.toList());
    }
}
