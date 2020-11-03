package whz.pti.eva.gradeCalculator.grade.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import whz.pti.eva.gradeCalculator.grade.domain.Grade;
import whz.pti.eva.gradeCalculator.grade.service.GradeService;

@Controller
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@RequestMapping("/grades")
	public String listAllGrades(Model model) {
		List<Grade> gradesList = gradeService.listAllGrades();
			model.addAttribute("listAllGrades", gradesList);
			model.addAttribute("averageGrade", gradeService.calculateAverage());
			return "grades";
	}
	
	@RequestMapping(value = "/addGrade", method = RequestMethod.POST)
	public String addGrade(@RequestParam String lecture, @RequestParam String grade) {
		gradeService.addGrade(lecture, grade);
		return "redirect:grades";
	}
}
