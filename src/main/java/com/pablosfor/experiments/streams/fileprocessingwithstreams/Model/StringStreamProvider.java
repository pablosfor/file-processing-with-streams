package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.util.stream.Stream;

public interface StringStreamProvider {
    Stream<String> getStreams();
}
