package osHibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "homework", schema = "online_school")
public class HomeworkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "homework_id", nullable = false)
    private int homeworkId;
    @Basic
    @Column(name = "task", nullable = true, length = 400)
    private String task;
    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = true)
    private LectureEntity lecture;



    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LectureEntity getLecture() {
        return lecture;
    }

    public void setLecture(LectureEntity lecture) {
        this.lecture = lecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkEntity that = (HomeworkEntity) o;
        return homeworkId == that.homeworkId && Objects.equals(task, that.task) && Objects.equals(lecture, that.lecture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeworkId, task, lecture);
    }

    @Override
    public String toString() {
        return "HomeworkEntity{" +
                "homeworkId=" + homeworkId +
                ", task='" + task + '\'' +
                ", lecture=" + lecture +
                '}';
    }
}
