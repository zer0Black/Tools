

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

import sun.rmi.runtime.Log;

/**
 *  字符串工具类
 * @author zer0
 * @version 1.0
 * @date 2015-7-01
 */

public class StringTool {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return boolean
	 * @author zer0
	 * @version 1.0
	 *	@date 2015-7-01
	 */
	public static boolean isBlank(String str){
		if(str==null){
			return true;
		}
		if(str.trim().length()<1){
			return true;
		}
		
		if(str.trim().equals("")){
			return true;
		}
		
		if(str.trim().toLowerCase().equals("null")){
			return true;
		}
		return false;
	}
	
	/**
	 * 将字符串转换为byte数组
	 * @param string
	 * @return byte[]
	 * @author  zer0
	 * @version 1.0
	 * @date 2015-7-01
	 */
	public static byte[] stringToByte(String string) {
		if (string == null) {
			return new byte[0];
		}
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(byteOut);
		try {
			dos.writeUTF(string);
		} catch (IOException e) {
			return new byte[0];
		}
		return byteOut.toByteArray();
	}
	
	/**
	 * 随机生成字符串
	 * @param length
	 * @return String类型</br>
	 * 随机字符串
	 * @author zer0
	 * @version 1.0
	 * @date 2015-7-01
	 */
	 public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	 }
	 
	 /**
	 * 清除空格和空行
	 * 
	 * @param value
	 * @return String
	 * @author zer0
	 * @version 1.0
	 * @date 2015-8-27
	 */
	public static String clearSpaceAndLine(String value) {
	    String result = value.replaceAll("\\s+", "");
	    return result;
	}

	/**
	 * 按某个特定符号分隔字符串
	 * 
	 * @param value
	 * @param separator
	 * @return String
	 * @author zer0
	 * @version 1.0
	 * @date 2015-9-2
	 */
	public static List<String> spliteString(String value, String separator) {
	    if (value == null) {
	        return null;
	    }
	    String[] strArray = null;
	    strArray = value.split(separator); // 拆分字符为"," ,然后把结果交给数组strArray
	    return Arrays.asList(strArray);
	}

	/**
	 * 判读字符串是否是数字
	 * 
	 * @param str
	 * @return boolean
	 * @author zer0
	 * @version 1.0
	 * @date 2015-9-6
	 */
	public static boolean isNumeric(String str) {
	    if (str.matches("^-?\\d+$") || str.matches("^(-?\\d+)(\\.\\d+)?$")) {
		return true;
	    } else {
		return false;
	    }
	}

	/**
	 * 把字符串进行MD5加密
	 * 
	 * @param s 要散列的字符串
	 * @return String
	 * @author lixuetao
	 * @version 1.0
	 * @date 2015-9-9
	 */
	public final static String MD5(String s) {
	    char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
	    try {
		byte[] btInput = s.getBytes();
		// 获得MD5摘要算法的 MessageDigest 对象
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		// 使用指定的字节更新摘要
		mdInst.update(btInput);
		// 获得密文
		byte[] md = mdInst.digest();
		// 把密文转换成十六进制的字符串形式
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
		    byte byte0 = md[i];
		    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
		    str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str).toLowerCase();
	    } catch (Exception e) {
		e.printStackTrace();
		return null;
	    }
	}
}
