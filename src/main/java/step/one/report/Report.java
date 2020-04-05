package step.one.report;

import step.one.writer.AlfrescoWriter;

import java.util.logging.Logger;

public class Report {

    private static final Logger LOG = Logger.getLogger(Report.class.getName());
    private AlfrescoWriter alfrescoWriter;

    public Report(AlfrescoWriter alfrescoWriter) {
        this.alfrescoWriter = alfrescoWriter;
    }
}
