package org.eSchool.domain.student;

public interface PasswordHasher {
    String hashPassword(String password);
    boolean validateHashedPassword(String HashedPassword, String password);
}
