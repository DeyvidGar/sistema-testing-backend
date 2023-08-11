package com.sistem.testing.model.common;

import com.sistem.testing.model.User;

import java.util.Date;

public class ResponseModel {
    private boolean isExist;
    private Date timestamp;
    private Object objectPersist;

    public ResponseModel(Object object){
        if (object != null){
            this.isExist = true;
        } else {
            this.isExist = false;
        }
        this.timestamp = new Date();
        this.objectPersist = object;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getObjectPersist() {
        return objectPersist;
    }

    public void setObjectPersist(Object objectPersist) {
        this.objectPersist = objectPersist;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "isExist=" + isExist +
                ", timestamp=" + timestamp +
                ", objectPersist=" + objectPersist +
                '}';
    }
}
