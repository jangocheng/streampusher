package com.believer.magicfilter.filter.advanced;

import android.opengl.GLES20;

import com.believer.magicfilter.filter.base.gpuimage.GPUImageFilter;
import com.believer.mypublisher.R;

public class MagicBeautyFilter extends GPUImageFilter {
    private int mSingleStepOffsetLocation;

    public MagicBeautyFilter() {
        super(R.raw.beauty_new);
    }

    protected void onInit() {
        super.onInit();
        mSingleStepOffsetLocation = GLES20.glGetUniformLocation(getProgram(), "singleStepOffset");
    }

    @Override
    public void onInputSizeChanged(final int width, final int height) {
        super.onInputSizeChanged(width, height);
        setFloatVec2(mSingleStepOffsetLocation, new float[]{2.0f / width, 2.0f / height});
    }
}
