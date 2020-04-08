package com.CtechInfoSys.BEAirs.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utility {
	public static String getRandomString(int lenth) {
		String randomString = RandomStringUtils.randomAlphabetic(lenth);
		return randomString;
	}
	public String getRandomNumeric(int lenth) {
		String randomString = RandomStringUtils.randomNumeric(lenth);
		return randomString;
	}

}
