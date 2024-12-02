import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AdventDay02 {
    final static int INC = 1;
    final static int DEC = -1;
    final static String Entry="input_day2.txt";
    public static boolean isSafe(List<String> list)
    {   List<Integer> differList = List.of(1,2,3);
        int direction = 0;
        int differ =0;
        int first=0;
        int second =0;

        if(Integer.parseInt(list.get(0))>Integer.parseInt(list.get(1)))
        {
            direction = DEC;
        } else if (Integer.parseInt(list.get(0))<Integer.parseInt(list.get(1))) {
            direction = INC;
        }

        for(int i=1; i<list.size();++i)
        {
            first=Integer.parseInt(list.get(i-1));
            second=Integer.parseInt(list.get(i));

            if((direction==INC) & (first>second))
            {
                return false;
            } else if ((direction==DEC) & (first<second)){
                return false;
            } else if(first==second) {
                return false;
            } else {
                differ=Math.abs(first-second);
                if(!differList.contains(differ))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDampenerSafe(List<String> list)
    {
        for(int i =0;i<list.size();++i)
        {
            List<String> entry = new ArrayList<>(list);
            entry.remove(i);
            if (isSafe(entry)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args)
    {
        final String SEPARATOR=" ";
        try {

            Path path = Path.of(Entry);
            Stream<String> lines = Files.lines(path);
            Stream<String> lines2 = Files.lines(path);


            int result1 = (int )lines2.map(x->x.split(SEPARATOR))
                    .filter(x->isSafe(List.of(x)))
                    .count();

            System.out.println(result1);

            int result2 = (int )lines.map(x->x.split(SEPARATOR))
                    .filter(x->isDampenerSafe(List.of(x)))
                    .count();

            System.out.println(result2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}