package com.ubosque.edu.co.progll.util;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class Security {
	public static String computeHash(String str) {
		return Hashing.sha256()
				  .hashString(str, StandardCharsets.UTF_8)
				  .toString();
	}
}
