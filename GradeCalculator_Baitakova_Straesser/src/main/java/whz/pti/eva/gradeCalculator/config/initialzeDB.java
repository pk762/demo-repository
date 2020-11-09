package whz.pti.eva.gradeCalculator.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import whz.pti.eva.gradeCalculator.grade.domain.Grade;
import whz.pti.eva.gradeCalculator.grade.domain.GradeRepository;

@Component
public class initialzeDB {
	private static final Logger log = LoggerFactory.getLogger(initialzeDB.class);
	@Autowired
	GradeRepository gradeRepo;
	
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		log.debug(" >>> Db initialized");
		Grade g1 = new Grade("EVA", "1.3");
		Grade g2 = new Grade("GdP-1", "3.7");
		Grade g3 = new Grade("GdP-2", "3");
		gradeRepo.save(g1);
		gradeRepo.save(g2);
		gradeRepo.save(g3);
	}
	
	
}
