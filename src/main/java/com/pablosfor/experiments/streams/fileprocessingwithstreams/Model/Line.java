package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.util.List;

public interface Line {
    List<ValidationError> validate(ValidationContext vCtx);
}

