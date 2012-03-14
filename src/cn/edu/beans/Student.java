package cn.edu.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	private Integer id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	@ManyToMany(cascade=CascadeType.REFRESH)
	@JoinTable(name="student_teacher",
			inverseJoinColumns=@JoinColumn(name="student_id"),joinColumns=@JoinColumn(name="teacher_id"))
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(nullable=false,length=10)  
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void addTeacher(Teacher teacher){
		teachers.add(teacher);
	}
	public void removeTeacher(Teacher teacher){
		if(teachers.contains(teacher)){
			teachers.remove(teacher);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
