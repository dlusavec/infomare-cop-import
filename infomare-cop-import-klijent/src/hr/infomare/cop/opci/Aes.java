package hr.infomare.cop.opci;

import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.*;
import java.io.InputStreamReader;

import java.net.Inet6Address;
import java.net.InetAddress;

import java.net.NetworkInterface;

import java.net.SocketException;
import java.net.UnknownHostException;

import java.security.*;
import java.security.spec.InvalidKeySpecException;

import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;


import sun.misc.*;

public class Aes {
    
    public Aes() {
        super();
    }
    
    public static String getMotherboardSN() {
    String result = "";
      try {
        File file = File.createTempFile("tmb",".vbs");
        file.deleteOnExit();
        FileWriter fw = new java.io.FileWriter(file);

        String vbs =
           "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
          + "Set colItems = objWMIService.ExecQuery _ \n"
          + "   (\"Select * from Win32_BaseBoard\") \n"
          + "For Each objItem in colItems \n"
          + "    Wscript.Echo objItem.SerialNumber \n"
          + "    exit for  ' do the first cpu only! \n"
          + "Next \n";

        fw.write(vbs);
        fw.close();
        Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
        BufferedReader input =
          new BufferedReader
            (new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
           result += line;
        }
        input.close();
      }
      catch(Exception e){
          e.printStackTrace();
      }
      return result.trim();
    }

    
    private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        (Aes.getMotherboardSN()+"f$%vT345cm#df34s").substring(0,16).getBytes();
        
        
    public static String encrypt(String Data) throws Exception {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(Data.getBytes());
            String encryptedValue = new BASE64Encoder().encode(encVal);
            return encryptedValue;
        }

    public static String decrypt(String encryptedData) throws Exception {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
            byte[] decValue = c.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            return decryptedValue;
        }
    
    private static Key generateKey() throws Exception {
            Key key = new SecretKeySpec(keyValue, ALGO);
            return key;
    }

    

}
