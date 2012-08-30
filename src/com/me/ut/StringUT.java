package com.me.ut;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.servlet.ModelAndView;


public class StringUT
{

    

    /**
     * D:/tomcat6/webapps/v/WEB-INF/classes/uploadFiles/13e53d
     * b657ab419c876413024f54f389/
     * 
     * @param requestid
     * @return
     */
    public static String getUploadFiles(String requestid)
    {
        return WebPath.getClassRootPath() + "uploadFiles/" + requestid + "/";
    }


    /**
     * 返回文件路径--包含字段名称--以/结尾
     * 
     * @param files
     * @param fieldName
     * @return
     */
    public static String getUploadFilesPath(String files,
                                            String fieldName)
    {
        String path = getUploadFiles(files) + fieldName + "/";
        return path;
    }


    /**
     * 
     * @param queryin
     *            =assessYear=2011&requestid1=db5348b94ff84e2bad408bf809850f2c&
     *            authorizeNum
     *            =101&validEndDate=2012-01-02&ID=basicinfo_id&validBeginDate
     *            =%E4%B8%AD%E6%96%87%E6%B5%8B%E8%AF%95
     * @return
     */
    public static Map<String, String> url2Map(String queryin)
    {
        Map<String, String> map = new HashMap<String, String>();
        if (queryin == null || queryin.trim().length() == 0)
        {
            return map;
        }

        // 先拆开 ，再decode
        String[] arr = queryin.split("&");
        for (int i = 0; i < arr.length; i++)
        {
            if (StringUT.isEmpty(arr[i]))
            {
                continue;
            }

            String[] item = arr[i].toString().split("=");
            if (item.length != 2)//等于1的情况
            {
                map.put(item[0],"");
            }
            else
            {
                try
                {
                    map.put(item[0],
                            URLDecoder.decode(item[1],
                                              "UTF-8"));
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
            }
            
        }
        return map;
    }


    /**
     * 返回路劲是：C:/tomcat6/webapps/v/WEB-INF/classes/uploadFiles/
     * 
     * @return
     */
    public static String getUploadFiles()
    {
        return WebPath.getClassRootPath() + "uploadFiles/";
    }


    public static void print(Object err)
    {
        String str = "";
        if (err != null)
        {
            str = err.toString();
        }
        System.err.println("\r\n---------------\r\n" + str + "\r\n---------------");
    }




    public static void printErr(List list)
    {
        if (list != null && list.size() > 0)
        {
            System.err.println("\r\n---------------");
            for (int i = 0; i < list.size(); i++)
            {
                System.err.print("[" + list.get(i) + "]  ");
            }
            System.err.println("\r\n---------------");
        }
        else
        {
            System.err.println("\r\n---------------\r\n" + null + "\r\n---------------");

        }
    }


    public static void printErr(String str)
    {
        if (str != null)
        {
            System.err.println("\r\n---------------\r\n" + str + "\r\n---------------");
        }
    }


    /**
     * 取得32 位UUID(不含有-)
     * 
     * @return
     */
    public static String getUUID()
    {
        return UUID.randomUUID().toString().replace("-",
                                                    "");
    }


    private static String errDesc = "";
    static
    {
        errDesc = "";// 每次进入该类的时候都清空该变量
    }



    /**
     * 
     * 接受的参数类型可以是 8种基本数据类型,List,Map
     * 
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj)
    {
        if (obj == null)
            return true;

        if (obj instanceof StringBuilder)
        {
            obj = ((StringBuilder) obj).toString();
        }

        if (obj instanceof String)
        {
            return ((String) obj).trim().length() == 0;
        }

        if (obj.getClass().isArray())
            return Array.getLength(obj) == 0;
        if (obj instanceof Collection<?>)
            return ((Collection<?>) obj).isEmpty();
        if (obj instanceof Map<?, ?>)
            return ((Map<?, ?>) obj).isEmpty();
        return false;
    }


    /**
     * List<String>-->String 中间以,分割 每个字符用单引号包含 <br>
     * sql where not in 用 <br>
     * 'xx','bb','cc'
     * 
     * @return
     */
    public static String convertList2Str(List<String> list)
    {
        if (list == null || list != null && list.size() == 0)
        {
            return "";
        }
        String out = "";

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == null)
            {
                continue;
            }
            if (i == (list.size() - 1))
            {
                out += "'" + list.get(i) + "'";
            }
            else
            {
                out += "'" + list.get(i) + "',";
            }
        }
        return out;
    }


    public static String getV(Map map,
                              String key)
    {
        if (map == null || key == null)
        {
            return null;
        }
        if (StringUT.isEmpty(map.get(key)))
        {
            return null;
        }
        else
        {
            return map.get(key).toString();
        }
    }


    /**
     * 
     * 使用str填充stringBuilder
     * 
     * @param stringBuilder
     * @param str
     */
    public static void fillStringBuilder(StringBuilder stringBuilder,
                                         String str)
    {
        if (stringBuilder == null)
        {
            return;
        }
        stringBuilder = stringBuilder.delete(0,
                                             stringBuilder.toString().length());
        stringBuilder = stringBuilder.append(str);


    }


    public static void main(String[] args)
    {
        StringBuilder stringBuilder = new StringBuilder();
        fillStringBuilder(stringBuilder,
                          "adc");
        System.out.println("1");
        System.out.println(stringBuilder);
        System.out.println("2");
    }



    /**
     * 判断非空的字符串是否是数字
     * 
     * @param text
     * @return
     */
    public static boolean isInt(String text)
    {
        try
        {
            int i = Integer.valueOf(text.trim().toString());
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

}
