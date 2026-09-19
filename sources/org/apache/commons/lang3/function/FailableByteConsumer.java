package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface FailableByteConsumer<E extends Throwable> {
    public static final FailableByteConsumer NOP = new FailableByteConsumer() { // from class: org.apache.commons.lang3.function.FailableByteConsumer$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableByteConsumer
        public final void accept(byte b) throws Throwable {
            FailableByteConsumer.lambda$static$0(b);
        }
    };

    static /* synthetic */ void lambda$static$0(byte b) throws Throwable {
    }

    void accept(byte b) throws Throwable;

    static <E extends Throwable> FailableByteConsumer<E> nop() {
        return NOP;
    }

    default FailableByteConsumer<E> andThen(final FailableByteConsumer<E> failableByteConsumer) {
        Objects.requireNonNull(failableByteConsumer);
        return new FailableByteConsumer() { // from class: org.apache.commons.lang3.function.FailableByteConsumer$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableByteConsumer
            public final void accept(byte b) throws Throwable {
                FailableByteConsumer.lambda$andThen$0(this.f$0, failableByteConsumer, b);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$0(FailableByteConsumer _this, FailableByteConsumer failableByteConsumer, byte b) throws Throwable {
        _this.accept(b);
        failableByteConsumer.accept(b);
    }
}
