package com.sh.crm.refer.po;

/**
 * Created by Administrator on 2017/1/15.
 */
public class ReferCondition {

    private Refer refer;
    private String condition;

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "ReferCondition{" +
                "refer=" + refer +
                ", condition='" + condition + '\'' +
                '}';
    }
}
