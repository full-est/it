package lab8;

import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterShortStrings(List<String> data) {
        return data.stream()
                .filter(w -> w.length() > 3)
                .collect(Collectors.toList());
    }
}

