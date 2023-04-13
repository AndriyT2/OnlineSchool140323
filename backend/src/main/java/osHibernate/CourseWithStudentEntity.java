package osHibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "course_with_student", schema = "online_school")
public class CourseWithStudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_with_student_id", nullable = false)
    private int courseWithStudentId;
    @Basic
    @Column(name = "course_id", nullable = true)
    private Integer courseId;
    @Basic
    @Column(name = "person_id", nullable = true)
    private Integer personId;

    public int getCourseWithStudentId() {
        return courseWithStudentId;
    }

    public void setCourseWithStudentId(int courseWithStudentId) {
        this.courseWithStudentId = courseWithStudentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseWithStudentEntity that = (CourseWithStudentEntity) o;
        return courseWithStudentId == that.courseWithStudentId && Objects.equals(courseId, that.courseId) && Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseWithStudentId, courseId, personId);
    }

    @Override
    public String toString() {
        return "CourseWithStudentEntity{" +
                "courseWithStudentId=" + courseWithStudentId +
                ", courseId=" + courseId +
                ", personId=" + personId +
                '}';
    }
}
