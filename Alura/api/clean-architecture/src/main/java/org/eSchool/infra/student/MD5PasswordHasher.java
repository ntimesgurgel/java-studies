package org.eSchool.infra.student;

import org.eSchool.domain.student.PasswordHasher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordHasher implements PasswordHasher {
    @Override
    public String hashPassword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < bytes.length; i++){
                sb.append(
                        Integer.toString(
                                (bytes[i] & 0xff) + 0x100,1
                        )
                );
            }

            return sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            throw new RuntimeException("generation error");
        }
    }

    @Override
    public boolean validateHashedPassword(String HashedPassword, String password) {
        return HashedPassword.equals(hashPassword(password));
    }
}
