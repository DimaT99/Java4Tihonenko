package entity;

import java.io.Serializable;
import java.util.Objects;

public class Additional implements Comparable<Additional>, Serializable {
    private static int count;
    private Integer id;
    private String name;
    private int lectureId;
    private ResourceType resourceType;

    public Additional() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Additional(Integer id, String name, int lectureId, ResourceType resourceType) {
        this.id = id;
        this.name = name;
        this.lectureId = lectureId;
        this.resourceType = resourceType;
        count++;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    @Override
    public String toString() {
        return "Additional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lectureId=" + lectureId +
                ", resourceType=" + resourceType +
                '}';
    }

    @Override
    public int compareTo(Additional o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Additional that = (Additional) o;
        return lectureId == that.lectureId && Objects.equals(id, that.id) && Objects.equals(name, that.name) && resourceType == that.resourceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lectureId, resourceType);
    }
}
