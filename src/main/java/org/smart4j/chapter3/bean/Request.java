package org.smart4j.chapter3.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by wangbin10 on 2018/8/17.
 * page=105
 */
public class Request {
    private String requestMethod;
    private String requestPath;

    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public boolean equals(Object obj) {
       return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
       return HashCodeBuilder.reflectionHashCode(this);
    }
}
