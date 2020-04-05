package step.one.writer;

import org.apache.commons.collections4.CollectionUtils;
import step.one.reader.ReaderProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static step.one.constants.ApplicationConstants.FIZZ;
import static step.one.util.ApplicationUtil.checkIfNumberDivisibleBy_3_Or_5_Or_15_AndPopulateList;

public class WriterProcessor implements Writer {

    private static final Logger LOG = Logger.getLogger(WriterProcessor.class.getName());
    private ReaderProcessor reader;
    private List<String> strings;

    public WriterProcessor(ReaderProcessor reader) {
        this.reader = reader;
    }

    public List<Integer> getOriginalStream() {
        List<Integer> integers = new ArrayList<>();
        for (int i = reader.getMinimumRange(); i <= reader.getMaximumRange(); i++) {
            integers.add(i);
        }

        if (CollectionUtils.isNotEmpty(integers)) {
            LOG.info("Retrieved original stream range");
            return integers;
        }
        LOG.info("The original stream is empty");
        return Collections.emptyList();
    }

    @Override
    public List<String> getMalformedStream() {
        strings = new ArrayList<>();
        IntStream.range(reader.getMinimumRange(), reader.getMaximumRange() + 1)
                .forEach(number -> {
                    checkIfNumberDivisibleBy_3_Or_5_Or_15_AndPopulateList(number, strings, FIZZ, String.valueOf(number));
                });
        if (CollectionUtils.isNotEmpty(strings)) {
            LOG.info("Numbers retrieved");
            return strings;
        }
        return Collections.emptyList();
    }
}
