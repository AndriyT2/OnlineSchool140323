package osHibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "course", schema = "online_school")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id", nullable = false)
    private int courseId;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;



    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return courseId == that.courseId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, name);
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                '}';
    }
}
