import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class StudentAttendance {

	public static void main(String[] args) {

		File file1 = new File("studentsdetails.txt");
		File file2 = new File("lecturer.txt");
		File file3 = new File("attendancelog.txt");
		File file4 = new File("attendancereport.txt");
		FileWriter fw = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("      " + "UNIVERSITY OF GUGSI");
		System.out.println("Enter 1 to Input Student Details");
		System.out.println("Enter 2 to View Student Details");
		System.out.println("Enter 3 to Input Staff Details");
		System.out.println("Enter 4 to View Staff Details");
		System.out.println("Enter 5 to Mark Attendance");
		System.out.println("Enter 6 to View Attendance");
		
		int select = sc.nextInt();
		int attendance = 0, stdenrol = 0;

		switch (select) {
		// Input student details
		case 1: {
			
			// Getting the input
			System.out.println("Enter Student No:");
			String stdno = sc.next();
			System.out.println("Enter Last Name:");
			String secondn = sc.next();
			System.out.println("Enter First Name:");
			String firstn = sc.next();

			try {
				// creating object
				fw = new FileWriter(file1, true);
				pw = new PrintWriter(fw, true);
				// writing to file
				pw.println(stdno + "   ");
				pw.print(secondn + "   ");
				pw.print(firstn + "   ");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				pw.close();
			}
			System.out.println("Successfully Added!");

			break;

		}
		// View student details
		case 2: {

			try {

				sc = new Scanner(file1);
				System.out.printf("%15s%15s%15s", "Student Id", "Last Name", "First Name");
				while (sc.hasNext()) {
					String stdno = sc.next();
					String firstn = sc.next();
					String secondn = sc.next();

					System.out.printf("\n%15s%15s%15s", stdno, secondn, firstn);

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			break;
		}
		// Input Staff details
		case 3: {

			System.out.println("Enter UnitID:");
			String unitid = sc.next();
			System.out.println("Enter Unit Name:");
			String unitname = sc.next();
			System.out.println("Enter RoomNo:");
			String roomno = sc.next();
			System.out.println("Enter Room Name:");
			String roomname = sc.next();
			System.out.println("Enter Lecturer Name:");
			String lecname = sc.next();
			System.out.println("Enter Room Capacity:");
			String roomcap = sc.next();
			System.out.println("Enter No Of Students Enrolled:");
			String nostd = sc.next();

			try {
				// creating object

				fw = new FileWriter(file2, true);
				pw = new PrintWriter(fw, true);
				// writing to file
				pw.print(unitid + "    ");
				pw.print(unitname + "    ");
				pw.print(roomno + "    ");
				pw.print(roomname + "    ");
				pw.print(lecname + "    ");
				pw.print(roomcap + "    ");
				pw.println(nostd);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				pw.close();

			}
			System.out.println("Successfully Added!");

			break;
		}
		// View Staff Details
		case 4: {
			try {

				sc = new Scanner(file2);
				System.out.printf("%15s%15s%15s%15s%15s%15s%15s", "Unit Id", "Unit Name", "Room No", "Room Name",
						"Lecturer Name", "Room Capacity", "No of Students");
				while (sc.hasNext()) {
					String unitid = sc.next();
					String unitname = sc.next();
					String roomno = sc.next();
					String roomname = sc.next();
					String lecname = sc.next();
					String roomcap = sc.next();
					String nostd = sc.next();
					System.out.printf("\n%15s%15s%15s%15s%15s%15s%15s", unitid, unitname, roomno, roomname, lecname,
							roomcap, nostd);

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			break;
		}
		// Mark attendance
		case 5: {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(select);
			String nowDate = dateFormat.format(date);
			String unitId = null;
			String unitName = null;
			String roomNo = null;
			String roomName = null;
			String lecName = null;
			String roomCap = null;
			String noStd = null;
			System.out.println("Enter Student id:");
			String stdId = sc.next();
			System.out.println("Enter Unit id:");
			String untId = sc.next();
			System.out.println("Enter Week:");
			String week = sc.next();
			try {

				sc = new Scanner(file2);

				while (sc.hasNext()) {

					unitId = sc.next();
					unitName = sc.next();
					roomNo = sc.next();
					roomName = sc.next();
					lecName = sc.next();
					roomCap = sc.next();
					noStd = sc.next();
					if (unitId.equalsIgnoreCase(untId)) {
						break;
					}

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				// creating object
				fw = new FileWriter(file3, true);
				pw = new PrintWriter(fw, true);
				// writing to file
				pw.print(roomNo + "    ");
				pw.print(stdId + "    ");
				pw.print(unitId + "     ");
				pw.print(lecName + "    ");
				pw.print(nowDate + "    ");
				pw.println(week + "     ");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				pw.close();

			}

			break;
		}
			// Generating the report 
		case 6: {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(select);
			String nowdate = dateFormat.format(date);
			String avalability = null;
			String unitId = null;
			String unitName = null;
			String roomNo = null;
			String roomName = null;
			String lecName = null;
			String roomCap = null;
			String noStd = null;
			System.out.println("Enter Unit ID");
			String untid = sc.next();
			System.out.println("Enter Week");
			String week = sc.next();
			try {

				sc = new Scanner(file2);

				while (sc.hasNext()) {

					unitId = sc.next();
					unitName = sc.next();
					roomNo = sc.next();
					roomName = sc.next();
					lecName = sc.next();
					roomCap = sc.next();
					noStd = sc.next();
					if (unitId.equalsIgnoreCase(untid)) {
						break;
					}

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// Writing report to file
			try {
				fw = new FileWriter(file4, true);
				pw = new PrintWriter(fw, true);

				pw.println("Attendance Report");
				pw.println("");
				pw.println("Unit	    	:" + unitId);
				pw.println("Unit Name	:" + unitName);
				pw.println("Room	    	:" + roomNo);
				pw.println("Name        	:" + roomName);
				pw.println("Lecturer	:" + lecName);
				pw.println("Week        	:" + week);
				pw.println("Date	    	:" + nowdate);

				String uniti = null;
				try {
					Scanner sc2 = new Scanner(file3);
					sc = new Scanner(file1);

					fw = new FileWriter(file4, true);
					pw = new PrintWriter(fw, true);

					pw.printf("%15s%15s%15s%15s", "Student No", "Last Name", "First Name", "Present");
					while (sc.hasNext()) {

						String stdNo = sc.next();
						String secondN = sc.next();
						String firstN = sc.next();

						while (sc2.hasNext()) {
							String roomNo2 = sc2.next();
							String stdid1 = sc2.next();
							uniti = sc2.next();
							String lecName2 = sc2.next();
							String date2 = sc2.next();
							String time2 = sc2.next();
							String weeks = sc2.next();

							if (stdNo.equalsIgnoreCase(stdid1) && week.equalsIgnoreCase(weeks)) {

								avalability = "Y";
								attendance++;

								fw = new FileWriter(file4, true);
								pw = new PrintWriter(fw, true);

								pw.printf("\n%15s%15s%15s%15s", stdNo, firstN, secondN, avalability);

								break;
							} else {
								avalability = "N";
								stdenrol++;

								fw = new FileWriter(file4, true);
								pw = new PrintWriter(fw, true);

								pw.printf("\n%15s%15s%15s%15s\n", stdNo, firstN, secondN, avalability);
								break;
							}
						}
					}

					fw = new FileWriter(file4, true);
					pw = new PrintWriter(fw, true);

					pw.println("\nLecturer Confirmed attendance : Yes/No");
					pw.println("Students Enrolled		: " + (stdenrol + attendance));
					pw.println("Attendance      		: " + attendance);
					pw.println("Room Capacity   		: " + roomCap);

					int percentage = (attendance / (stdenrol + attendance)) * 100;

					pw.println("Percentage Occupancy	:" + percentage + "%");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
	
		}
		
		}
	}

}
