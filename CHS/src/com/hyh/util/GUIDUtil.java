package com.hyh.util;

/**
 * Created by HAO on 2016/5/9.
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class GUIDUtil {
    private final org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(getClass());

    private String valueBeforeMD5 = "";
    private String valueAfterMD5 = "";
    private static Random myRand;
    private static SecureRandom mySecureRand;

    private static String s_id;
    private static final int PAD_BELOW = 0x10;
    private static final int TWO_BYTES = 0xFF;

   /*
    * Static block to take care of one time secureRandom seed.
    * It takes a few seconds to initialize SecureRandom.  You might
    * want to consider removing this static block or replacing
    * it with a "time since first loaded" seed to reduce this time.
    * This block will run only once per JVM instance.
      */

    static {
        mySecureRand = new SecureRandom();
        long secureInitializer = mySecureRand.nextLong();
        myRand = new Random(secureInitializer);
        try {
            s_id = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


    /*
     * Default constructor.  With no specification of security option,
     * this constructor defaults to lower security, high performance.
     */
    public GUIDUtil() {
        getRandomGUID(false);
    }

    /*
     * Constructor with security option.  Setting secure true
     * enables each random number generated to be cryptographically
     * strong.  Secure false defaults to the standard Random function seeded
     * with a single cryptographically strong random number.
     */
    public GUIDUtil(boolean secure) {
        getRandomGUID(secure);
    }

    /*
     * Method to generate the random GUID
     */
    private void getRandomGUID(boolean secure) {
        MessageDigest md5 = null;
        StringBuffer sbValueBeforeMD5 = new StringBuffer(128);

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error: " + e);
        }

        try {
            long time = System.currentTimeMillis();
            long rand = 0;

            if (secure) {
                rand = mySecureRand.nextLong();
            } else {
                rand = myRand.nextLong();
            }
            sbValueBeforeMD5.append(s_id);
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(time));
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(rand));

            valueBeforeMD5 = sbValueBeforeMD5.toString();
            md5.update(valueBeforeMD5.getBytes());

            byte[] array = md5.digest();
            StringBuffer sb = new StringBuffer(32);
            for (int j = 0; j < array.length; ++j) {
                int b = array[j] & TWO_BYTES;
                if (b < PAD_BELOW)
                    sb.append('0');
                sb.append(Integer.toHexString(b));
            }

            valueAfterMD5 = sb.toString();

        } catch (Exception e) {
            logger.error("Error:" + e);
        }
    }

    public String getValueAfterMD5() {
        return valueAfterMD5;
    }

    public String getValueBeforeMD5() {
        return valueBeforeMD5;
    }

    /*
         * Convert to the standard format for GUID
         * (Useful for SQL Server UniqueIdentifiers, etc.)
         * Example: C2FEEEAC-CFCD-11D1-8B05-00600806D9B6
         */
    public String toString() {
        String raw = valueAfterMD5.toUpperCase();
        StringBuffer sb = new StringBuffer(64);
        sb.append(raw.substring(0, 8));
        sb.append("-");
        sb.append(raw.substring(8, 12));
        sb.append("-");
        sb.append(raw.substring(12, 16));
        sb.append("-");
        sb.append(raw.substring(16, 20));
        sb.append("-");
        sb.append(raw.substring(20));

        return sb.toString();
    }


    // Demonstraton and self test of class
    public static void main(String args[]) {
        for (int i=0; i< 100; i++) {
            GUIDUtil myGUID = new GUIDUtil();
            System.out.println("Seeding String=" + myGUID.getValueAfterMD5());
//            System.out.println("rawGUID=" + myGUID.getValueBeforeMD5());
//            System.out.println("RandomGUID=" + myGUID.toString());
        }
    }


}
