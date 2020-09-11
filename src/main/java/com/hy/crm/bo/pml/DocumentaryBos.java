package com.hy.crm.bo.pml;

import com.hy.crm.pojo.Business;
import com.hy.crm.pojo.Documentary;
import com.hy.crm.pojo.User;

/**
 * @Author 潘梦丽
 * @create 2020/9/1
 */
public class DocumentaryBos {
    private Documentary documentary;
    private User user;
    private Business business;

    public DocumentaryBos(Documentary documentary, User user, Business business) {
        this.documentary = documentary;
        this.user = user;
        this.business = business;
    }

    @Override
    public String toString() {
        return "DocumentaryBos{" +
                "documentary=" + documentary +
                ", user=" + user +
                ", business=" + business +
                '}';
    }

    public Documentary getDocumentary() {
        return documentary;
    }

    public void setDocumentary(Documentary documentary) {
        this.documentary = documentary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
