import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AdventDay03 {
    final static String regex="mul\\((\\d+),(\\d+)\\)";
    public static int compute(String entry)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entry);

        int result = 0;
        while (matcher.find()) {
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));

            int x = num1*num2;

            result= result+x;
        }
        return result;
    }

    public static void main(String[] args)
    {

        AtomicInteger result1= new AtomicInteger();//la lambda fonction accepte une variable de type final ou sinon faudra la rendre atomique pour que ça passe

        try {
            Stream<String> lines = Files.lines(Path.of("input_day3.txt"));
            lines.forEach(x->{
                result1.addAndGet(compute(x));
            });

            System.out.println(result1.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
