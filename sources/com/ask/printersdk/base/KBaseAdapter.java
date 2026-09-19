package com.ask.printersdk.base;

import _COROUTINE.ArtificialStackFrames;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KBaseAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002:\u0003$%&B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001d\u001a\u00020\u00132\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007J\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007J\"\u0010\u0018\u001a\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\"\u0010 \u001a\u00020\u00132\u0010\u0010!\u001a\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0006\u0010#\u001a\u00020\u0013R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nRU\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0018\u001a4\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ask/printersdk/base/KBaseAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ask/printersdk/base/KBaseAdapter$Holder;", "<init>", "()V", "mDataList", "", "mLayoutId", "", "Ljava/lang/Integer;", "addBindView", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "itemView", "itemData", ViewProps.POSITION, "", "loader", "Lcom/ask/printersdk/base/KBaseAdapter$Loader;", "getItemViewType", "Lkotlin/Function1;", "onCreateViewHolder", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "parent", "viewType", "setData", "list", "getData", "onBindViewHolder", "holder", "getItemCount", "load", "Holder", "Builder", "Loader", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KBaseAdapter<T> extends RecyclerView.Adapter<KBaseAdapter<T>.Holder> {
    private Function3<? super View, ? super T, ? super Integer, Unit> addBindView;
    private Function1<? super Integer, Integer> getItemViewType;
    private Loader<T> loader;
    private List<? extends T> mDataList;
    private Integer mLayoutId;
    private Function2<? super ViewGroup, ? super Integer, ? extends View> onCreateViewHolder;

    /* JADX INFO: compiled from: KBaseAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\u0007J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/ask/printersdk/base/KBaseAdapter$Loader;", "D", "", "loadData", "", "callback", "Lcom/ask/printersdk/base/KBaseAdapter$Loader$LoadCallback;", "LoadCallback", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Loader<D> {

        /* JADX INFO: compiled from: KBaseAdapter.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/ask/printersdk/base/KBaseAdapter$Loader$LoadCallback;", "D", "", "finish", "", "list", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public interface LoadCallback<D> {
            void finish(List<? extends D> list);
        }

        void loadData(LoadCallback<D> callback);
    }

    public /* synthetic */ KBaseAdapter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private KBaseAdapter() {
    }

    public final void setData(List<? extends T> list) {
        this.mDataList = list;
    }

    public final List<T> getData() {
        return this.mDataList;
    }

    /* JADX INFO: compiled from: KBaseAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ask/printersdk/base/KBaseAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ask/printersdk/base/KBaseAdapter;Landroid/view/View;)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Holder extends RecyclerView.ViewHolder {
        final /* synthetic */ KBaseAdapter<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(KBaseAdapter kBaseAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = kBaseAdapter;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public KBaseAdapter<T>.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Function2<? super ViewGroup, ? super Integer, ? extends View> function2 = this.onCreateViewHolder;
        if (function2 != null) {
            Intrinsics.checkNotNull(function2);
            return new Holder(this, function2.invoke(parent, Integer.valueOf(viewType)));
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        Integer num = this.mLayoutId;
        Intrinsics.checkNotNull(num);
        View viewInflate = layoutInflaterFrom.inflate(num.intValue(), parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new Holder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(KBaseAdapter<T>.Holder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Function3<? super View, ? super T, ? super Integer, Unit> function3 = this.addBindView;
        if (function3 != null) {
            View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            List<? extends T> list = this.mDataList;
            ArtificialStackFrames artificialStackFrames = list != null ? list.get(position) : null;
            Intrinsics.checkNotNull(artificialStackFrames);
            function3.invoke(itemView, artificialStackFrames, Integer.valueOf(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.mDataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Function1<? super Integer, Integer> function1 = this.getItemViewType;
        if (function1 != null) {
            Intrinsics.checkNotNull(function1);
            return function1.invoke(Integer.valueOf(position)).intValue();
        }
        return super.getItemViewType(position);
    }

    /* JADX INFO: compiled from: KBaseAdapter.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bJ\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0010J/\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012JD\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u000026\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0017JY\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020!0\u001eJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ask/printersdk/base/KBaseAdapter$Builder;", "B", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "adapter", "Lcom/ask/printersdk/base/KBaseAdapter;", "setData", "lists", "", "loader", "Lcom/ask/printersdk/base/KBaseAdapter$Loader;", "setLayoutId", "layoutId", "", "getItemViewType", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ViewProps.POSITION, "onCreateViewHolder", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "parent", "viewType", "Landroid/view/View;", "addBindView", "itemBind", "Lkotlin/Function3;", "itemView", "itemData", "", InAppPurchaseConstants.METHOD_BUILD, "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder<B> {
        private KBaseAdapter<B> adapter;
        private final RecyclerView recyclerView;

        public Builder(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.recyclerView = recyclerView;
            this.adapter = new KBaseAdapter<>(null);
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator != null) {
                SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
                simpleItemAnimator.setSupportsChangeAnimations(false);
                simpleItemAnimator.setChangeDuration(0L);
            }
            if (recyclerView.getLayoutManager() == null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            }
        }

        public final Builder<B> setData(List<? extends B> lists) {
            ((KBaseAdapter) this.adapter).mDataList = lists;
            return this;
        }

        public final Builder<B> setData(Loader<B> loader) {
            Intrinsics.checkNotNullParameter(loader, "loader");
            ((KBaseAdapter) this.adapter).loader = loader;
            return this;
        }

        public final Builder<B> setLayoutId(int layoutId) {
            ((KBaseAdapter) this.adapter).mLayoutId = Integer.valueOf(layoutId);
            return this;
        }

        public final Builder<B> getItemViewType(Function1<? super Integer, Integer> getItemViewType) {
            Intrinsics.checkNotNullParameter(getItemViewType, "getItemViewType");
            ((KBaseAdapter) this.adapter).getItemViewType = getItemViewType;
            return this;
        }

        public final Builder<B> onCreateViewHolder(Function2<? super ViewGroup, ? super Integer, ? extends View> onCreateViewHolder) {
            Intrinsics.checkNotNullParameter(onCreateViewHolder, "onCreateViewHolder");
            ((KBaseAdapter) this.adapter).onCreateViewHolder = onCreateViewHolder;
            return this;
        }

        public final Builder<B> addBindView(Function3<? super View, ? super B, ? super Integer, Unit> itemBind) {
            Intrinsics.checkNotNullParameter(itemBind, "itemBind");
            ((KBaseAdapter) this.adapter).addBindView = itemBind;
            return this;
        }

        public final KBaseAdapter<B> build() {
            this.recyclerView.setAdapter(this.adapter);
            this.adapter.load();
            return this.adapter;
        }
    }

    public final void load() {
        Loader<T> loader = this.loader;
        if (loader != null) {
            loader.loadData(new Loader.LoadCallback<T>(this) { // from class: com.ask.printersdk.base.KBaseAdapter.load.1
                final /* synthetic */ KBaseAdapter<T> this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.ask.printersdk.base.KBaseAdapter.Loader.LoadCallback
                public void finish(List<? extends T> list) {
                    Intrinsics.checkNotNullParameter(list, "list");
                    ((KBaseAdapter) this.this$0).mDataList = list;
                    this.this$0.notifyDataSetChanged();
                }
            });
        }
    }
}
