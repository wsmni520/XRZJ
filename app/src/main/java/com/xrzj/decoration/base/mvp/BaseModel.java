package com.xrzj.decoration.base.mvp;

/**
 * MVP模式Model层的基类
 * @author: zhoufu
 * @date: On 2018/3/10
 */

public interface BaseModel {

    interface AsyncCallback {
        /**
         * @param success
         */
        public void OnSuccessed(Object success);

        /**
         * @param error
         */
        public void OnFialded(Object error);
    }
}

