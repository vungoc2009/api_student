package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name ="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "STUDENT_SEQ")
    @SequenceGenerator(name ="STUDENT_SEQ", sequenceName = "STUDENT_SEQ" ,allocationSize = 1)
    private int id;

    @Column(name ="full_name")
    private String fullName;

    @Column(name ="birthday")
    private Date birthday;

    @Column(name ="class_name")
    private String className;

    @Column(name ="major")
    private String major;

    @Column(name ="hometown")
    private String hometown;

    @Column(name ="gender")
    private String gender;

    @Column(name ="average_mark")
    private float averageMark;
}
