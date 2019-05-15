package com.gmail.wildekatertz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		if (group.contains(student)) {
			System.out.println("Студент " + student.getName() + " уже в группе");
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
		if (group.contains(student)) {
			group.remove(student);
			System.out.println("Студент " + student.getName() + " исключен");
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
	private boolean studentAddCheck() throws FullGroupException {
		if (group.size() < 10) {
			return true;
		} else {
			throw new FullGroupException();
		}
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
			if (i.getName().equals(name)) {
				findlyStudent = (Student) i;
			}
		}
		return findlyStudent;
	}

	/**
	 * Сортировка массива группы по введенному параметру.
	 * 
	 * @author AlexeyA
	 */
	public void sortGroupBy() {
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

		sortGroupBy(studentParam);

		System.out.println("Массив после сортировки по критерию " + studentParam);
		System.out.println(toStringWithoutSort());

	}

	/**
	 * Сортировка массива группы по переданному параметру.
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
	 * Вывод списка группы. Перед началом вывода запускается сортировка массива
	 * через метод <code>sortGroup</code>
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
	 * Вывод списка группы без предварительной сортировки.
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

	public List<Student> subgroupStudent(String startName) {

		ArrayList<Student> subgroup = group.stream().filter(n -> n.getName().startsWith(startName))
				.collect(Collectors.toCollection(ArrayList::new));

		return subgroup;
	}

}
