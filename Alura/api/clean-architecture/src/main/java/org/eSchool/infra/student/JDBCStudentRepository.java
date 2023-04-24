package org.eSchool.infra.student;

import org.eSchool.domain.student.Student;
import org.eSchool.domain.student.StudentRepository;
import org.eSchool.domain.student.exceptions.StudentNotFound;
import org.eSchool.domain.student.values.CPF;
import org.eSchool.domain.student.values.Email;
import org.eSchool.domain.student.values.PhoneNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCStudentRepository implements StudentRepository {

    private final Connection conn;

    public JDBCStudentRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void enroll(Student student) {
        try{
            String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO PHONE VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            for(PhoneNumber phoneNumber : student.getPhoneNumbers()){
                ps.setString(1, student.getCpf());
                ps.setString(2, phoneNumber.getDdd());
                ps.setString(3, phoneNumber.getNumber());
                ps.execute();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCpf(CPF cpf) {
        try{
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf.getValue());
            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            if(!found){
                throw new StudentNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student student = new Student(name, cpf, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM PHONE WHERE cpf = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            rs = ps.executeQuery();
            while(rs.next()){
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                student.addPhoneNumber(new PhoneNumber(ddd, number));
            }
            return student;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return null;
    }
}
