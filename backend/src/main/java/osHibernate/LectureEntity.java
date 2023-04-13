package osHibernate;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lecture", schema = "online_school")
public class LectureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lecture_id", nullable = false)
    private int lectureId;
    @Basic
    @Column(name = "name", nullable = true, length = 200)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 400)
    private String description;
    @Basic
    @Column(name = "creation_date", nullable = true)
    private Timestamp creationDate;
    @Basic
    @Column(name = "course_id", nullable = true)
    private Integer courseId;
    @Basic
    @Column(name = "lecture_date", nullable = true)
    private Timestamp lectureDate;
    @Transient
    private int amCount;

    public int getAmCount() {
        return amCount;
    }

    public void setAmCount(int amCount) {
        this.amCount = amCount;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Timestamp getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(Timestamp lectureDate) {
        this.lectureDate = lectureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureEntity that = (LectureEntity) o;
        return lectureId == that.lectureId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(creationDate, that.creationDate) && Objects.equals(courseId, that.courseId) && Objects.equals(lectureDate, that.lectureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureId, name, description, creationDate, courseId, lectureDate);
    }

    @Override
    public String toString() {
        return "LectureEntity{" +
                "lectureId=" + lectureId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", courseId=" + courseId +
                ", lectureDate=" + lectureDate +
                '}';
    }



}
