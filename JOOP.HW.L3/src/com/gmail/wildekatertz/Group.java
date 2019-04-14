package com.gmail.wildekatertz;

import com.gmail.wildekatertz.Exceptions.*;

public class Group implements java.io.Serializable {

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
	 * ���������� ������� ������ �� ����� ���������. ������������ �������� ��������
	 * 
	 * @author AlexeyA
	 */
	private void sortGroup() {
		Human temp;
		boolean flag;
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
	}

	/**
	 * ����� ������ ������. ����� ������� ������ ����������� ���������� �������
	 * ����� ����� <code>sortGroup</code>
	 * 
	 * @author AlexeyA
	 */
	@Override
	public String toString() {
		sortGroup();
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

}
