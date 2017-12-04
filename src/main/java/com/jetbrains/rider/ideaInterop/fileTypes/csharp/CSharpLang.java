package com.jetbrains.rider.ideaInterop.fileTypes.csharp;

import com.jetbrains.rider.ideaInterop.fileTypes.RiderLanguageBase;

public class CSharpLang extends RiderLanguageBase {
    protected CSharpLang() {
        super("C#", "CSHARP");
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
