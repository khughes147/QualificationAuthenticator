package com.example.QualificationAuthenticator;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.security.MessageDigest;
import java.util.UUID;

public class University {



    private String email;
    private String uniName;
    private String adminName;
    private String key;

    public String getEmail() { return email; }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUniName(){
        return uniName;
    }

    public void setUniName(String uniName){
        this.uniName = uniName;
    }

    public String getAdminName(){
        return adminName;
    }

    public void setAdminName(String adminName){
        this.adminName = adminName;
    }

    public String getKey(){
        return key;
    }

    public void generateKey(){

        try{
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
            String digest = bytesToHex(salt.digest());
            this.key = digest;
        }catch(Exception noSuchAlgorithmException){
        }



    }

    private static String bytesToHex(byte[] bytes) {
        final char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
