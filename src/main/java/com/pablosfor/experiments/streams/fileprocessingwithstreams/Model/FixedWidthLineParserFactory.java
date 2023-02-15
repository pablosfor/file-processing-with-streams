package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.text.MessageFormat;

import org.apache.logging.log4j.message.Message;

public class FixedWidthLineParserFactory {
    private FixedWidthLine1Parser line1Parser = new FixedWidthLine1Parser();
    private FixedWidthLine2Parser line2Parser = new FixedWidthLine2Parser();

    FixedWidthLineParser getLineParser(int lineType){
        switch (lineType) {
            case Constants.LINE1_RECORD_TYPE:
                return line1Parser;
            case Constants.LINE2_RECORD_TYPE:
                return line2Parser;
            default:
                throw new RuntimeException(MessageFormat.format( "Unrecognized line type {0}",lineType));
        }
    }

}
