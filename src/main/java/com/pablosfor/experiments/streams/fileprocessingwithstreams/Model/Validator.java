package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.io.BufferedWriter;
import java.util.stream.Stream;

public interface Validator {
    Stream<Line>  validate(Stream<Line> lines, BufferedWriter writer);
    
}
