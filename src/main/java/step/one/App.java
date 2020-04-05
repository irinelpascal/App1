package step.one;

import step.one.reader.ReaderProcessor;
import step.one.writer.AlfrescoWriter;
import step.one.writer.Writer;
import step.one.writer.WriterProcessor;

import java.util.stream.Collectors;

public class App {

    private ReaderProcessor readerProcessor;
    private WriterProcessor writerProcessor;

    public App() {
        readerProcessor = new ReaderProcessor();
    }

    public static void main(String[] args) {
        new App().processAndViewStreamOfNumbers();
    }

    public void processAndViewStreamOfNumbers() {
        readerProcessor.processReading();
        writerProcessor = new WriterProcessor(readerProcessor);
        showStream(new AlfrescoWriter(writerProcessor));
    }

    private void showStream(Writer writer) {
        System.out.println(writer.getMalformedStream().stream()
                .collect(Collectors.joining(" ")));
    }
}
