package osHibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "lecture_with_teacher", schema = "online_school")
public class LectureWithTeacherEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lecture_with_teacher_id", nullable = false)
    private int lectureWithTeacherId;
    @Basic
    @Column(name = "lecture_id", nullable = true)
    private Integer lectureId;
    @Basic
    @Column(name = "person_id", nullable = true)
    private Integer personId;

    public int getLectureWithTeacherId() {
        return lectureWithTeacherId;
    }

    public void setLectureWithTeacherId(int lectureWithTeacherId) {
        this.lectureWithTeacherId = lectureWithTeacherId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
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
        LectureWithTeacherEntity that = (LectureWithTeacherEntity) o;
        return lectureWithTeacherId == that.lectureWithTeacherId && Objects.equals(lectureId, that.lectureId) && Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureWithTeacherId, lectureId, personId);
    }

    @Override
    public String toString() {
        return "LectureWithTeacherEntity{" +
                "lectureWithTeacherId=" + lectureWithTeacherId +
                ", lectureId=" + lectureId +
                ", personId=" + personId +
                '}';
    }
}
