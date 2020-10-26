package whz.pti.eva.gradeCalculator.grade.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Grade {

	@Id @GeneratedValue
	private Integer id;
	
	private String grade;
	private String lecture;
	
	public Grade () {
		
	}
	public Grade(String lecture, String grade) {
		this.lecture = lecture;
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}
	
	public String getLecture() {
		return lecture;
	}
	
}
