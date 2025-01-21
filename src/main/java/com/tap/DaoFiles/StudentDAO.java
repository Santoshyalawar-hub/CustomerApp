package com.tap.DaoFiles;

import java.util.List;

import com.tap.Model.Student;

public interface StudentDAO {
		List<Student>fetchAll();
		int insertStudent(Student s);
		Student fetchOnId(int id);
		int updateStudent(Student s);
		int delete(int id);
}
