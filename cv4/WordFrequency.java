package cv4;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String line = "apple banana  apple orange banana   apple ";

        List<String> parts = Arrays.stream(line.split(" "))
                                   .map(String::trim)
                                   .filter(p -> !p.isEmpty())
                                   .collect(Collectors.toList());

        Map<String, Long> wordCounts = parts.stream()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("Word Frequencies:");
        wordCounts.forEach((word, count) -> {
            System.out.println(word + ": " + count);
        });
    }
}