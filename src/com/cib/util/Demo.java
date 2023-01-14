package com.cib.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Demo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		String ss= ".1$2$3$4$5$6.";
		String[] s = ss.split("[$]");
		//for(int i=0;i<s.length;i++){
		//	System.out.println(s[i]);
		//	System.out.println(s[i]);
		//}
		//File file = new File("c:/desc_upload_file.txt");
		//File file = new File("D:/Eclipse/MyEclipse/plugin/MyEclipse/WorkSpace/cdseweb/cdseed/DATA_FILE/ASC_SPOTCHK_3_3_.TXT");
		//File file = new File("D:/Eclipse/MyEclipse/plugin/MyEclipse/WorkSpace/cdseweb/cdseed/DATA_FILE/ASC_SPOTCHK_3_3_20001212.TXT");
		File file = new File("C:/demo.TXT");
		//System.out.println(file.length());
		//System.out.println(file.exists());
		//file.createNewFile();
		//System.out.println(file.exists());
		//System.out.println(Integer.parseInt("0036"));
		//String[] sss = new String[]{"a","b","c","d","e"};
		//String sss = "wee=eq=w=e";
		//System.out.println(sss.contains("="));
		//System.out.println(sss.replace("=", "等于"));
		
		//List list = new ArrayList();
		//list.add("a");
		//list.add("b");
		//list.add("1");
		//list.add("c");
		//list.add("d");
		//list.add("e");
		//list.add("f");
		//list.add("g");
		//for(int i=0;i<list.size();i++){
			//System.out.println(list.get(i));
		//}
		//System.out.println(new Date().getTime());
		
		//int totalCount = 429000 ;
		//int pageCount = 0;
		//if(totalCount%10000!=0){
		//	pageCount = totalCount/10000+1;
		//}else{
		//	pageCount = totalCount/10000;
		//}
		//int begin = 1,end = 10000;
		//for(int i=1;i<=pageCount;i++){
		//	if(i>1){                                     //下标分页算法
		//		begin = end+1;
		//		end = i*10000;
		//	}
			//System.out.println(begin+"----->"+end);
		//}
		//System.out.println(12/5);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String[] a = {"hello"};
//		for(int i=100000;i<182000;i++){
//			StringBuffer lineBuf = new StringBuffer();
//			String istr = String.valueOf(i);
//			lineBuf.append("0001gdbcdse"+istr+"   601gdbcdse"+istr+"   30000000000000000000000000000000000000000000000000000000000000000000000002010033020100402                                                                       000000   ");
//			 
//			//bw.write(lineBuf.toString());
//			//bw.newLine();
//			//bw.flush();
//		}
//		bw.close();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dt = sdf.parse("2010-03-31 16:15:14");
		sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		//System.out.println(sdf.format(dt));
		//System.out.println((int)(Math.random()*Math.random())*10);
		String sss= "123";
		//System.out.println("sss="+sss.substring(0, sss.length()-2));
		//System.out.println("sss="+Calendar.getInstance().getTime());
		
		try{
		//String path="D:\\Eclipse\\MyEclipse\\plugin\\MyEclipse\\WorkSpace\\cdseweb\\cdseed\\Upload";
		//File file = new File(path,"UPLOAD_14_32_03_20100307.TXT");
		//file.createTempFile(path,"UPLOAD_14_32_03_20100307.TXT",file);
		}catch(Exception e){
			System.out.println(e);
		}
		String[] str = {"1","2","3"}; 
		System.out.println(str);
		Map map = new HashMap();
		map.put("id", "1");
		map.put("name", "'zhaoxiao'");
		map.put("age", "25");
		map.put("sex", "'男'");
		Iterator it = map.entrySet().iterator();  

    	StringBuffer setvalue = new StringBuffer("");
		while (it.hasNext()){     
			Map.Entry entry = (Map.Entry)it.next();     
			String key = (String)entry.getKey();     
			String value = (String)entry.getValue();
			if(setvalue.length()==0){
				setvalue.append(key+"="+value);
			}else{
				setvalue.append(","+key+"="+value);
			}
		}
		System.out.println(setvalue.length()+"==="+setvalue.toString());

	}
	
	/**
     * 判断文件是否存在
     * @return boolean
     */
    public boolean isFileExists(String filePath) {
        boolean result = false;
        File tmpFile;
		try {
            tmpFile = new File(filePath);
            if (tmpFile.exists()) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tmpFile = null;
        }
        return result;
    }
}
