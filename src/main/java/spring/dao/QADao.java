package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.model.Answer;
import spring.model.Exam;
import spring.model.Question;

public class QADao {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

//	// Get ans id by Qid
//	public Answer getAnsbyQid(Long id) {
//		String sql = "SELECT * FROM answer WHERE question_id=?";
//
//		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Answer>(Answer.class));
//	}

//	// Get ans id by Qid
//	public Question getAnsbyQid(Long id) {
//		String sql = "SELECT * FROM answer WHERE question_id=?";
//
//		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Question>(Question.class));
//	}

	// Get getAns Id by Qid
	public List<Answer> getAnsbyQid(Long id) {
		String sql = "SELECT * FROM answer WHERE question_id=?";
		return (List<Answer>) template.query(sql, new Object[] { id }, new RowMapper<Answer>() {

			public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Answer answer = new Answer();
				answer.setId(rs.getLong("id"));
				answer.setAnswer(rs.getString("answer"));
				answer.setCorrect(rs.getInt("correct"));
				return answer;
			}

		});
	}

	// Get Answers by Question ID
	public List<Answer> getAnswerbyQid(Long id) {
		String sql = "SELECT * FROM answer WHERE question_id=?";
		return template.query(sql, new Object[] { id }, new RowMapper<Answer>() {

			public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Answer answer = new Answer();
				answer.setId(rs.getLong("id"));
				answer.setAnswer(rs.getString("answer"));
				answer.setCorrect(rs.getInt("correct"));
				return answer;
			}

		});
	}

	// Get Mark by question id
	public Question getMark(Long id) {
		String sql = "SELECT * FROM question WHERE id=?";
		
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Question>(Question.class));
	}

	// Get Question by Exam id
	public List<Question> getQuesByExam(Long id) {
		String sql = "SELECT * FROM question WHERE examid=?";

		return template.query(sql, new Object[] { id }, new RowMapper<Question>() {

			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Question q = new Question();
				q.setId(rs.getLong("id"));
				q.setQuestion(rs.getString("question"));
				q.setMark(rs.getDouble("mark"));
				return q;
			}

		});
	}

	// Insert Answer
	public int insertA(Question ques) {
		String sql = "INSERT INTO answer(answer, question_id, correct)" + "VALUES('" + ques.getOption1() + "', "
				+ ques.getId() + ", " + ques.getA1() + "), ('" + ques.getOption2() + "', " + ques.getId() + ", "
				+ ques.getA2() + "), ('" + ques.getOption3() + "', " + ques.getId() + ", " + ques.getA3() + "), ('"
				+ ques.getOption4() + "', " + ques.getId() + ", " + ques.getA4() + ") ";
		return template.update(sql);
	}

	// Insert Question
	public int insertQ(Question ques) {
		String sql = "INSERT INTO question(question, examid, mark) VALUES('" + ques.getQuestion() + "', "
				+ ques.getExamid() + ", " + ques.getMark() + ")";
		return template.update(sql);

	}

	// Get Question id
	public List<Question> getQuestionId() {
		String sql = "SELECT * FROM question ORDER BY id DESC LIMIT 1";

		return template.query(sql, new RowMapper<Question>() {

			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Question ques = new Question();
				ques.setId(rs.getLong("id"));
				ques.setQuestion(rs.getString("question"));
				return ques;
			}

		});
	}

	// Get Exam List
	public List<Exam> getExam() {
		return template.query("SELECT * FROM exam", new RowMapper<Exam>() {
			public Exam mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Exam e = new Exam();
				e.setId(rs.getLong("examid"));
				e.setName(rs.getString("name"));
				e.setTotalmark(rs.getInt("totalmark"));
				return e;
			}
		});
	}

}
