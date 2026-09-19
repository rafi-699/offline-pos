package com.ask.printersdk;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.databinding.ActivityPrintEditBindingImpl;
import com.ask.printersdk.databinding.DialogCommPopBindingImpl;
import com.ask.printersdk.databinding.DialogFloatMenuBindingImpl;
import com.ask.printersdk.databinding.DialogModifyDateBindingImpl;
import com.ask.printersdk.databinding.DialogModifyTimeBindingImpl;
import com.ask.printersdk.databinding.DialogSettingPaperBindingImpl;
import com.ask.printersdk.databinding.DialogTextInputBindingImpl;
import com.ask.printersdk.databinding.FloatMenuItemBindingImpl;
import com.ask.printersdk.databinding.FragmentBarcodeOpBindingImpl;
import com.ask.printersdk.databinding.FragmentBarcodeStyleBindingImpl;
import com.ask.printersdk.databinding.FragmentGraphAlignBindingImpl;
import com.ask.printersdk.databinding.FragmentImageConvertBindingImpl;
import com.ask.printersdk.databinding.FragmentImageOpBindingImpl;
import com.ask.printersdk.databinding.FragmentMaterialOpBindingImpl;
import com.ask.printersdk.databinding.FragmentMaterialStyleBindingImpl;
import com.ask.printersdk.databinding.FragmentOpMaterialListBindingImpl;
import com.ask.printersdk.databinding.FragmentQrcodeStyleBindingImpl;
import com.ask.printersdk.databinding.FragmentShapeStyleBindingImpl;
import com.ask.printersdk.databinding.FragmentTextFontBindingImpl;
import com.ask.printersdk.databinding.FragmentTextOpBindingImpl;
import com.ask.printersdk.databinding.FragmentTextStyleBindingImpl;
import com.ask.printersdk.databinding.FragmentTimeOpBindingImpl;
import com.ask.printersdk.databinding.FragmentTimeStyleBindingImpl;
import com.ask.printersdk.databinding.ItemDraftBindingImpl;
import com.ask.printersdk.databinding.ItemFontTextBindingImpl;
import com.ask.printersdk.databinding.ItemFunPickerBindingImpl;
import com.ask.printersdk.databinding.ItemMaterialPickerBindingImpl;
import com.ask.printersdk.databinding.ShapeListItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYPRINTEDIT = 1;
    private static final int LAYOUT_DIALOGCOMMPOP = 2;
    private static final int LAYOUT_DIALOGFLOATMENU = 3;
    private static final int LAYOUT_DIALOGMODIFYDATE = 4;
    private static final int LAYOUT_DIALOGMODIFYTIME = 5;
    private static final int LAYOUT_DIALOGSETTINGPAPER = 6;
    private static final int LAYOUT_DIALOGTEXTINPUT = 7;
    private static final int LAYOUT_FLOATMENUITEM = 8;
    private static final int LAYOUT_FRAGMENTBARCODEOP = 9;
    private static final int LAYOUT_FRAGMENTBARCODESTYLE = 10;
    private static final int LAYOUT_FRAGMENTGRAPHALIGN = 11;
    private static final int LAYOUT_FRAGMENTIMAGECONVERT = 12;
    private static final int LAYOUT_FRAGMENTIMAGEOP = 13;
    private static final int LAYOUT_FRAGMENTMATERIALOP = 14;
    private static final int LAYOUT_FRAGMENTMATERIALSTYLE = 15;
    private static final int LAYOUT_FRAGMENTOPMATERIALLIST = 16;
    private static final int LAYOUT_FRAGMENTQRCODESTYLE = 17;
    private static final int LAYOUT_FRAGMENTSHAPESTYLE = 18;
    private static final int LAYOUT_FRAGMENTTEXTFONT = 19;
    private static final int LAYOUT_FRAGMENTTEXTOP = 20;
    private static final int LAYOUT_FRAGMENTTEXTSTYLE = 21;
    private static final int LAYOUT_FRAGMENTTIMEOP = 22;
    private static final int LAYOUT_FRAGMENTTIMESTYLE = 23;
    private static final int LAYOUT_ITEMDRAFT = 24;
    private static final int LAYOUT_ITEMFONTTEXT = 25;
    private static final int LAYOUT_ITEMFUNPICKER = 26;
    private static final int LAYOUT_ITEMMATERIALPICKER = 27;
    private static final int LAYOUT_SHAPELISTITEM = 28;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(28);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_print_edit, 1);
        sparseIntArray.put(R.layout.dialog_comm_pop, 2);
        sparseIntArray.put(R.layout.dialog_float_menu, 3);
        sparseIntArray.put(R.layout.dialog_modify_date, 4);
        sparseIntArray.put(R.layout.dialog_modify_time, 5);
        sparseIntArray.put(R.layout.dialog_setting_paper, 6);
        sparseIntArray.put(R.layout.dialog_text_input, 7);
        sparseIntArray.put(R.layout.float_menu_item, 8);
        sparseIntArray.put(R.layout.fragment_barcode_op, 9);
        sparseIntArray.put(R.layout.fragment_barcode_style, 10);
        sparseIntArray.put(R.layout.fragment_graph_align, 11);
        sparseIntArray.put(R.layout.fragment_image_convert, 12);
        sparseIntArray.put(R.layout.fragment_image_op, 13);
        sparseIntArray.put(R.layout.fragment_material_op, 14);
        sparseIntArray.put(R.layout.fragment_material_style, 15);
        sparseIntArray.put(R.layout.fragment_op_material_list, 16);
        sparseIntArray.put(R.layout.fragment_qrcode_style, 17);
        sparseIntArray.put(R.layout.fragment_shape_style, 18);
        sparseIntArray.put(R.layout.fragment_text_font, 19);
        sparseIntArray.put(R.layout.fragment_text_op, 20);
        sparseIntArray.put(R.layout.fragment_text_style, 21);
        sparseIntArray.put(R.layout.fragment_time_op, 22);
        sparseIntArray.put(R.layout.fragment_time_style, 23);
        sparseIntArray.put(R.layout.item_draft, 24);
        sparseIntArray.put(R.layout.item_font_text, 25);
        sparseIntArray.put(R.layout.item_fun_picker, 26);
        sparseIntArray.put(R.layout.item_material_picker, 27);
        sparseIntArray.put(R.layout.shape_list_item, 28);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_print_edit_0".equals(tag)) {
                    return new ActivityPrintEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_print_edit is invalid. Received: " + tag);
            case 2:
                if ("layout/dialog_comm_pop_0".equals(tag)) {
                    return new DialogCommPopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_comm_pop is invalid. Received: " + tag);
            case 3:
                if ("layout/dialog_float_menu_0".equals(tag)) {
                    return new DialogFloatMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_float_menu is invalid. Received: " + tag);
            case 4:
                if ("layout/dialog_modify_date_0".equals(tag)) {
                    return new DialogModifyDateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_modify_date is invalid. Received: " + tag);
            case 5:
                if ("layout/dialog_modify_time_0".equals(tag)) {
                    return new DialogModifyTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_modify_time is invalid. Received: " + tag);
            case 6:
                if ("layout/dialog_setting_paper_0".equals(tag)) {
                    return new DialogSettingPaperBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_setting_paper is invalid. Received: " + tag);
            case 7:
                if ("layout/dialog_text_input_0".equals(tag)) {
                    return new DialogTextInputBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_text_input is invalid. Received: " + tag);
            case 8:
                if ("layout/float_menu_item_0".equals(tag)) {
                    return new FloatMenuItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for float_menu_item is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_barcode_op_0".equals(tag)) {
                    return new FragmentBarcodeOpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_barcode_op is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_barcode_style_0".equals(tag)) {
                    return new FragmentBarcodeStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_barcode_style is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_graph_align_0".equals(tag)) {
                    return new FragmentGraphAlignBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_graph_align is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_image_convert_0".equals(tag)) {
                    return new FragmentImageConvertBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_image_convert is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_image_op_0".equals(tag)) {
                    return new FragmentImageOpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_image_op is invalid. Received: " + tag);
            case 14:
                if ("layout/fragment_material_op_0".equals(tag)) {
                    return new FragmentMaterialOpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_material_op is invalid. Received: " + tag);
            case 15:
                if ("layout/fragment_material_style_0".equals(tag)) {
                    return new FragmentMaterialStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_material_style is invalid. Received: " + tag);
            case 16:
                if ("layout/fragment_op_material_list_0".equals(tag)) {
                    return new FragmentOpMaterialListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_op_material_list is invalid. Received: " + tag);
            case 17:
                if ("layout/fragment_qrcode_style_0".equals(tag)) {
                    return new FragmentQrcodeStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_qrcode_style is invalid. Received: " + tag);
            case 18:
                if ("layout/fragment_shape_style_0".equals(tag)) {
                    return new FragmentShapeStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_shape_style is invalid. Received: " + tag);
            case 19:
                if ("layout/fragment_text_font_0".equals(tag)) {
                    return new FragmentTextFontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_text_font is invalid. Received: " + tag);
            case 20:
                if ("layout/fragment_text_op_0".equals(tag)) {
                    return new FragmentTextOpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_text_op is invalid. Received: " + tag);
            case 21:
                if ("layout/fragment_text_style_0".equals(tag)) {
                    return new FragmentTextStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_text_style is invalid. Received: " + tag);
            case 22:
                if ("layout/fragment_time_op_0".equals(tag)) {
                    return new FragmentTimeOpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_time_op is invalid. Received: " + tag);
            case 23:
                if ("layout/fragment_time_style_0".equals(tag)) {
                    return new FragmentTimeStyleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_time_style is invalid. Received: " + tag);
            case 24:
                if ("layout/item_draft_0".equals(tag)) {
                    return new ItemDraftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_draft is invalid. Received: " + tag);
            case 25:
                if ("layout/item_font_text_0".equals(tag)) {
                    return new ItemFontTextBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_font_text is invalid. Received: " + tag);
            case 26:
                if ("layout/item_fun_picker_0".equals(tag)) {
                    return new ItemFunPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_fun_picker is invalid. Received: " + tag);
            case 27:
                if ("layout/item_material_picker_0".equals(tag)) {
                    return new ItemMaterialPickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_material_picker is invalid. Received: " + tag);
            case 28:
                if ("layout/shape_list_item_0".equals(tag)) {
                    return new ShapeListItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for shape_list_item is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(10);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "codeFormat");
            sparseArray.put(2, "contentTxt");
            sparseArray.put(3, "data");
            sparseArray.put(4, "editTxt");
            sparseArray.put(5, "fontSize");
            sparseArray.put(6, "isRedTintColor");
            sparseArray.put(7, "letterDistance");
            sparseArray.put(8, "lineDistance");
            sparseArray.put(9, "lineWeightString");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(28);
            sKeys = map;
            map.put("layout/activity_print_edit_0", Integer.valueOf(R.layout.activity_print_edit));
            map.put("layout/dialog_comm_pop_0", Integer.valueOf(R.layout.dialog_comm_pop));
            map.put("layout/dialog_float_menu_0", Integer.valueOf(R.layout.dialog_float_menu));
            map.put("layout/dialog_modify_date_0", Integer.valueOf(R.layout.dialog_modify_date));
            map.put("layout/dialog_modify_time_0", Integer.valueOf(R.layout.dialog_modify_time));
            map.put("layout/dialog_setting_paper_0", Integer.valueOf(R.layout.dialog_setting_paper));
            map.put("layout/dialog_text_input_0", Integer.valueOf(R.layout.dialog_text_input));
            map.put("layout/float_menu_item_0", Integer.valueOf(R.layout.float_menu_item));
            map.put("layout/fragment_barcode_op_0", Integer.valueOf(R.layout.fragment_barcode_op));
            map.put("layout/fragment_barcode_style_0", Integer.valueOf(R.layout.fragment_barcode_style));
            map.put("layout/fragment_graph_align_0", Integer.valueOf(R.layout.fragment_graph_align));
            map.put("layout/fragment_image_convert_0", Integer.valueOf(R.layout.fragment_image_convert));
            map.put("layout/fragment_image_op_0", Integer.valueOf(R.layout.fragment_image_op));
            map.put("layout/fragment_material_op_0", Integer.valueOf(R.layout.fragment_material_op));
            map.put("layout/fragment_material_style_0", Integer.valueOf(R.layout.fragment_material_style));
            map.put("layout/fragment_op_material_list_0", Integer.valueOf(R.layout.fragment_op_material_list));
            map.put("layout/fragment_qrcode_style_0", Integer.valueOf(R.layout.fragment_qrcode_style));
            map.put("layout/fragment_shape_style_0", Integer.valueOf(R.layout.fragment_shape_style));
            map.put("layout/fragment_text_font_0", Integer.valueOf(R.layout.fragment_text_font));
            map.put("layout/fragment_text_op_0", Integer.valueOf(R.layout.fragment_text_op));
            map.put("layout/fragment_text_style_0", Integer.valueOf(R.layout.fragment_text_style));
            map.put("layout/fragment_time_op_0", Integer.valueOf(R.layout.fragment_time_op));
            map.put("layout/fragment_time_style_0", Integer.valueOf(R.layout.fragment_time_style));
            map.put("layout/item_draft_0", Integer.valueOf(R.layout.item_draft));
            map.put("layout/item_font_text_0", Integer.valueOf(R.layout.item_font_text));
            map.put("layout/item_fun_picker_0", Integer.valueOf(R.layout.item_fun_picker));
            map.put("layout/item_material_picker_0", Integer.valueOf(R.layout.item_material_picker));
            map.put("layout/shape_list_item_0", Integer.valueOf(R.layout.shape_list_item));
        }
    }
}
