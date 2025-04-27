package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 佳叙
 * @date 2025/4/26
 * @description <a href=""/>
 */
public class _CompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("complete" + Thread.currentThread().getName());
        System.out.println(future.isDone());

        CompletableFuture.runAsync(() -> System.out.println("runAsync" + Thread.currentThread().getName()));
        System.out.println(CompletableFuture.supplyAsync(() -> "supplyAsync" + Thread.currentThread().getName()).get());

        CompletableFuture
                .runAsync(() -> System.out.println("step 1" + Thread.currentThread().getName()))
                .thenRunAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRunAsync(() -> System.out.println("step 2" + Thread.currentThread().getName()))
                .handle((ex, ans) -> ex)
                .thenAccept((s) -> System.out.println(s))
                .join();

        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> "a");
        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> "b");
        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> "c");

        a
                .thenCompose(x -> b)
                .thenCombine(c, (x, y) -> {
                    System.out.println(x + y);
                    return x + y;
                });



    }

}