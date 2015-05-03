import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

public class Util {
    public static LongStream takeWhile(LongStream src, LongPredicate pred) {
        Spliterator.OfLong s = src.spliterator();
        return StreamSupport.longStream(new Spliterators.AbstractLongSpliterator(
                s.estimateSize(),
                s.characteristics() & ~(Spliterator.SIZED | Spliterator.SUBSIZED)) {
            boolean taking = true;
            @Override
            public boolean tryAdvance(LongConsumer action) {
                return taking && s.tryAdvance((long elem) -> {
                    if (pred.test(elem)) {
                        action.accept(elem);
                    } else {
                        taking = false;
                    }
                });
            }
        }, false);
    }
}
