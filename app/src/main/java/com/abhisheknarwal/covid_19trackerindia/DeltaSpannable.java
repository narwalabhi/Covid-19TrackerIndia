package com.abhisheknarwal.covid_19trackerindia;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public final class DeltaSpannable extends SpannableString {

    public DeltaSpannable(@NotNull String langName, @NotNull String langColor, int start) {
        super(langName);
        Intrinsics.checkParameterIsNotNull(langName, "langName");
        Intrinsics.checkParameterIsNotNull(langColor, "langColor");
        this.setSpan(new ForegroundColorSpan(Color.parseColor(langColor)), start, langName.length(), 33);
    }
    
}
