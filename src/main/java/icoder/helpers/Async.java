package icoder.helpers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Async class helper
 *
 * @since 1.0
 */
public class Async {
    /**
     * Supplier
     *
     * @param <T>
     */
    public interface Supplier<T> {
        T execute() throws Exception;
    }

    /**
     * Convert future to CompletableFuture
     *
     * @param <T>
     * @return
     */
    public static <T> CompletableFuture<T> supply(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return supplier.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Convert future to CompletableFuture
     *
     * @param future Future
     * @param <T>
     * @return
     */
    public static <T> CompletableFuture<T> supply(Future<T> future) {
        return supply(future::get);
    }
}