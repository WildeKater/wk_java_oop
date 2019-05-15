package com.gmail.wildekatertz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.gmail.wildekatertz.Exceptions.*;

public class Group implements java.io.Serializable, Voencom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Student> group = new ArrayList<Student>();
	private static int groupNumber = 0;
	private int groupId;

	public Group() {
		super();
		groupNumber++;
		this.groupId = groupNumber;
	}

	public Group(Student... student) {
		super();
		for (int i = 0; i < student.length; i++) {
			addStudent(student[i]);
		}
		groupNumber++;
		this.groupId = groupNumber;
	}

	public int getGroupId() {
		return groupId;
	}

	public List<Student> getGroup() {
		return group;
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
		if (group.contains(student)) {
			System.out.println("������� " + student.getName() + " ��� � ������");
		}
		try {
			if (studentAddCheck()) {
				group.add(student);
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
		if (group.contains(student)) {
			group.remove(student);
			System.out.println("������� " + student.getName() + " ��������");
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
	private boolean studentAddCheck() throws FullGroupException {
		if (group.size() < 10) {
			return true;
		} else {
			throw new FullGroupException();
		}
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
			if (i.getName().equals(name)) {
				findlyStudent = (Student) i;
			}
		}
		return findlyStudent;
	}

	/**
	 * ���������� ������� ������ �� ���������� ���������.
	 * 
	 * @author AlexeyA
	 */
	public void sortGroupBy() {
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

		sortGroupBy(studentParam);

		System.out.println("������ ����� ���������� �� �������� " + studentParam);
		System.out.println(toStringWithoutSort());

	}

	/**
	 * ���������� ������� ������ �� ����������� ���������.
	 * 
	 * @author AlexeyA
	 */
	public void sortGroupBy(StudentParam studentParam) {
		switch (studentParam) {
		case AGE:
			Collections.sort(group, Student.COMPARE_BY_AGE);
			break;
		case GENDER:
			Collections.sort(group, Student.COMPARE_BY_GENDER);
			break;
		case NAME:
			Collections.sort(group, Student.COMPARE_BY_NAME);
			break;
		}

	}

	/**
	 * ����� ������ ������. ����� ������� ������ ����������� ���������� �������
	 * ����� ����� <code>sortGroup</code>
	 * 
	 * @author AlexeyA
	 */
	@Override
	public String toString() {

		Collections.sort(group, Student.COMPARE_BY_NAME);

		String stringGroup = "";
		stringGroup = "Group [group=" + System.lineSeparator();
		for (Student i : group) {
			stringGroup += i.toString() + System.lineSeparator();
		}
		stringGroup += "]";
		return stringGroup;
	}

	/**
	 * ����� ������ ������ ��� ��������������� ����������.
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
	public List<Student> armyList() {

		List<Student> armyList = new ArrayList<Student>();
		for (Student i : group) {
			if ((i.getGender() == Genders.FEMALE) && (i.getAge() >= 18)) {
				armyList.add((Student) i);
			}
		}
		Collections.sort(armyList, Student.COMPARE_BY_NAME);

		return armyList;
	}

}
