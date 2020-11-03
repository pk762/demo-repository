package whz.pti.eva.gradeCalculator.grade.service;

import java.util.List;

import whz.pti.eva.gradeCalculator.grade.domain.Grade;

public interface GradeService {
	
	List<Grade> listAllGrades();
	
	void addGrade(String lecture, String grade);
	
	double calculateAverage();
}
