package com.gmail.wildekatertz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

}
