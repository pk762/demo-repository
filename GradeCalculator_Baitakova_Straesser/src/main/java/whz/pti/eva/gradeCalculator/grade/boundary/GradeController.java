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
		List<Grade> gradesList = gradeService.listAllgrades();
			model.addAttribute("listAllGrades", gradesList);
			return "grades";
	}
}
