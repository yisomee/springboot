package com.example.test.service.common;

import java.nio.charset.Charset;
import java.util.Random;

public class GenerateKey implements GenerateKeyImpl{
    Random rnd =new Random();
    StringBuffer buf =new StringBuffer();

    @Override
    public String getGenerateKey() {
      
        for(int i=0;i<20;i++){
            // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
            if(rnd.nextBoolean()){
                // buf.append((char)((int)(rnd.nextInt(26))+97));
                boolean flag = true;
                char addWord = 'A';
                while(flag){ 
                    //랜덤문자 생성
                    addWord = (char)((int)(rnd.nextInt(58))+65);     
                    //특수문자면 true 아니면 false 로 while문 탈출          
                    flag = isGenerateKey(addWord);
                }
                //buf에 알파벳 추가
                buf.append(addWord);
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf.toString();
    }

    @Override
    public boolean isGenerateKey(char addWord) {
        if(90<(int)addWord && (int)addWord< 97){//특수문자 일 때
            return true;
        }else{
            return false;
        }
    }

    public String getRandomString(int i) { 
        byte[] bytearray;
        bytearray = new byte[256];         
        String mystring;
        StringBuffer thebuffer;
        String theAlphaNumericS;

        new Random().nextBytes(bytearray); 

        mystring 
            = new String(bytearray, Charset.forName("UTF-8")); 
            
        thebuffer = new StringBuffer();
        
        //remove all spacial char 
        theAlphaNumericS 
            = mystring 
                .replaceAll("[^A-Z0-9]", ""); 

        //random selection
        for (int m = 0; m < theAlphaNumericS.length(); m++) { 

            if (Character.isLetter(theAlphaNumericS.charAt(m)) 
                    && (i > 0) 
                || Character.isDigit(theAlphaNumericS.charAt(m)) 
                    && (i > 0)) { 

                thebuffer.append(theAlphaNumericS.charAt(m)); 
                i--; 
            } 
        } 

        // the resulting string 
        return thebuffer.toString(); 
    
    } 
    /*정규식 사용 예제
    1. 숫자만
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
    String str = "123456a";
    Pattern pattern = Pattern.compile("^[0-9]*$");
    Matcher matcher = pattern.matcher(str);
                    
    if(matcher.find()) {
        System.out.println(Integer.parseInt(str));
    } else {
        System.out.println("숫자가 아닌 값이 포함되어 있습니다. ");
    }

    */        
}




    