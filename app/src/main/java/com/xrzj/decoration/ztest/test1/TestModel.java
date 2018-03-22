package com.xrzj.decoration.ztest.test1;

import android.util.Log;

import com.xrzj.decoration.api.apiservice.ApiService;
import com.xrzj.decoration.base.response.BaseResponse;
import com.xrzj.decoration.utils.RequestUtil;
import com.xrzj.decoration.utils.rsaUtils.RsaUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;


/**
 * @author: zhoufu
 * @date: On 2018/3/7
 */

public class TestModel implements BaseTestModel {
    @Override
    public void search(String ip, final AsyncCallback callBack) {
        Log.d("Test2Model","search");
        RequestUtil.getCutomService(ApiService.class)
                .executeGet(ip)
                //在主线程中观察
                .observeOn(AndroidSchedulers.mainThread())
                //在新线程中执行网络请求
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<IPHttpResult<TestBean>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull IPHttpResult<TestBean> testBeanIPHttpResult) {
                        callBack.OnSuccessed(testBeanIPHttpResult.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                callBack.OnFialded("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            callBack.OnFialded("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            callBack.OnFialded("网络连接超时!!");
                        } else {
                            callBack.OnFialded("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void getpublicKey(final AsyncCallback callBack) {
        Log.d("Test2Model","get");

        RequestUtil.getCutomService(ApiService.class).executeGet()
                //在主线程中观察
                .observeOn(AndroidSchedulers.mainThread())
                //在新线程中执行网络请求
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BaseResponse>(){

                    @Override
                    public void onSubscribe(Disposable disposable) {
                        Log.d("TestModel", "onSubscribe");
                    }

                    @Override
                    public void onNext(BaseResponse publicKeyBaseResponse) {
                        Log.d("TestModel", "onNext");
                        String publickey = (String)publicKeyBaseResponse.getDetail();
                        publickey.trim().replaceAll("\r\n","");
                        try {
                            PublicKey key =  RsaUtil.string2PublicKey(publickey);
                            byte[] base642Byt = RsaUtil.base642Byte("123"+"and");
                            byte[] publicEncrypt = RsaUtil.publicEncrypt(base642Byt, key);

                        }catch (Exception e){

                        }
                        callBack.OnSuccessed(publickey);


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TestModel", "onError");
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                Log.d("TestModel", "服务器出错");
                                callBack.OnFialded("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            Log.d("TestModel", "网络断开,请打开网络!");
                            callBack.OnFialded("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            Log.d("TestModel", "网络连接超时");
                            callBack.OnFialded("网络连接超时!!");
                        } else {
                            Log.d("TestModel", "发生未知错误");
                            callBack.OnFialded("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TestModel", "onComplete");
                    }
                });

    }


    @Override
    public void gettoken(final String key,final AsyncCallback callBack) {
        Log.d("Test2Model","gettoken");
        Log.d("TestModel", "onNext");
        String newkey = key;
        newkey.trim().replaceAll("\r\n","");
        Log.d("TestModel", "key" + key);
        Log.d("TestModel", "newkey" + newkey);
        String message = "123and";
        Map<String, Object> map = new HashMap<>();
        try {
            PublicKey pubk =  RsaUtil.string2PublicKey(newkey);

            byte[] publicEncrypt = RsaUtil.publicEncrypt(message.getBytes(), pubk);
            String strqq = RsaUtil.byte2Base64(publicEncrypt);
            map.put("secretMessage",strqq);
            map.put("publicKey",key);
        }catch (Exception e){

        }

        RequestUtil.getCutomService(ApiService.class).executeGetToken(map)
                //在主线程中观察
                .observeOn(AndroidSchedulers.mainThread())
                //在新线程中执行网络请求
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<BaseResponse>(){

                    @Override
                    public void onSubscribe(Disposable disposable) {
                        Log.d("TestModel", "onSubscribe");
                    }

                    @Override
                    public void onNext(BaseResponse publicKeyBaseResponse) {

                        callBack.OnSuccessed(publicKeyBaseResponse.getDetail());


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TestModel", "onError");
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                Log.d("TestModel", "服务器出错");
                                callBack.OnFialded("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            Log.d("TestModel", "网络断开,请打开网络!");
                            callBack.OnFialded("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            Log.d("TestModel", "网络连接超时");
                            callBack.OnFialded("网络连接超时!!");
                        } else {
                            Log.d("TestModel", "发生未知错误");
                            callBack.OnFialded("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TestModel", "onComplete");
                    }
                });

    }
}

