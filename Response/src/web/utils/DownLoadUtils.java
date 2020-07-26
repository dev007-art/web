package web.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownLoadUtils {
    public static String getFileName(String agent,String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")){
            //IE浏览器
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+"," ");
        }else if (agent.contains("Firefox")){
            //火狐浏览器
            BASE64Encoder base64Decoder = new BASE64Encoder();
            filename = "=?utf-8?B?"+base64Decoder.encode(filename.getBytes("utf-8"))+"?=";
        }else{
           filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }
}
