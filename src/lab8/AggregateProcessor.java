package lab8;

import java.util.List;
import java.util.stream.Collectors;

public class AggregateProcessor {
    @DataProcessor
    public List<String> aggregateToSingleString(List<String> data) {
        String aggregated = data.stream().collect(Collectors.joining(" "));
        return List.of(aggregated);
    }
}

