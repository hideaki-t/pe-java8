import java.util.stream.IntStream;

public class PE1 {
    public static void main(String...args) {
        System.out.println(
                IntStream.range(1, 1000)
                .filter(x -> (x % 3 == 0 || x % 5 == 0))
                .sum()
        );
    }
}
