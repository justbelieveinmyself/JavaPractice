package com.justbelieveinmyself.Encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String password = "hello world";

        System.out.println(password);
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = sha1.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : bytes){
            stringBuilder.append(String.format("%02X ", b));
        }
        System.out.println(stringBuilder);
        // CIPHER -> AES
        Cipher cipher = Cipher.getInstance("AES");
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128); // 128 bits
//        SecretKey key = keyGenerator.generateKey();
        SecretKey key = new SecretKeySpec("ABCDE67891123456".getBytes(), "AES"); //LENGTH = 16 bytes = 16 chars = 128 bits OR 256 = 32 chars
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytesAes = cipher.doFinal(password.getBytes());
        for(byte b : bytesAes){
            System.out.print(b);
        }
        System.out.println();
        Cipher cipherDecrypt = Cipher.getInstance("AES");
        cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipherDecrypt.doFinal(bytesAes);
        for(byte b : result){
            System.out.print((char)b);
        }
        System.out.println();
        //RSA public and private keypairs
        Cipher rsa = Cipher.getInstance("RSA");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();
        rsa.init(Cipher.ENCRYPT_MODE, publicKey); // encrypt with publicKey
        byte[] rsaBytes = rsa.doFinal(password.getBytes());
        for(byte b : rsaBytes){
            System.out.print(b);
        }
        System.out.println();
        Cipher rsaDecrypt = Cipher.getInstance("RSA");
        rsaDecrypt.init(Cipher.DECRYPT_MODE, privateKey); //decrypt with privateKey
        byte[] resBytes = rsaDecrypt.doFinal(rsaBytes);
        for(byte b : resBytes){
            System.out.print((char) b);
        }
    }

}
