package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.util.stream.Stream;

public interface ObjectUploadProcessor {
    void process(Stream<Line> lines);
}
