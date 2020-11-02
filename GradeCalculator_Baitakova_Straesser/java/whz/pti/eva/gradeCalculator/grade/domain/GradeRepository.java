package whz.pti.eva.gradeCalculator.grade.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GradeRepository extends JpaRepository<Grade, Integer> {
	Optional<Grade> findByLecture(String lecture);
	
}
