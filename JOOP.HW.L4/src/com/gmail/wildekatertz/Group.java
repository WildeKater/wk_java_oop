package com.gmail.wildekatertz;

import java.util.Scanner;

import com.gmail.wildekatertz.Exceptions.*;

public class Group implements java.io.Serializable, Voencom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Human[] group = new Human[10];

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
		Human temp;
		boolean flag;
		System.out.println("������� �������� ����������(GENDER / AGE / NAME)");
		StudentParam studentParam = null;

		for (;;) {
			Scanner sc = new Scanner(System.in);
			String stringParam = sc.nextLine();
			try {
				studentParam = studentParam.valueOf(stringParam.toUpperCase());
				break;
			} catch (Exception e) {
				System.out.println("������� ���������� �������� ��������� ����������(GENDER / AGE / NAME)");
			}
		}
		switch (studentParam) {
		case AGE:
			for (;;) {
				flag = true;
				for (int i = 0; i < group.length - 1; i++) {
					if ((group[i] == null) || ((group[i] != null) && (group[i + 1] != null))
							&& (group[i].getAge() > (group[i + 1].getAge()))) {
						temp = group[i];
						group[i] = group[i + 1];
						group[i + 1] = temp;
						flag = false;
					}
				}
				if (flag) {
					break;
				}
			}
			break;
		case GENDER:
			for (;;) {
				flag = true;
				for (int i = 0; i < group.length - 1; i++) {
					if ((group[i] == null) || ((group[i] != null) && (group[i + 1] != null))
							&& (group[i].getGender().ordinal() > group[i + 1].getGender().ordinal())) {
						temp = group[i];
						group[i] = group[i + 1];
						group[i + 1] = temp;
						flag = false;
					}
				}
				if (flag) {
					break;
				}
			}
			break;
		case NAME:
			for (;;) {
				flag = true;
				for (int i = 0; i < group.length - 1; i++) {
					if ((group[i] == null) || ((group[i] != null) && (group[i + 1] != null))
							&& (group[i].getName().compareTo(group[i + 1].getName()) > 0)) {
						temp = group[i];
						group[i] = group[i + 1];
						group[i + 1] = temp;
						flag = false;
					}
				}
				if (flag) {
					break;
				}
			}
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
		String stringGroup = "";
		stringGroup = "Group [group=" + System.lineSeparator();
		for (Human i : group) {
			if (i != null) {
				stringGroup += i.toString() + System.lineSeparator();
			}
		}
		stringGroup += "]";
		return stringGroup;
	}

	@Override
	public Student[] armyList() {
		Student[] armyList = new Student[group.length];
		int j = 0;
		for (Human i : group) {
			if ((i != null) && (i.getGender() == Genders.FEMALE) && (i.getAge() >= 18)) {
				armyList[j] = (Student) i;
				j++;
			}
		}

		return armyList;
	}

}
