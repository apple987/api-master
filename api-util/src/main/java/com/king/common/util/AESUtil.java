package com.king.common.util;

/**
 * AES加密啊解密工具类
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.security.Key;  
import org.apache.shiro.codec.Hex;  
import org.apache.shiro.crypto.AesCipherService; 

public class AESUtil {

	public static void main(String[] args) {
		// 密钥的种子，可以是任何形式，本质是字节数组
		String strKey = "lttclaw";
		// 密钥数据
		byte[] rawKey = getRawKey(strKey.getBytes());
		// 密码的明文
		String clearPwd = "apple9527";
		// 密码加密后的密文
		byte[] encryptedByteArr = encrypt(rawKey, clearPwd);
		String encryptedPwd = new String(encryptedByteArr);
		System.out.println(encryptedPwd);
		// 解密后的字符串
		String decryptedPwd = decrypt(encryptedByteArr, rawKey);
		System.out.println(decryptedPwd);
		
		System.err.println("加密结果:"+new String(encode("rain!@#softs", "apple9527")));
		System.err.println("解密结果:"+decode("rain!@#softs",encode("rain!@#softs", "apple9527")));

		AesCipherService aesCipherService = new AesCipherService();    
        aesCipherService.setKeySize(128); //设置key长度    
        //生成key    
        Key key = aesCipherService.generateNewKey();  
        System.out.println("key = " + key);  
        String text = "AesEncoding";    
        //加密    
        String encrptText =  aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();    
        //解密    
        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());  
        System.err.println("采用shiro使用DES原始值 : " + text);  
        System.err.println("采用shiro使用DES加密值 : " + encrptText);  
        System.err.println("采用shiro使用DES解密值 : " + text2);  
	
	
	}

	/**
	 * @param rawKey
	 *            密钥
	 * @param clearPwd
	 *            明文字符串
	 * @return 密文字节数组
	 */
	private static byte[] encrypt(byte[] rawKey, String clearPwd) {
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(rawKey, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encypted = cipher.doFinal(clearPwd.getBytes());
			return encypted;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param encrypted
	 *            密文字节数组
	 * @param rawKey
	 *            密钥
	 * @return 解密后的字符串
	 */
	private static String decrypt(byte[] encrypted, byte[] rawKey) {
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(rawKey, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] decrypted = cipher.doFinal(encrypted);
			return new String(decrypted);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * @param seed种子数据
	 * @return 密钥数据
	 */
	private static byte[] getRawKey(byte[] seed) {
		byte[] rawKey = null;
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
			//AES加密数据块分组长度必须为128比特，密钥长度可以是128比特、192比特、256比特中的任意一个
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			rawKey = secretKey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
		}
		return rawKey;
	}

	/**
	 * AES加密算法
	 * @param key:加密的原始key
	 * @param source:待加密原始字符串
	 * @return:加密后的字节数组
	 */
	public static byte[] encode(String key,String source){
		return encrypt(getRawKey(key.getBytes()), source);
    }
	/**
	 * AES解密算法
	 * @param key:加密原始key
	 * @param encodeByteArr：待解密的原始数组(源字符串加密之后的字节数组)
	 * @return:解密后的字符串
	 */
	public static String decode(String key,byte[] encodeByteArr){
		return decrypt(encodeByteArr, getRawKey(key.getBytes()));
	}
}