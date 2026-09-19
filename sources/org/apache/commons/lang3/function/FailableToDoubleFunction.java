package org.apache.commons.lang3.function;

import com.brentvatne.exoplayer.ReactExoplayerView;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface FailableToDoubleFunction<T, E extends Throwable> {
    public static final FailableToDoubleFunction NOP = new FailableToDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableToDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableToDoubleFunction
        public final double applyAsDouble(Object obj) {
            return ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE;
        }
    };

    double applyAsDouble(T t) throws Throwable;

    static <T, E extends Throwable> FailableToDoubleFunction<T, E> nop() {
        return NOP;
    }
}
