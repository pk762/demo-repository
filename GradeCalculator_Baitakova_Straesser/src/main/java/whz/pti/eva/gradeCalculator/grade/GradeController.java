package whz.pti.eva.gradeCalculator.grade;

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
	public String listAllGrades(@RequestParam String from,
	@RequestParam String to, Model model) {
		List<Grade> gradesList = gradeService.listAllgrades();
			model.addAttribute("listAllGrades", gradesList);
			model.addAttribute("toUser", to);
			model.addAttribute("fromUser", from);
			model.addAttribute("currentUser", from);
			return "posting";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGrade(@RequestParam String from, @RequestParam String to,
	@RequestParam String lecture, @RequestParam String grade, Model model) {
		model.addAttribute("fromUser", from);
		model.addAttribute("currentUser", from);
		List<Grade> gradesList = gradeService.listAllgrades();
		model.addAttribute("listAllGrades", gradesList);
		gradeService.addGrade(lecture, grade);
		return "redirect:posts?from="+ from + "&to=" + to;
	}
}
