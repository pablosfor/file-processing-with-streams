package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

public class FixedWidthLine2Parser implements FixedWidthLineParser {

    @Override
    public Line parse(String s) {
        var parserEngine = new FixedWidthLineParserEngine(); 
        
        parserEngine.skip(8);

        return LineType2AR.builder()
            .Id(Constants.LINE1_RECORD_TYPE)
            .RowCount(parserEngine.parseInt(s, 8))
            .build();
    }
    
}
