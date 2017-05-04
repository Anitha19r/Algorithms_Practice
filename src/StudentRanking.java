 import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class StudentRanking {

	static class PQComparator implements Comparator<TestResult> {

		@Override
		public int compare(TestResult one, TestResult two) {
			// TODO Auto-generated method stub
			return one.testScore - two.testScore;
		}

	}

	public static void main(String[] args) {
		// Create an array List of TestResult
		List<TestResult> student = new ArrayList<TestResult>();
		Map<Integer, Double> FinalScores = new HashMap<Integer, Double>();

		// create a list of test result for a student
		student.add(new TestResult(1, "2010", 90));
		student.add(new TestResult(1, "2010", 90));
		student.add(new TestResult(1, "2010", 60));
		student.add(new TestResult(1, "2009", 75));
		student.add(new TestResult(1, "2010", 80));
		student.add(new TestResult(1, "2009", 88));
		student.add(new TestResult(1, "2009", 98));
		student.add(new TestResult(1, "2009", 50));
		student.add(new TestResult(1, "2008", 40));
		student.add(new TestResult(1, "2009", 100));

		// create a list of test result for another student

		student.add(new TestResult(2, "2010", 90));
		student.add(new TestResult(2, "2010", 90));
		student.add(new TestResult(2, "2010", 90));
		student.add(new TestResult(2, "2009", 90));
		student.add(new TestResult(2, "2010", 90));
		student.add(new TestResult(2, "2009", 88));
		student.add(new TestResult(2, "2009", 78));
		student.add(new TestResult(2, "2009", 50));
		student.add(new TestResult(2, "2008", 60));
		student.add(new TestResult(2, "2009", 100));

		student.add(new TestResult(3, "2010", 85));
		student.add(new TestResult(3, "2010", 90));
		student.add(new TestResult(3, "2010", 60));
		student.add(new TestResult(3, "2009", 75));
		student.add(new TestResult(3, "2010", 80));
		student.add(new TestResult(3, "2009", 88));
		student.add(new TestResult(3, "2009", 98));
		student.add(new TestResult(3, "2009", 50));
		student.add(new TestResult(3, "2008", 40));
		student.add(new TestResult(3, "2009", 100));

		FinalScores = calculateFinalScores(student);

		for (Map.Entry<Integer, Double> e : FinalScores.entrySet()) {
			System.out.println("Student ID >> " + e.getKey()
					+ " >> Average Score >> " + e.getValue());
		}
	}

	static Map<Integer, Double> calculateFinalScores(List<TestResult> results) {
		Double avg = 0.0;
		int sum = 0;
		int count = 0;
		HashMap<Integer, PriorityQueue<TestResult>> top5_marks = new HashMap<Integer, PriorityQueue<TestResult>>();
		// put the student id and his average in a hashmap
		HashMap<Integer, Double> final_scores = new HashMap<Integer, Double>();

		PQComparator pqComparator = new PQComparator();
		
		PriorityQueue<TestResult> pq = null;

		for (TestResult r : results) {
			if (top5_marks.containsKey(r.studentId)) {
				if (pq.size() == 5) 
				{
					
					pq.add(r);
					pq.poll();
					
				} else 
				{
					pq.add(r);
				}
			} else {
				pq = new PriorityQueue<TestResult>(5, pqComparator);
				
				pq.add(r);
				top5_marks.put(r.studentId, pq);
			}
		}

		for (Map.Entry<Integer, PriorityQueue<TestResult>> e : top5_marks
				.entrySet()) {
			PriorityQueue<TestResult> temp = e.getValue();
			for (TestResult t : temp) {
				sum = sum + t.testScore;
				count = count + 1;
			}
			avg = (double) sum / count;
			final_scores.put(e.getKey(), avg);
			sum = 0;
			count = 0;
		}
		return final_scores;
	}
}                        
class TestResult {
	int studentId;
	String testDate;
	int testScore;

	TestResult() {
		studentId = 0;
		testDate = "";
		testScore = 0;
	}

	TestResult(int Id, String date, int score) {
		this.studentId = Id;
		this.testDate = date;
		this.testScore = score;
	}

	int getID() {
		return this.studentId;
	}

	int getScore() {
		return this.testScore;
	}
}