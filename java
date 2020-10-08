package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Main {

    public static void main(String[]args) throws NoSuchAlgorithmException {
        Thread Potoc = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("Дополнительный поток создан");
                Create('n', 'z');
            }

        });

        Potoc.start();

        Create('a', 'm');
    }

    public static void Create (char b1,char b2)
    {
        String str1 = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad";
        String str2 = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b";
        String str3 = "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f";
        boolean a = true, p = true, g = true;
        for(char i = b1;i<=b2;i++)
        {
            for(char j = 'a';j<='z';j++)
            {
                for(char k = 'a';k<='z';k++)
                {
                    for(char l = 'a';l<='z';l++)
                    {
                        for(char m = 'a';m<='z';m++)
                        {
                            String pass = Character.toString(i)+Character.toString(j)+Character.toString(k)+Character.toString(l)+Character.toString(m);

                            MessageDigest md = null;
                            try {
                                String h_pass = Hassh(pass);
                                if (h_pass.equals(str2)){
                                    System.out.println("Пароль: "+ pass);
                                }
                                if (h_pass.equals(str1)){
                                    System.out.println("Пароль: "+ pass);
                                }
                                if (h_pass.equals(str3)){
                                    System.out.println("Пароль: "+ pass);
                                }
                            } catch (NoSuchAlgorithmException var13){
                                var13.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
    public static String Hassh (String pass) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[]hashInBytes = md.digest(pass.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        String h_pass = sb.toString();
        return h_pass;
    }

