package com.gmail.wildekatertz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
	 * Добавление студента в группу.
	 * 
	 * Происходит проверка наличия свободного места в группе через метод
	 * <code>StudentAddCheck()</code>
	 * 
	 * Дополнительно обрабатывается ошибка <code>FullGroupException</code> метода
	 * <code>StudentAddCheck()</code>
	 * 
	 * Происходит проверка отсутствия студента в группе через метод
	 * <code>StudentCheck()</code>
	 * 
	 * @param <code>student</code> Объект класса Student
	 * 
	 * @author AlexeyA
	 */
	public void addStudent(Student student) {
		try {
			if (StudentAddCheck() && !StudentCheck(student)) {
				for (int i = 0; i < group.length; i++) {
					if (group[i] == null) {
						group[i] = student;
						System.out.println("Студент " + student.getName() + " добавлен");
						break;
					}
				}
			} else if (StudentCheck(student)) {
				System.out.println("Студент " + student.getName() + " уже в группе");
			}
		} catch (FullGroupException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Удаление студента из группы.
	 * 
	 * Происходит проверка наличия студента в группе через метод
	 * <code>StudentCheck()</code>
	 * 
	 * В случае наличия студента в группе происходит запись <code>null</code> на его
	 * место
	 * 
	 * В случае отсутствия студента в группе выводится сообщение об отсутствии
	 * студента
	 * 
	 * @param <code>student</code> Объект класса Student
	 * 
	 * @author AlexeyA
	 */
	public void removeStudent(Student student) {
		if (StudentCheck(student)) {
			for (int i = 0; i < group.length; i++) {
				if (group[i].equals(student)) {
					group[i] = null;
					System.out.println("Студент " + student.getName() + " исключен");
					break;
				}
			}
		} else {
			System.out.println("Студент " + student.getName() + " не найден");
		}
	}

	/**
	 * Проверка наличия свободных мест группе
	 * 
	 * @return <code>groupCheck</code> boolean флаг, возвращает true если свободных
	 *         мест нет
	 * 
	 * @exception <code>FullGroupException</code> Генерирует ошибку в случае
	 *            заполненности группы
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
	 * Проверка наличия студента в группе
	 * 
	 * @param <code>student</code> Объект класса Student
	 * 
	 * @return <code>groupCheck</code> boolean флаг, возвращает true если студент
	 *         найден
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
	 * Поиск студента по заданному имени через метод <code>getName()</code> класса
	 * Student
	 * 
	 * @param <code>name</code> Имя студента
	 * 
	 * @return <code>findlyStudent</code> Объект класса Student
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
	 * Сортировка массива группы по выбранному параметру. Используется алгоритм
	 * пузырька
	 * 
	 * @author AlexeyA
	 */
	public void sortGroupBy() {
		List<Student> groupList = new ArrayList<Student>(Arrays.asList(group));
		System.out.println("Введите параметр сортировки(GENDER / AGE / NAME)");
		StudentParam studentParam = null;
		for (;;) {
			Scanner sc = new Scanner(System.in);
			String stringParam = sc.nextLine();
			try {
				studentParam = StudentParam.valueOf(stringParam.toUpperCase());
				break;
			} catch (Exception e) {
				System.out.println("Введите корректное значение параметра сортировки(GENDER / AGE / NAME)");
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

		System.out.println("Массив после сортировки по критерию " + studentParam);
		System.out.println(toStringWithoutSort());

	}

	/**
	 * Вывод списка группы. Перед началом вывода запускается сортировка массива
	 * через метод <code>sortGroup</code>
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
	 * Вывод списка группы. Перед началом вывода запускается сортировка массива
	 * через метод <code>sortGroup</code>
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

		List<Student> studentList = new ArrayList<Student>();
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
