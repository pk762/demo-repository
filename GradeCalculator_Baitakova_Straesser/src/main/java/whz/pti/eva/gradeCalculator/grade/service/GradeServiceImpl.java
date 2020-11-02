package whz.pti.eva.gradeCalculator.grade.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whz.pti.eva.gradeCalculator.grade.domain.Grade;
import whz.pti.eva.gradeCalculator.grade.domain.GradeRepository;


@Service
public class GradeServiceImpl implements GradeService{
	
	
	private GradeRepository gradeRepository;
	@Autowired
	public GradeServiceImpl(GradeRepository gradeRepository) {
		this.gradeRepository = gradeRepository;
	}
	
	@Override
	public void addGrade(String lecture, String grade) {
		Grade gradeToAdd = new Grade(lecture, grade);
		gradeRepository.save(gradeToAdd);
	}
	
	@Override
	public double calculateAverage() {
		return gradeRepository.findAll().stream().collect(Collectors.averagingDouble(grade -> Double.parseDouble(grade.getGrade())));
	}

	@Override
	public List<Grade> listAllgrades() {
		return gradeRepository.findAll();
	}
}