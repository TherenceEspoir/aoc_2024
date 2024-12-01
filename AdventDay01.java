import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AdventDay01 {

    public static void main(String[] args) {

        List<Integer> l1 =new ArrayList<>();
        List<Integer> l2 =new ArrayList<>();
        final String SEPARATOR="   ";
        try {
            try (Stream<String> lines = Files.lines(Path.of("input_day1.txt"))) {
                lines.map(x -> x.split(SEPARATOR))
                        .forEach(parts -> {
                            l1.add(Integer.valueOf(parts[0]));
                            l2.add(Integer.valueOf(parts[1]));
                        });
            }

            //Sort both list
            Collections.sort(l1);
            Collections.sort(l2);

            int distance= 0;

            for(int i=0;i<l1.size();++i)
            {
                distance += Math.abs(l1.get(i) - l2.get(i));
            }

            System.out.println(distance);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
