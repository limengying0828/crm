package com.hy.crm.bo.pml;

import com.hy.crm.pojo.Contract;
import com.hy.crm.pojo.Makeapply;
import com.hy.crm.pojo.Remits;

/**
 * @Author 潘梦丽
 * @create 2020/9/12
 */
public class ContractBos {
    private Contract contract;
    private Makeapply makeapply;
    private Remits remits;

    public ContractBos(Contract contract, Makeapply makeapply, Remits remits) {
        this.contract = contract;
        this.makeapply = makeapply;
        this.remits = remits;
    }

    @Override
    public String toString() {
        return "ContractBos{" +
                "contract=" + contract +
                ", makeapply=" + makeapply +
                ", remits=" + remits +
                '}';
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Makeapply getMakeapply() {
        return makeapply;
    }

    public void setMakeapply(Makeapply makeapply) {
        this.makeapply = makeapply;
    }

    public Remits getRemits() {
        return remits;
    }

    public void setRemits(Remits remits) {
        this.remits = remits;
    }
}
