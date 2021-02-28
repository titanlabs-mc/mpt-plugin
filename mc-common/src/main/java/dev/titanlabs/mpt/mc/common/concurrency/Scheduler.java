package dev.titanlabs.mpt.mc.common.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Scheduler {
    private final ForkJoinPool worker = ForkJoinPool.commonPool();

    public CompletableFuture<Void> runAsync(Runnable runnable) {
        return CompletableFuture.runAsync(runnable, this.worker);
    }
}
