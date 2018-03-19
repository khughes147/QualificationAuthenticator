package com.example.QualificationAuthenticator;


import java.security.MessageDigest;
import java.util.UUID;

public class University {



    private String email;
    private String uniName;
    private String adminName;
    private String contactNumber;
    private boolean verified = false;
    private String key;
    private String privateKey;

    public String getContactNumber() { return contactNumber; }

    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

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

    public boolean isVerified(){ return verified;}

    public void setVerified(Boolean verified) { this.verified = verified;}

    public String getPrivateKey() { return privateKey; }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public void generateKey(){

        privateKey = UUID.randomUUID().toString();

        try{
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(privateKey.getBytes("UTF-8"));
            String digest = bytesToHex(salt.digest());
            this.key = digest;
        }catch(Exception noSuchAlgorithmException){
        }

    }

    public static String bytesToHex(byte[] bytes) {
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
