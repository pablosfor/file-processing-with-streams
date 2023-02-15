package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.util.stream.Stream;

public interface Parser {
    Stream<Line> parseStream(Stream<String> strings);
}