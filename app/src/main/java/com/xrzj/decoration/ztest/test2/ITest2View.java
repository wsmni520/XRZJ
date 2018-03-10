package com.xrzj.decoration.ztest.test2;

/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public interface ITest2View {
    public void searchSuccess();
    public void searchFailed(String errorMessage);
    public void showData(String bean);
    public void showErro();
}
