package osHibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "additional_materials", schema = "online_school")
public class AdditionalMaterialsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "additional_materials_id", nullable = false)
    private int additionalMaterialsId;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "resource_type", nullable = false)
    private Object resourceType;
    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = true)
    private  LectureEntity lecture;



    public LectureEntity getLecture() {
        return lecture;
    }

    public void setLecture(LectureEntity lecture) {
        this.lecture = lecture;
    }

    public int getAdditionalMaterialsId() {
        return additionalMaterialsId;
    }

    public void setAdditionalMaterialsId(int additionalMaterialsId) {
        this.additionalMaterialsId = additionalMaterialsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getResourceType() {
        return resourceType;
    }

    public void setResourceType(Object resourceType) {
        this.resourceType = resourceType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalMaterialsEntity that = (AdditionalMaterialsEntity) o;
        return additionalMaterialsId == that.additionalMaterialsId && Objects.equals(name, that.name) && Objects.equals(resourceType, that.resourceType) && Objects.equals(lecture, that.lecture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalMaterialsId, name, resourceType, lecture);
    }

    @Override
    public String toString() {
        return "AdditionalMaterialsEntity{" +
                "additionalMaterialsId=" + additionalMaterialsId +
                ", name='" + name + '\'' +
                ", resourceType=" + resourceType +
                ", lecture=" + lecture +
                '}';
    }
}
