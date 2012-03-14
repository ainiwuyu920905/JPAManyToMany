package cn.edu.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

	private Integer id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
	
	@ManyToMany(cascade=CascadeType.REFRESH,mappedBy="teachers")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
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
	
}
