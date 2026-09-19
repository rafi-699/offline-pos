package org.apache.commons.lang3.function;

import com.brentvatne.exoplayer.ReactExoplayerView;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface FailableLongToDoubleFunction<E extends Throwable> {
    public static final FailableLongToDoubleFunction NOP = new FailableLongToDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableLongToDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableLongToDoubleFunction
        public final double applyAsDouble(long j) {
            return ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE;
        }
    };

    double applyAsDouble(long j) throws Throwable;

    static <E extends Throwable> FailableLongToDoubleFunction<E> nop() {
        return NOP;
    }
}
