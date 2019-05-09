package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOGroup {

	public static void groupSave(Group group) {
		File fl = new File(group.getGroupId() + ".csv");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fl))) {
			for (Student i : group.getGroup()) {
				if (i != null) {
					bw.write(i.getName() + "," + i.getGender() + "," + i.getAge());
					bw.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static Group groupLoad(String file) {
		File fl = new File(file);
		Group gr = new Group();
		try (BufferedReader br = new BufferedReader(new FileReader(fl))) {
			String hStr = "";
			for (; (hStr = br.readLine()) != null;) {
				String[] str = hStr.split(",");
				gr.addStudent(new Student(str[0], Genders.valueOf(str[1].toUpperCase()), Integer.valueOf(str[2])));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return gr;
	}

	public static void groupOutput(Group group, String file) {
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(file))) {
			OOS.writeObject(group);
			System.out.println("Группа сохранена");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static Group groupInput(String file) {
		Group inputGroup = null;
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file))) {
			inputGroup = (Group) OIS.readObject();
			System.out.println("Группа загружена");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return inputGroup;
	}

}
