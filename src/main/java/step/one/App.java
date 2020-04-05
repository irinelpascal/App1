package step.one;

import step.one.reader.ReaderProcessor;
import step.one.writer.AlfrescoWriter;
import step.one.writer.Writer;
import step.one.writer.WriterProcessor;

import java.util.List;
import java.util.stream.Collectors;

public class App {

    private ReaderProcessor readerProcessor;
    private WriterProcessor writerProcessor;
    private Writer writer;

    public App() {
        readerProcessor = new ReaderProcessor();
    }

    public static void main(String[] args) {

        new App().processAndViewStreamOfNumbers();
    }

    public void processAndViewStreamOfNumbers() {
        readerProcessor.processReading();
        writerProcessor = new WriterProcessor(readerProcessor);
        System.out.println(writerProcessor.getStream()
                .stream()
                .collect(Collectors.joining(" ")));
    }
}
