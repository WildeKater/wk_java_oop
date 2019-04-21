package com.gmail.wildekatertz;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.gmail.wildekatertz.Exceptions.*;

public class Group implements java.io.Serializable, Voencom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student[] group = new Student[10];

	public Group() {
		super();
	}

	public Group(Student... student) {
		super();
		for (int i = 0; i < student.length; i++) {
			addStudent(student[i]);
		}
	}

	/**
	 * ���������� �������� � ������.
	 * 
	 * ���������� �������� ������� ���������� ����� � ������ ����� �����
	 * <code>StudentAddCheck()</code>
	 * 
	 * ������������� �������������� ������ <code>FullGroupException</code> ������
	 * <code>StudentAddCheck()</code>
	 * 
	 * ���������� �������� ���������� �������� � ������ ����� �����
	 * <code>StudentCheck()</code>
	 * 
	 * @param <code>student</code> ������ ������ Student
	 * 
	 * @author AlexeyA
	 */
	public void addStudent(Student student) {
		try {
			if (StudentAddCheck() && !StudentCheck(student)) {
				for (int i = 0; i < group.length; i++) {
					if (group[i] == null) {
						group[i] = student;
						System.out.println("������� " + student.getName() + " ��������");
						break;
					}
				}
			} else if (StudentCheck(student)) {
				System.out.println("������� " + student.getName() + " ��� � ������");
			}
		} catch (FullGroupException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * �������� �������� �� ������.
	 * 
	 * ���������� �������� ������� �������� � ������ ����� �����
	 * <code>StudentCheck()</code>
	 * 
	 * � ������ ������� �������� � ������ ���������� ������ <code>null</code> �� ���
	 * �����
	 * 
	 * � ������ ���������� �������� � ������ ��������� ��������� �� ����������
	 * ��������
	 * 
	 * @param <code>student</code> ������ ������ Student
	 * 
	 * @author AlexeyA
	 */
	public void removeStudent(Student student) {
		if (StudentCheck(student)) {
			for (int i = 0; i < group.length; i++) {
				if (group[i].equals(student)) {
					group[i] = null;
					System.out.println("������� " + student.getName() + " ��������");
					break;
				}
			}
		} else {
			System.out.println("������� " + student.getName() + " �� ������");
		}
	}

	/**
	 * �������� ������� ��������� ���� ������
	 * 
	 * @return <code>groupCheck</code> boolean ����, ���������� true ���� ���������
	 *         ���� ���
	 * 
	 * @exception <code>FullGroupException</code> ���������� ������ � ������
	 *            ������������� ������
	 * 
	 * @author AlexeyA
	 */
	private boolean StudentAddCheck() throws FullGroupException {
		boolean groupCheck = false;
		for (Human i : group) {
			if (i == null) {
				groupCheck = true;
			}
		}
		if (!groupCheck)
			throw new FullGroupException();
		return groupCheck;
	}

	/**
	 * �������� ������� �������� � ������
	 * 
	 * @param <code>student</code> ������ ������ Student
	 * 
	 * @return <code>groupCheck</code> boolean ����, ���������� true ���� �������
	 *         ������
	 * 
	 * @author AlexeyA
	 */
	private boolean StudentCheck(Student student) {
		boolean groupCheck = false;
		for (Human i : group) {
			if (i == student) {
				groupCheck = true;
			}
		}
		return groupCheck;
	}

	/**
	 * ����� �������� �� ��������� ����� ����� ����� <code>getName()</code> ������
	 * Student
	 * 
	 * @param <code>name</code> ��� ��������
	 * 
	 * @return <code>findlyStudent</code> ������ ������ Student
	 * 
	 * @author AlexeyA
	 */
	public Student findStudent(String name) {
		Student findlyStudent = null;
		for (Human i : group) {
			if ((i != null) && (i.getName() == name)) {
				findlyStudent = (Student) i;
			}
		}
		return findlyStudent;
	}

	/**
	 * ���������� ������� ������ �� ���������� ���������. ������������ ��������
	 * ��������
	 * 
	 * @author AlexeyA
	 */
	public void sortGroupBy() {
		ArrayList<Student> groupList = new ArrayList<Student>(Arrays.asList(group));
		System.out.println("������� �������� ����������(GENDER / AGE / NAME)");
		StudentParam studentParam = null;
		for (;;) {
			Scanner sc = new Scanner(System.in);
			String stringParam = sc.nextLine();
			try {
				studentParam = StudentParam.valueOf(stringParam.toUpperCase());
				break;
			} catch (Exception e) {
				System.out.println("������� ���������� �������� ��������� ����������(GENDER / AGE / NAME)");
			}
		}
		switch (studentParam) {
		case AGE:
			Collections.sort(groupList, Student.COMPARE_BY_AGE);
			break;
		case GENDER:
			Collections.sort(groupList, Student.COMPARE_BY_GENDER);
			break;
		case NAME:
			Collections.sort(groupList, Student.COMPARE_BY_NAME);
			break;
		}

		group = groupList.toArray(group);

		System.out.println("������ ����� ���������� �� �������� " + studentParam);
		System.out.println(toStringWithoutSort());

	}

	/**
	 * ����� ������ ������. ����� ������� ������ ����������� ���������� �������
	 * ����� ����� <code>sortGroup</code>
	 * 
	 * @author AlexeyA
	 */
	@Override
	public String toString() {
		Arrays.sort(group);
		String stringGroup = "";
		stringGroup = "Group [group=" + System.lineSeparator();
		for (Student i : group) {
			if (i != null) {
				stringGroup += i.toString() + System.lineSeparator();
			}
		}
		stringGroup += "]";
		return stringGroup;
	}

	/**
	 * ����� ������ ������. ����� ������� ������ ����������� ���������� �������
	 * ����� ����� <code>sortGroup</code>
	 * 
	 * @author AlexeyA
	 */
	private String toStringWithoutSort() {
		String stringGroup = "";
		stringGroup = "Group [group=" + System.lineSeparator();
		for (Student i : group) {
			if (i != null) {
				stringGroup += i.toString() + System.lineSeparator();
			}
		}
		stringGroup += "]";
		return stringGroup;
	}

	@Override
	public Student[] armyList() {

		ArrayList<Student> studentList = new ArrayList<Student>();
		for (Student i : group) {
			if ((i != null) && (i.getGender() == Genders.FEMALE) && (i.getAge() >= 18)) {
				studentList.add((Student) i);
			}
		}
		Collections.sort(studentList, Student.COMPARE_BY_NAME);

		Student[] armyList = studentList.toArray(new Student[studentList.size()]);
		return armyList;
	}

}
