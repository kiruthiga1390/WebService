package uw.edu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {

	public static String getHash(String input) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] inputHash = md.digest(input.getBytes());
		
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < inputHash.length; ++i) {
          sb.append(Integer.toHexString((inputHash[i] & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
	}
}
