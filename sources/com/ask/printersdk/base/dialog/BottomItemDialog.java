package com.ask.printersdk.base.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.LayoutBottomItemDialogBinding;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomItemDialog extends BottomDialogFragment {
    private DialogAdapter adapter;
    private List<String> itemList;
    private DialogItemClick mDialogItemClick;
    private LayoutBottomItemDialogBinding viewBinding;

    public interface DialogItemClick {
        void onItemClick(int i, String str);
    }

    public BottomItemDialog setDialogItemClick(DialogItemClick dialogItemClick) {
        this.mDialogItemClick = dialogItemClick;
        return this;
    }

    public static BottomItemDialog getInstance() {
        return new BottomItemDialog();
    }

    public void show(FragmentManager fragmentManager, String str, List<String> list) {
        this.itemList = list;
        show(fragmentManager, str);
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected int setLayoutId() {
        return R.layout.layout_bottom_item_dialog;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initView() {
        this.viewBinding = LayoutBottomItemDialogBinding.bind(this.mRootView);
        this.adapter = new DialogAdapter();
        this.viewBinding.listView.setAdapter((ListAdapter) this.adapter);
        this.viewBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.ask.printersdk.base.dialog.BottomItemDialog.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BottomItemDialog.this.dismissAllowingStateLoss();
                if (BottomItemDialog.this.mDialogItemClick != null) {
                    BottomItemDialog.this.mDialogItemClick.onItemClick(i, (String) BottomItemDialog.this.itemList.get(i));
                }
            }
        });
        this.viewBinding.textCancel.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.base.dialog.BottomItemDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomItemDialog.this.dismissAllowingStateLoss();
            }
        });
    }

    public void updateDataSetChanged() {
        DialogAdapter dialogAdapter = this.adapter;
        if (dialogAdapter != null) {
            dialogAdapter.notifyDataSetChanged();
        }
    }

    private class DialogAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private DialogAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (BottomItemDialog.this.itemList == null) {
                return 0;
            }
            return BottomItemDialog.this.itemList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return BottomItemDialog.this.itemList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return BottomItemDialog.this.handleItemView(i, view, viewGroup);
        }
    }

    private class ViewHolder {
        private TextView mItem;

        private ViewHolder() {
        }
    }

    protected View handleItemView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = getLayoutInflater().inflate(R.layout.item_dialog, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mItem = (TextView) view.findViewById(R.id.text_desc);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mItem.setText(this.itemList.get(i));
        return view;
    }
}
