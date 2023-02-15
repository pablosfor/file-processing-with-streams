package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.beans.JavaBean;
import java.util.stream.Stream;

@JavaBean
public class FixedWidthParser implements Parser{
    private FixedWidthLineParserFactory lineParserFactory = new FixedWidthLineParserFactory();

    @Override
    public Stream<Line> parseStream(Stream<String> strings) {
        return strings.map(s -> transform(s));
    }

    private Line transform(String s){
        var registerCodeString = s.substring(0,8);
        var registerCode = Integer.parseInt(registerCodeString);

        return lineParserFactory.getLineParser(registerCode).parse(s);
    }
    
}
