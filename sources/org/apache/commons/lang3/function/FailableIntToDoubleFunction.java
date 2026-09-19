package org.apache.commons.lang3.function;

import com.brentvatne.exoplayer.ReactExoplayerView;
import java.lang.Throwable;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface FailableIntToDoubleFunction<E extends Throwable> {
    public static final FailableIntToDoubleFunction NOP = new FailableIntToDoubleFunction() { // from class: org.apache.commons.lang3.function.FailableIntToDoubleFunction$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableIntToDoubleFunction
        public final double applyAsDouble(int i) {
            return ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE;
        }
    };

    double applyAsDouble(int i) throws Throwable;

    static <E extends Throwable> FailableIntToDoubleFunction<E> nop() {
        return NOP;
    }
}
