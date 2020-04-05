package step.one.writer;

import java.util.List;

public class AlfrescoWriter implements Writer {

    private WriterProcessor writerProcessor;

    public AlfrescoWriter(WriterProcessor writerProcessor) {
        this.writerProcessor = writerProcessor;
    }

    @Override
    public List<String> getStream() {

        return null;
    }
}
