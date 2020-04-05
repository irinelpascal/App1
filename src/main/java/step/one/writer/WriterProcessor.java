package step.one.writer;

import org.apache.commons.collections4.CollectionUtils;
import step.one.reader.ReaderProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class WriterProcessor implements Writer {

    private static final Logger LOG = Logger.getLogger(WriterProcessor.class.getName());
    private ReaderProcessor reader;
    private List<String> strings;

    public WriterProcessor(ReaderProcessor reader) {
        this.reader = reader;
    }

    @Override
    public List<String> getStream() {
        strings = new ArrayList<>();
        IntStream.range(reader.getMinimumRange(), reader.getMaximumRange() + 1)
                .forEach(number -> {
                    if (number % 3 == 0 && number % 5 != 0) {
                        strings.add("fizz");
                    } else if (number % 5 == 0 && number % 3 != 0) {
                        strings.add("buzz");
                    } else if (number % 15 == 0) {
                        strings.add("fizzbuzz");
                    } else {
                        strings.add(String.valueOf(number));
                    }
                });
        if (CollectionUtils.isNotEmpty(strings)) {
            LOG.info("Numbers retrieved");
            return strings;
        }
        return Collections.emptyList();
    }

    public List<String> getStrings() {
        return strings;
    }
}
