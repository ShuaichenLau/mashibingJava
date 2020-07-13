package com.alice.d4_ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusc
 * 2020年7月13日16:10:43
 * 责任链模式
 */
public class FilterChain implements FilterExt {

    List<FilterExt> filterExtList = new ArrayList<FilterExt>();

    public FilterChain add(FilterExt filterExt) {
        filterExtList.add(filterExt);
        return this;
    }

    @Override
    public void doFilter(Msg msg) {

    }
}
