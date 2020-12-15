package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.dao.QADao;
import spring.model.Answer;
import spring.model.Exam;
import spring.model.Question;

@Controller
public class QAController {

	@Autowired
	QADao dao;

	@RequestMapping("/newQ")
	public String showQ(Model m) {
		m.addAttribute("command", new Question());
		List<Exam> exam = dao.getExam();
		m.addAttribute("exam", exam);
		return "newQ";
	}

	@RequestMapping(value = "/insertQ", method = RequestMethod.POST)
	public String insertQ(@ModelAttribute("ques") Question ques, Model m) {
		dao.insertQ(ques);
		List<Question> quid = dao.getQuestionId();
		m.addAttribute("command", new Question());
		m.addAttribute("qid", quid);
		return "addA";
	}

	@RequestMapping(value = "/addA", method = RequestMethod.POST)
	public String addA(@ModelAttribute("ques") Question ques, Model m) {
		dao.insertA(ques);
		m.addAttribute("command", new Question());
		List<Exam> exam = dao.getExam();
		m.addAttribute("exam", exam);
		return "newQ";
	}

	@RequestMapping("/testQ")
	public String testQ(Model m) {
		m.addAttribute("command", new Question());
		List<Exam> exam = dao.getExam();
		m.addAttribute("exam", exam);
		return "testQ";
	}

	@RequestMapping(value = "/showQ/{id}", method = RequestMethod.GET)
	public String showT(@PathVariable Long id, Model m) {
		List<Question> question = dao.getQuesByExam(id);

		question.forEach(q -> {
			q.setAnswer(dao.getAnswerbyQid(q.getId()));
		});

		m.addAttribute("question", question);
		return "showQ";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(HttpServletRequest request, Model m) {
		try {
			Long examid = Long.parseLong(request.getParameter("examId"));
			List<Question> question = dao.getQuesByExam(examid);
			m.addAttribute("question", question);
		} catch (NumberFormatException e) {

		}

		int RAns = 0;
		int QNO = 0;
		Double score = 0.0;
		String[] questionIds = request.getParameterValues("questionId");

		try {
			for (String qid : questionIds) {
				QNO++;
				Long correctAid = findCorrectAid(Long.parseLong(qid));
				try {
					if (correctAid == Long.parseLong(request.getParameter("question_" + qid))) {
						Question q = dao.getMark(Long.parseLong(qid));
						score += q.getMark();
						RAns++;
					}
				} catch (NumberFormatException e) {

				}
			}

		} catch (Exception e) {

		}

		request.setAttribute("score", score);
		request.setAttribute("QNO", QNO);
		request.setAttribute("RAns", RAns);

		return "result";
	}

	// Find Correct answer ID using question ID
	public Long findCorrectAid(Long q_id) {
		List<Answer> answers = dao.getAnsbyQid(q_id);
//		Answer answer = dao.getAnsbyQid(q_id);
		for (Answer answer : answers) {
//			System.out.println(answer.getCorrect());
			if (answer.getCorrect() == 1) {
				return answer.getId();
			}
		}
		return null;
	}

}