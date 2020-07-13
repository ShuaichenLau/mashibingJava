package com.alice.d4_ChainOfResponsibility;

/**
 * @author liusc
 * 2020年7月13日15:58:43
 * 责任链模式
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {

        Msg msg = new Msg();

        msg.setMsg("大家好!马士兵网站 mashibing.com, <script>  大家都是996  ");

        HtmlFilter htmlFilter = new HtmlFilter();
        htmlFilter.doFilter(msg);
        System.out.println(msg.getMsg());

    }
}
