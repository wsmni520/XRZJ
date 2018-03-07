package com.xrzj.decoration.test.test1;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public interface ITestView {
    public void searchSuccess();
    public void searchFailed(String errorMessage);
    public void showData(TestBean bean);
    public void showErro();
}
