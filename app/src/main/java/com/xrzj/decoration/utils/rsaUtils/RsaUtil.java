package com.xrzj.decoration.utils.rsaUtils;


import android.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;





/**
 * RSA加密工具类
 * 
 * @author xiaolang
 * @since 2018.3.9
 */
@SuppressWarnings("restriction")
public class RsaUtil {
	/**
	 * 公钥加密
	 * @param content 需要加密的message字节
	 * @param publicKey 公钥对象
	 * @return byte[] 加密后的数据 
	 * @throws Exception 加密失败
	 */
	public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bytes = cipher.doFinal(content);
		return bytes;
	}

	/**
	 * // 私钥解密
	 * @param content 需要解密的密文
	 * @param privateKey 私钥对象
	 * @return byte[] 解密后的字节
	 * @throws Exception 解密失败异常
	 */
	public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bytes = cipher.doFinal(content);
		return bytes;
	}

	public static String getBase64(String str) {
		String result = "";
		if( str != null) {
			try {
				result = new String(Base64.encode(str.getBytes("utf-8"), Base64.DEFAULT),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 字节数组转Base64编码
	 * @param bytes 需要转换的字节数组
	 * @return String 转换后64编码
	 */
	public static String byte2Base64(byte[] bytes) {
		return Base64.encodeToString(bytes,Base64.DEFAULT);
	}

	/**
	 * Base64编码转字节数组
	 * @param base64Key Base64编码
	 * @return byte[] 转换后的base64Key
	 * @throws IOException
	 */
	public static byte[] base642Byte(String base64Key) throws IOException {
		return Base64.decode(base64Key,Base64.DEFAULT);
	}


	/**
	 *
	 * @param pubStr base64编码后的公钥
	 * @return PublicKey
	 * @throws Exception
	 */
	public static PublicKey string2PublicKey(String pubStr) throws Exception {
		byte[] keyBytes = base642Byte(pubStr);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

}
