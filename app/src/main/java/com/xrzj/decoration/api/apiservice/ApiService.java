package com.xrzj.decoration.api.apiservice;

import com.xrzj.decoration.base.response.BaseResponse;
import com.xrzj.decoration.ztest.test1.IPHttpResult;
import com.xrzj.decoration.ztest.test1.TestBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> executePost(
            @Url String url,
            @FieldMap Map<String, Object> map);

    @GET()
    Observable<ResponseBody> executeGet(
            @Url String url,
            @QueryMap Map<String, Object> map);
    /**
     *
     * test
     * 查询ip地址信息的接口
     *
     * @param ip 需查询的ip
     * @return RxJava 对象
     */
    @GET("service/getIpInfo.php")
    Observable<IPHttpResult<TestBean>> executeGet(@Query("ip") String ip);


    /**
     *
     * test
     * 获取public key
     *
     * @return RxJava 对象
     */
    @GET("authorization/getpublickey")
    Observable<BaseResponse> executeGet();


    /**
     *
     * test
     * 获取public key
     *
     * @return RxJava 对象
     */
    @FormUrlEncoded
    @POST("authorization/gettoken")
    Observable<BaseResponse> executeGetToken(@FieldMap Map<String, Object> map);


}
