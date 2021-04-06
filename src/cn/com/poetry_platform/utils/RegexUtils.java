package cn.com.poetry_platform.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 正则表达式工具类
 * 
 * @author Sinoyang
 * 
 */
public class RegexUtils {

	/**
	 * 是否是ID
	 * 
	 * @param id
	 *            要测试的ID
	 * @return 测试结果
	 */
	public static boolean isId(String id) {

		if (StringUtils.isEmpty(id)) {
			return false;
		}

		return StringUtils.isNumeric(id);
	}

	/**
	 * 是否为数字
	 * 
	 * @param number
	 *            要测试的数字
	 * @return 测试结果
	 */
	public static boolean isNumber(String number) {

		if (StringUtils.isEmpty(number)) {
			return false;
		}

		return Pattern.matches("^(\\+|\\-)?\\d+$", number);
	}

	/**
	 * 是否为正整数
	 * 
	 * @param number
	 *            要测试的数字
	 * @return 测试结果
	 */
	public static boolean isPositiveInteger(String number) {

		if (StringUtils.isEmpty(number)) {
			return false;
		}

		return Pattern.matches("^(\\+)?\\d+$", number);
	}

	/**
	 * 从字符串中提取全部数字。 1,2,3,4 5，3}24324
	 * 
	 * @return
	 */
	public static List<Integer> extractNumberFromString(String str) {

		List<Integer> numbers = new ArrayList<Integer>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String no = matcher.group();
			if (StringUtils.isNotEmpty(no)) {
				numbers.add(Integer.parseInt(no));
			}
		}

		return numbers;
	}

	/**
	 * 测试结果。
	 * 
	 * @param pattern
	 *            测试的正则表达式
	 * @param string
	 *            要测试的字符串。
	 * @return
	 */
	public static boolean test(String pattern, String string) {

		if (pattern == null || string == null) {
			return false;
		}

		return Pattern.matches(pattern, string);
	}

	/**
	 * 解析html的
	 * <tr>
	 * 元素
	 * 
	 * @param html
	 * @return
	 */
	public static List<String> paserTRHtml(String html) {

		List<String> trs = new ArrayList<String>();
		Pattern pattern = Pattern.compile("<tr>(.*?)</tr>");
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String tr = matcher.group();
			trs.add(tr);
		}

		return trs;
	}

	/**
	 * 解析html的 <td>
	 * 元素
	 * 
	 * @param html
	 * @return
	 */
	public static List<String> paserTDHtml(String html) {

		List<String> tds = new ArrayList<String>();
		Pattern pattern = Pattern.compile("<td (\\w+=\\S+)*>(.*?)</td>");
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String td = matcher.group();
			tds.add(td);
		}

		return tds;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		return Pattern.matches(ConfigFactory.getString("regex.email"), email);
	}

	public static void main(String[] args) {

		/*
		 * System.out.println(isPositiveInteger("0"));
		 * System.out.println(isPositiveInteger("10"));
		 * System.out.println(isPositiveInteger("+10"));
		 * System.out.println(isPositiveInteger("+1.0"));
		 * System.out.println(isPositiveInteger("-10"));
		 */
		// System.out.println(extractNumberFromString("1,2,3,4 5，3}24324"));
		// System.out.println(extractNumberFromString("八十八，九十九"));
		// System.out.println(StringUtils.isNumeric("10"));
		// System.out.println("/aaaa".split("/").length);

		System.out.println(Pattern.matches("^(\\w+\\.)?\\w+@\\w+\\.\\w+$", "aa.aa@aa.aa"));
		System.out.println(Pattern.matches("^(\\w+\\.)?\\w+@\\w+\\.\\w+$", "aa@aa.aa"));
		System.out.println(Pattern.matches("^(\\w+\\.)?\\w+@\\w+\\.\\w+$", "aa_aa@aa.aa"));
	}
}