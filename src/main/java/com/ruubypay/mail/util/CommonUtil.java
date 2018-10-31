package com.ruubypay.mail.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/10/30 下午7:59
 */
public class CommonUtil {

	/**
	 * 获取超时空的唯一编号
	 * @return
	 */
	public static String getOnlyOneNo(){
		StringBuffer sb = new StringBuffer();
		sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		sb.append(String.format("%04d",Sequence.getNextIndex()));
		return sb.toString();
	}
}
