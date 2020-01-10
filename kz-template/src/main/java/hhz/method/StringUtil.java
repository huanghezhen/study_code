package hhz.method;

import hhz.config.Config;

/**
 * @ClassName: StringUtil
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2020/1/9 15:26
 */
public class StringUtil
{
    public static String removePrefix(String tableName)
    {
        String tableRemovePrefixes = Config.init.getTableRemovePrefixes();
        String temp = tableName;
        for (String pf : tableRemovePrefixes.split(","))
        {
            temp = StringUtil.removePrefixSub(temp, pf);
        }
        return camelCaseName(temp);
    }

    public static String removePrefixSub(String name, String pf)
    {
        if (name.startsWith(pf))
        {
            name = name.substring(pf.length());
        }
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    public static String camelCaseName(String underscoreName)
    {
        StringBuilder result = new StringBuilder();
        if (underscoreName != null && underscoreName.length() > 0)
        {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++)
            {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch)
                {
                    flag = true;
                }
                else
                {
                    if (flag)
                    {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    }
                    else
                    {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}
