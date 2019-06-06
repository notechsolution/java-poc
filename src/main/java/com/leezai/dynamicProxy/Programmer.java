package com.leezai.dynamicProxy;

import com.leezai.annotation.RequireRoles;

public interface Programmer {
    public void code();
    @RequireRoles({"developer","architect"})
    public void debug();
}
