package miniJVM.loader;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import miniJVM.utils.IOUtils;

/** 
 * @author  作者 Denny
 * @date 创建时间：Jan 21, 2018 1:49:45 PM 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  */

public class ClassFileLoader {

	private ArrayList<String> clzPaths = new ArrayList<String>();
	private Logger logger = LoggerFactory.getLogger(ClassFileLoader.class); 

	public byte[] readBinaryCode(String className) {
		className = className.replace('.', File.separatorChar) +".class";

		for(String path : this.clzPaths){
			String clzFileAbsPath = path + File.separatorChar + className;
			byte[] codes = null;
			try {
				codes = IOUtils.readFile(new File(clzFileAbsPath));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(codes != null){
				return codes;
			}			
		}
		return null;
	}

	public void addClassPath(String path) {
		if (this.clzPaths.contains(path)) {
			return;
		}
		this.clzPaths.add(path);
	}



	public String getClassPath(){
		return StringUtils.join(clzPaths,";");
	}





}
