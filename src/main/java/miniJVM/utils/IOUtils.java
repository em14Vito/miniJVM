
package miniJVM.utils;
/** 
  * @author  作者 Denny
  * @date 创建时间：Jan 21, 2018 2:48:01 PM 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  */

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;

public class IOUtils {

	final public static int MAX_BUFFER_SIZE = 1024;
	
	/**
	 * 以字节流形式读取文件
	 * @param File
	 * @return Byte[]
	 * @throws Exception
	 */
	public static byte[] readFile(File f) throws Exception{
		FileInputStream stream = new FileInputStream(f);
		BufferedInputStream bufferedStream = new BufferedInputStream(stream);
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] fileBytesTemp = new byte[MAX_BUFFER_SIZE];
				
		try{
			int len = 0;
			while ((len = bufferedStream.read(fileBytesTemp)) != -1) {
				result.write(fileBytesTemp, 0, len);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try{
				stream.close();
				result.flush();
				result.close();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return result.toByteArray();
	}

	
	

}
