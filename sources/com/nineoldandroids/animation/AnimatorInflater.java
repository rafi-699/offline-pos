package com.nineoldandroids.animation;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class AnimatorInflater {
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int[] AnimatorSet = {R.attr.ordering};
    private static final int[] PropertyAnimator = {R.attr.propertyName};
    private static final int[] Animator = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};

    public static Animator loadAnimator(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                animation = context.getResources().getAnimation(i);
                Animator animatorCreateAnimatorFromXml = createAnimatorFromXml(context, animation);
                if (animation != null) {
                    animation.close();
                }
                return animatorCreateAnimatorFromXml;
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, IOException {
        int i2;
        ValueAnimator valueAnimatorLoadAnimator;
        ObjectAnimator objectAnimatorLoadObjectAnimator;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        Animator animator = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    objectAnimatorLoadObjectAnimator = loadObjectAnimator(context, attributeSet);
                } else if (name.equals("animator")) {
                    valueAnimatorLoadAnimator = loadAnimator(context, attributeSet, null);
                } else if (name.equals("set")) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                    TypedValue typedValue = new TypedValue();
                    typedArrayObtainStyledAttributes.getValue(0, typedValue);
                    createAnimatorFromXml(context, xmlPullParser, attributeSet, animatorSet2, typedValue.type == 16 ? typedValue.data : 0);
                    typedArrayObtainStyledAttributes.recycle();
                    animator = animatorSet2;
                } else {
                    throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                }
                if (animatorSet != null) {
                    animator = valueAnimatorLoadAnimator;
                    if (arrayList == null) {
                        animator = objectAnimatorLoadObjectAnimator;
                        arrayList = new ArrayList();
                    }
                    animator = objectAnimatorLoadObjectAnimator;
                    arrayList.add(animator);
                } else {
                    animator = valueAnimatorLoadAnimator;
                    animator = objectAnimatorLoadObjectAnimator;
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
                return animator;
            }
            animatorSet.playSequentially(animatorArr);
        }
        return animator;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
        return objectAnimator;
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        int i;
        int i2;
        int i3;
        int color;
        int i4;
        int color2;
        int color3;
        float dimension;
        float dimension2;
        float dimension3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Animator);
        long j = typedArrayObtainStyledAttributes.getInt(1, 0);
        long j2 = typedArrayObtainStyledAttributes.getInt(2, 0);
        int i5 = typedArrayObtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        int i6 = i5 == 0 ? 1 : 0;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(5);
        boolean z = typedValuePeekValue != null;
        int i7 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
        boolean z2 = typedValuePeekValue2 != null;
        if (z2) {
            i2 = typedValuePeekValue2.type;
            i = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((z && i7 >= 28 && i7 <= 31) || (z2 && i2 >= 28 && i2 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            i6 = i;
        }
        if (i6 != 0) {
            if (z) {
                if (i7 == 5) {
                    dimension2 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
                } else {
                    dimension2 = typedArrayObtainStyledAttributes.getFloat(5, 0.0f);
                }
                if (z2) {
                    if (i2 == 5) {
                        dimension3 = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                    } else {
                        dimension3 = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
                    }
                    float[] fArr = new float[2];
                    fArr[i] = dimension2;
                    fArr[1] = dimension3;
                    valueAnimator2.setFloatValues(fArr);
                } else {
                    float[] fArr2 = new float[1];
                    fArr2[i] = dimension2;
                    valueAnimator2.setFloatValues(fArr2);
                }
            } else {
                if (i2 == 5) {
                    dimension = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    dimension = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
                }
                float[] fArr3 = new float[1];
                fArr3[i] = dimension;
                valueAnimator2.setFloatValues(fArr3);
            }
            i3 = i;
        } else {
            if (z) {
                if (i7 == 5) {
                    color2 = (int) typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
                    i4 = i;
                } else if (i7 >= 28 && i7 <= 31) {
                    i4 = i;
                    color2 = typedArrayObtainStyledAttributes.getColor(5, i4);
                } else {
                    i4 = i;
                    color2 = typedArrayObtainStyledAttributes.getInt(5, i4);
                }
                if (z2) {
                    if (i2 == 5) {
                        color3 = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i2 >= 28 && i2 <= 31) {
                        color3 = typedArrayObtainStyledAttributes.getColor(6, i4);
                    } else {
                        color3 = typedArrayObtainStyledAttributes.getInt(6, i4);
                    }
                    valueAnimator2.setIntValues(color2, color3);
                } else {
                    valueAnimator2.setIntValues(color2);
                }
            } else if (z2) {
                if (i2 == 5) {
                    color = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                    i3 = 0;
                } else if (i2 >= 28 && i2 <= 31) {
                    i3 = 0;
                    color = typedArrayObtainStyledAttributes.getColor(6, 0);
                } else {
                    i3 = 0;
                    color = typedArrayObtainStyledAttributes.getInt(6, 0);
                }
                valueAnimator2.setIntValues(color);
            }
            i3 = 0;
        }
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(typedArrayObtainStyledAttributes.getInt(3, i3));
        }
        if (typedArrayObtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(typedArrayObtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, i3);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        typedArrayObtainStyledAttributes.recycle();
        return valueAnimator2;
    }
}
