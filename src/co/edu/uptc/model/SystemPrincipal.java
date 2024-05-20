package co.edu.uptc.model;

import co.edu.uptc.structures.AVLTree;

import java.util.Comparator;
import java.util.List;


public class SystemPrincipal  {

	private AVLTree<Course> courses;
	private AVLTree<Student> students;

	public SystemPrincipal() {
		this.courses = new AVLTree<>(Comparator.comparing(Course::getName));
		this.students = new AVLTree<>(Comparator.comparing(student->student.getUser().getCode()));
	}

	public boolean loginStudent(String code, String password) {
		boolean verification = false;
		Iterable<Student> students = this.students.inOrder();
		for (Student student : students) {
			verificationLogin(student, code, password);
		}
		return verification;
	}

	private boolean verificationLogin(Student student, String code, String password) {
		boolean verification = false;
		int count = 0;
		if (count ==0 && student.getUser().isAvailable()) {
			if (student.getUser().getCode().equals(code) && student.getUser().getPassword().equals(password)) {
				verification = true;
				count++;
			}
		}
		return verification;
	}

	public boolean loginAdmin(String code, String password) {
		boolean verification = false;
		int count = 0;
		Iterable<Student> students = this.students.inOrder();
		for (Student student : students) {
			verificationLogin(student, code, password);
		}
		return verification;
	}


	public boolean addStudent(Student student) {
		boolean verification = false;
		if (students.searchData(student) == null) {
			students.insert(student);
			verification = true;
		}
		return true;
	}

	public boolean changePassword(String codeUser, String passwordNew) {
		boolean verification = false;
		Iterable<Student> students = this.students.inOrder();
		while (students.iterator().hasNext()) {
			Student student = students.iterator().next();
			if (student.getUser().getCode().equals(codeUser)) {
				student.getUser().setPassword(passwordNew);
				verification = true;
			}
		}
		return verification;
	}

	public String searchCourse(Student student){
		String courseFound = new String();
		Iterable<Course> courses = this.courses.inOrder();
		while (courses.iterator().hasNext()) {
			Course course = courses.iterator().next();
			if (course.getName().equals(student.getStyleLearning())) {
				courseFound = course.getInformation();
			}
		}
		return courseFound;
	}



	public Student showUser(String codeUser) {
		Student studentFound = new Student();
		Iterable<Student> students = this.students.inOrder();
		while (students.iterator().hasNext()) {
			Student student = students.iterator().next();
			if (student.getUser().getCode().equals(codeUser)) {
				studentFound = student;
			}
		}
		return studentFound;
	}

	public boolean verificationUser(String code) {
		boolean verification = false;
		Iterable<Student> students = this.students.inOrder();
		while (students.iterator().hasNext()) {
			Student student = students.iterator().next();
			if (student.getUser().getCode().equals(code)) {
					verification = true;
			}
		}
		return verification;
	}
	//y los block





	public List<Course> getCourses() {
		return courses.inOrder();
	}

	public List<Student> getStudents() {
		return students.inOrder();
	}


	public void setCourses(AVLTree<Course> courses) {
		this.courses = courses;
	}

	public void setStudents(AVLTree<Student> students) {
		this.students = students;
	}
}
