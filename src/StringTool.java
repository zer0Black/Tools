

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
}
