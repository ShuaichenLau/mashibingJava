package com.alice.d4_ChainOfResponsibility;

public class HtmlFilter implements FilterExt {

    @Override
    public void doFilter(Msg msg) {
        String msgStr = msg.getMsg();
        msgStr = msgStr.replaceAll("<", "(");
        msgStr = msgStr.replaceAll(">", ")");
        msgStr = msgStr.replace(".", "/");
        msg.setMsg(msgStr);
    }
}