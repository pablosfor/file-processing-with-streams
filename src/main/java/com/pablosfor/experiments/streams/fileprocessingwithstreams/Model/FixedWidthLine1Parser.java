package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

public class FixedWidthLine1Parser implements FixedWidthLineParser {

    @Override
    public Line parse(String s) {
        var parserEngine = new FixedWidthLineParserEngine(); 
        
        parserEngine.skip(8);

        return LineType1AR.builder()
            .Id(Constants.LINE1_RECORD_TYPE)
            .Name(parserEngine.parseString(s, 40))
            .Code(parserEngine.parseLong(s, 8))
            .CheckDate(parserEngine.parseDate(s))
            .build();
    }
    
}
