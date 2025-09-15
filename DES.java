//data encryption standard

import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class DES{
public static void main(String[] args) throws Exception{
Scanner sc=new  Scanner(System.in);
System.out.println("enter msg to encrypt");
String msg=sc.nextLine();
byte[] message=msg.getBytes();
//take custom key or prepare key
System.out.print("enter custom key:");
String key=sc.nextLine();
byte[] keyData=key.getBytes();
DESKeySpec secretKey=new DESKeySpec(keyData);
SecretKeyFactory keyFactory =SecretKeyFactory.getInstance("DES");
SecretKey keyN=keyFactory.generateSecret(secretKey);

//ENCRYPTION
Cipher cipher=Cipher.getInstance("DES");
cipher.init(Cipher.ENCRYPT_MODE,keyN);
byte[] encrypted=cipher.doFinal(message);

//DECRYPTION
cipher.init(Cipher.DECRYPT_MODE,keyN);
byte[] decrypted=cipher.doFinal(encrypted);
String decryptedMsg=new String(decrypted);

System.out.println("Message:"+msg);
System.out.println("Encrypted:"+encrypted);
System.out.println("Decrypted:"+decryptedMsg);
}
}