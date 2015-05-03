import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class PE2 {
    public static void main(String... args) {
        System.out.println(
                Util.takeWhile(
                        LongStream.generate(new LongSupplier() {
                            long a = 0, b = 1;

                            @Override
                            public long getAsLong() {
                                long r = a + b;
                                a = b;
                                b = r;
                                return r;
                            }
                        }), x -> x < 4_000_000)
                        .filter(x -> x % 2 == 0)
                        .sum());
    }
}
