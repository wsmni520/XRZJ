package com.xrzj.decoration.model;

/**
 * @author: zhoufu
 * @date: On 2018/3/5
 */

public interface IModel {

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

