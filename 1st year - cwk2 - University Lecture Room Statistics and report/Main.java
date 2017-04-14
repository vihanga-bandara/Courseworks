import java.io.*;
import java.util.*;
public class Main {
	static Scanner sc=new Scanner(System.in);

	public static void AddStudentFile(){
		File studentfile=new File("studentsdetails.txt");	
		File student=new File("studentmoddetails.txt");
		PrintWriter pw=null;
		PrintWriter ppw=null;
		PrintWriter pppw=null;
		FileWriter fw=null;
		FileWriter ffw=null;
		FileWriter fffw=null;
		try {
			fw=new FileWriter(studentfile,true);
			pw=new PrintWriter(fw,true);
			ffw=new FileWriter(student,true);
			ppw=new PrintWriter(ffw,true);
			sc=new Scanner(System.in);

			//enter details

			System.out.print("Enter your Student Number : "); 
			String Stdno=sc.next();
			System.out.print("Enter your Last Name : ");
			String Lname=sc.next();
			System.out.print("Enter your First name : ");
			String Fname=sc.next();
			System.out.print("Enter your Module : ");
			String Module=sc.next();
			pw.println(Stdno+"\t"+Lname+"\t"+Fname);				
			ppw.println(Stdno+"\t"+Module);

			// writing to files

			if (Module.equalsIgnoreCase("ECSC410")){ 
				File ECSC410=new File("ECSC410.txt");
				fffw=new FileWriter(ECSC410,true);
				pppw=new PrintWriter(fffw,true);
				pppw.println(Stdno+"\t"+Lname+"\t"+Fname);
			} else if (Module.equalsIgnoreCase("ECSC412")){
				File ECSC412=new File("ECSC412.txt");
				fffw=new FileWriter(ECSC412,true);
				pppw=new PrintWriter(fffw,true);
				pppw.println(Stdno+"\t"+Lname+"\t"+Fname);
			} else if (Module.equalsIgnoreCase("ECSC413")){
				File ECSC413=new File("ECSC413.txt");
				fffw=new FileWriter(ECSC413,true);
				pppw=new PrintWriter(fffw,true);
				pppw.println(Stdno+"\t"+Lname+"\t"+Fname);
			} else if (Module.isEmpty()){
				System.out.println("No input has been made, Try Again!!");
			} else
				System.out.println("Invalid Input");
			System.out.println("Successfully added "+Fname+ " to file");
		} catch (Exception e) {
			System.out.println("Adding Student to File was unsuccessful. Please Try Again!!");
		}finally {
			pw.close();							
		}
	}
	public static void EditStudentFile() {
		sc = new Scanner(System.in);
		System.out.print("Enter your Student Number : ");
		while (!sc.hasNextInt()) {
			System.out.println("That's not a number!");
			sc.next();
		}
		//convert to string
		String StudentNum = Integer.toString(sc.nextInt());
		System.out.print("Enter your First Name : ");
		String FName = sc.next();
		System.out.print("Enter your Last name : ");
		String LName=sc.next();	 
		try {
			// open student details text file
			FileInputStream f = new FileInputStream("studentsdetails.txt");
			BufferedReader r = new BufferedReader(new InputStreamReader(f));
			String line;
			StringBuilder str = new StringBuilder();

			// Read everything line by line
			while ((line = r.readLine()) != null) {
				// splitting data to an array
				String words[] = line.split("\t");
				if (words.length > 0) {
					if (words[0].contains(StudentNum)) {					
						words[1] = LName;
						words[2] = FName;
						String newLine = words[0] + "\t" + words[1]+"\t"+words[2];
						str.append(newLine);
						str.append(System.getProperty("line.separator"));

					} else {
						str.append(line);
						str.append(System.getProperty("line.separator"));						
					}
				} 
			}
			//writing to file
			FileWriter writer = new FileWriter("studentsdetails.txt");
			BufferedWriter bufferWrite2 = new BufferedWriter(writer);
			bufferWrite2.write(str.toString());
			bufferWrite2.close();
			System.out.println("Successfully Editing Student File.");
		} catch (Exception e) {
			System.out.println("Sorry, Please Try Again!");

		}

	}
	public static void AddLecturerFile(){

		File lecturerfile=new File("lecturer.txt");	
		PrintWriter pw=null;
		FileWriter fw=null;
		try {
			fw=new FileWriter(lecturerfile,true);
			pw=new PrintWriter(fw,true);
			//getting details
			System.out.print("Enter unit ID : ");
			String UnitId=sc.nextLine();
			System.out.print("Enter unit Name : ");
			String UnitName=sc.nextLine();
			System.out.print("Enter Room Number : ");
			String RoomNo=sc.nextLine();
			System.out.print("Enter Room Name : ");
			String RoomName=sc.nextLine();
			System.out.print("Enter Lecturer Name : ");
			String LecName=sc.nextLine();
			System.out.print("Enter Room Capacity : ");
			String RoomCap=sc.nextLine();
			System.out.print("Enter No of Students Enrolled : ");
			String StudentsEn=sc.nextLine();
			//writing to file
			pw.println(UnitId+"\t"+UnitName+"\t"+RoomNo+"\t"+RoomName+"\t"
					+LecName+"\t"+RoomCap+"\t"+StudentsEn);		
			System.out.println("Successfully added "+UnitId+ " to file");
		} catch (Exception e) {
			System.out.println("Sorry, Try Again");
		}finally {
			pw.close();							
		}	

	}
	public static void EditLecturerFile(){			 

		try{
			//getting details
			System.out.print("Enter unit ID : ");
			String UnitId=sc.nextLine();
			System.out.print("Enter unit Name : ");
			String UnitName=sc.nextLine();
			System.out.print("Enter Room Number : ");
			String RoomNo=sc.nextLine();
			System.out.print("Enter Room Name : ");
			String RoomName=sc.nextLine();
			System.out.print("Enter Lecturer Name : ");
			String LecName=sc.nextLine();
			System.out.print("Enter Room Capacity : ");
			String RoomCap=sc.nextLine();
			System.out.print("Enter No of Students Enrolled : ");
			String StudentsEn=sc.nextLine();	
			FileInputStream file = new FileInputStream("lecturer.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			String line;
			StringBuilder str = new StringBuilder();
			//reading file line by line
			while ((line = reader.readLine()) != null) {
				String words[] = line.split("\t");
				if (words.length > 0) {
					// Assigning Words[i] from the input taken
					if (words[4].contains(LecName)) {
						if (UnitId != null)
							words[0] = UnitId;
						if (UnitName != null)
							words[0] = UnitName;
						if (RoomNo != null)
							words[2] = RoomNo;
						if(RoomName!=null)
							words[3] = RoomName;
						if(LecName!=null)
							words[4] = LecName;
						if (RoomCap != null)
							words[5] = RoomCap;
						if (StudentsEn  != null)
							words[6] = StudentsEn ;
						String newLine = words[0] + "\t" + words[1]+ "\t" + words[2]+ "\t" + words[3]+ "\t" + words[4]+"\t"+words[5]+"\t"+words[6];					
						str.append(newLine);
						str.append(System.getProperty("line.separator"));

					} else {
						str.append(line);
						str.append(System.getProperty("line.separator"));
					}
				} 							
			}
			//writing to file
			FileWriter writer = new FileWriter("lecturer.txt");
			BufferedWriter bufferWrite2 = new BufferedWriter(writer);
			bufferWrite2.write(str.toString());
			bufferWrite2.close();
			System.out.println("Editing lecturer was successful.");
		}catch (Exception e){
			System.out.println("Editing unsuccessful");
		}
	}
	public static void AttendCheck() {
		String nl = System.getProperty("line.separator");
		System.out.print("Enter Lecturer Name : ");
		String name=sc.nextLine();
		System.out.print("Enter Password      : ");
		String password=sc.nextLine();
		String str="";
		String str2="";
		String str3="";
		String str4="";
		String str5="";
		List<String> arr1= new ArrayList<String>();
		List<String> arr2= new ArrayList<String>();
		List<String> arr4= new ArrayList<String>();
		List<String> arr6= new ArrayList<String>();
		File a=new File("attendancelog.txt");
		File b=new File("studentsdetails.txt");	
		// for case 1
		//check log in
		if ((name.equalsIgnoreCase("Dr.Foster"))&&(password.equals("foster@123"))){
			System.out.println("Login Successfull");
			File u=new File("ECSC410.txt");
			Scanner s=null;
			Scanner z=null;	
			Scanner x=null;
			Scanner l=null;
			try {
				s=new Scanner(a);
				z=new Scanner(b);
				l=new Scanner(u);
				//reading file to be stored in array list
				while(s.hasNextLine()){
					str=s.nextLine();				
					String[]arr=str.split("\t");
					if (arr[2].contains("ECSC410")){
						str3=arr[1];
						arr1.add(str3);

					} 
				}
				//reading file to be stored in array list
				while(z.hasNextLine()){
					str2=z.nextLine();
					String[]arr3=str2.split("\t");
					for(int i=0;i<arr1.size();i++){
						if (arr3[0].contains(arr1.get(i))){
							arr2.add(str2);

							break;
						} 
					}
				}
				//writing to file attendance.txt for that particular module from array
				File q=new File("./ReportGenerateFiles/attendance.txt");
				FileWriter t = new FileWriter(q.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(t);
				for (int i=0;i<arr1.size();i++){					
					bw.write(arr1.get(i));
					bw.newLine();
				}
				bw.close();
				/*checking for attendants and non attendants to 
				create attendance details in general report*/
				while(l.hasNextLine()){
					str5=l.nextLine();			
					arr6.add(str5);
				}			
				String check1="";
				String check2="";						
				Boolean find=false;
				for (int i=0;i<arr6.size();i++){
					find=false;
					check1=arr6.get(i);
					for (int j=0;j<arr2.size();j++){
						check2=arr2.get(j);
						if (check1.equals(check2)){
							arr4.add(check2+"\tYes");
							find=true;
							break;
						}
					}
					if (find!=true){
						arr4.add(check1+"\tNo");
					}
				}	
				//to show in console menu
				for (int i=0;i<arr4.size();i++){
					System.out.println(arr4.get(i));
				}
				//confirming attendance
				System.out.print("Confirm Class Attendance? *Yes[y] or No [n]: ");
				String answer=sc.nextLine();
				if (answer.equalsIgnoreCase("y")){					
					System.out.println("Thankyou, attendance has been confirmed for ECSC410");	
					//if confirmed writing to the particular file
					FileWriter wr = new FileWriter("./ReportGenerateFiles/ECSC410.txt");
					BufferedWriter bufferWrite3 = new BufferedWriter(wr);
					for (int i=0;i<arr4.size();i++){
						bufferWrite3.write(arr4.get(i)+nl);
					}		
					bufferWrite3.close();					
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("Yes");				
					bufferWrite2.close();					
				} else if(answer.isEmpty()){
					System.out.println("No input has been made, System will exit....");
					System.exit(0);
				} else {
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("No");				
					bufferWrite2.close();
					System.out.println("Not Confirmed. Please Confirm to generate Report");
				} 

			} catch(Exception e){	
				System.out.println("Sorry, Please Try Again!");
			}finally {				
				s.close();			
			}

			// for case 2
			//check log in
		} else if ((name.equalsIgnoreCase("Dr.Rathesan"))&&(password.equals("rathesan@123"))){
			System.out.println("Login Successfull");
			File u=new File("ECSC412.txt");
			Scanner s=null;
			Scanner z=null;	
			Scanner x=null;
			Scanner l=null;
			try {
				s=new Scanner(a);
				z=new Scanner(b);
				l=new Scanner(u);
				//reading file to be stored in array list
				while(s.hasNextLine()){
					str=s.nextLine();				
					String[]arr=str.split("\t");
					if (arr[2].contains("ECSC412")){
						str3=arr[1];
						arr1.add(str3);
					} 
				}		
				//reading file to be stored in array list
				while(z.hasNextLine()){
					str2=z.nextLine();
					String[]arr3=str2.split("\t");
					for(int i=0;i<arr1.size();i++){
						if (arr3[0].contains(arr1.get(i))){
							arr2.add(str2);

							break;
						} 
					}
				}
				//writing to file attendance.txt for that particular module from array
				File q=new File("./ReportGenerateFiles/attendance.txt");
				FileWriter t = new FileWriter(q.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(t);
				for (int i=0;i<arr1.size();i++){					
					bw.write(arr1.get(i));
					bw.newLine();
				} 
				bw.close();
				/*checking for attendants and non attendants to 
				create attendance details in general report*/
				while(l.hasNextLine()){
					str5=l.nextLine();			
					arr6.add(str5);
				}			
				String check1="";
				String check2="";						
				Boolean find=false;
				for (int i=0;i<arr6.size();i++){
					find=false;
					check1=arr6.get(i);
					for (int j=0;j<arr2.size();j++){
						check2=arr2.get(j);
						if (check1.equals(check2)){
							arr4.add(check2+"\tYes");
							find=true;
							break;
						}
					}
					if (find!=true){
						arr4.add(check1+"\tNo");
					}
				}	
				//to show in console menu
				for (int i=0;i<arr4.size();i++){
					System.out.println(arr4.get(i));
				}
				//confirm attendance by lecturer
				System.out.print("Confirm Class Attendance? *Yes[y] or No [n]: ");
				String answer=sc.nextLine();
				if (answer.equalsIgnoreCase("y")){					
					System.out.println("Thankyou, attendance has been confirmed for ECSC412");
					//if confirmed writing to the particular file
					FileWriter wr = new FileWriter("./ReportGenerateFiles/ECSC412.txt");
					BufferedWriter bufferWrite3 = new BufferedWriter(wr);
					for (int i=0;i<arr4.size();i++){
						bufferWrite3.write(arr4.get(i)+nl);
					}		
					bufferWrite3.close();	
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("Yes");				
					bufferWrite2.close();					
				} else if (answer.equalsIgnoreCase("n")){
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("No");				
					bufferWrite2.close();	
				}else if(answer.isEmpty()){
					System.out.println("No input has been made, System will exit....");
					System.exit(0);
				} else {
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("No");				
					bufferWrite2.close();	
					System.out.println("Not Confirmed. Please Confirm to generate Report");
				} 


			} catch(Exception e){	
				System.out.println("Sorry, Try Again Please!");
			}finally {				
				s.close();
			}

			// for case 1
			//check log in
		} else if ((name.equalsIgnoreCase("Dr.Aloka"))&&(password.equals("aloka@123"))){
			System.out.println("Login Successfull");
			File u=new File("ECSC413.txt");
			Scanner s=null;
			Scanner z=null;	
			Scanner x=null;
			Scanner l=null;
			try {
				s=new Scanner(a);
				z=new Scanner(b);
				l=new Scanner(u);
				//reading file to be stored in array list
				while(s.hasNextLine()){
					str=s.nextLine();				
					String[]arr=str.split("\t");
					if (arr[2].contains("ECSC413")){
						str3=arr[1];
						arr1.add(str3);
					} 
				}	
				//reading file to be stored in array list
				while(z.hasNextLine()){
					str2=z.nextLine();
					String[]arr3=str2.split("\t");
					for(int i=0;i<arr1.size();i++){
						if (arr3[0].contains(arr1.get(i))){
							arr2.add(str2);

							break;
						} 
					}
				}
				//writing to file attendance.txt for that particular module from array
				File q=new File("./ReportGenerateFiles/attendance.txt");
				FileWriter t = new FileWriter(q.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(t);
				for (int i=0;i<arr1.size();i++){					
					bw.write(arr1.get(i));
					bw.newLine();
				} 

				bw.close();
				/*checking for attendants and non attendants to 
				create attendance details in general report*/
				while(l.hasNextLine()){
					str5=l.nextLine();			
					arr6.add(str5);
				}			
				String check1="";
				String check2="";						
				Boolean find=false;
				for (int i=0;i<arr6.size();i++){
					find=false;
					check1=arr6.get(i);
					for (int j=0;j<arr2.size();j++){
						check2=arr2.get(j);
						if (check1.equals(check2)){
							arr4.add(check2+"\tYes");
							find=true;
							break;
						}
					}
					if (find!=true){
						arr4.add(check1+"\tNo");
					}
				}		
				//to show in console menu
				for (int i=0;i<arr4.size();i++){
					System.out.println(arr4.get(i));
				}
				//confirm attendance by lecturer
				System.out.print("Confirm Class Attendance? *Yes[y] or No [n]: ");
				String answer=sc.nextLine();
				if (answer.equalsIgnoreCase("y")){					
					System.out.println("Thankyou, attendance has been confirmed for ECSC413");
					//if confirmed writing to the particular file
					FileWriter wr = new FileWriter("./ReportGenerateFiles/ECSC413.txt");
					BufferedWriter bufferWrite3 = new BufferedWriter(wr);
					for (int i=0;i<arr4.size();i++){
						bufferWrite3.write(arr4.get(i)+nl);
					}		
					bufferWrite3.close();	
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("Yes");				
					bufferWrite2.close();					
				} else if (answer.equalsIgnoreCase("n")){
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("No");				
					bufferWrite2.close();	
				}else if(answer.isEmpty()){
					System.out.println("No input has been made, System will exit....");
					System.exit(0);
				} else {
					FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
					BufferedWriter bufferWrite2 = new BufferedWriter(writer);
					bufferWrite2.write("No");				
					bufferWrite2.close();
					System.out.println("Not Confirmed. Please Confirm to generate Report");
				} 


			} catch(Exception e){	
				System.out.println("Sorry, Try Again Please!");
			}

		}else if (((name.isEmpty())|| (password.isEmpty()))){
			System.out.println("No input has been made, Try Again!!");
		} else {
			try {
				FileWriter writer = new FileWriter("./ReportGenerateFiles/dat.txt");
				BufferedWriter bufferWrite2 = new BufferedWriter(writer);
				bufferWrite2.write("No");				
				bufferWrite2.close();
				System.out.println("Wrong Username or Password");
			} catch (IOException e) {
				System.out.println("Sorry Try Again");
			}
		}
	}
	public static void GenerateReport() throws IOException{
		Scanner hc=null;
		Scanner bc=null;
		List<String> arr4= new ArrayList<String>();
		try {
			File d=new File("attendancelog.txt");
			File f=new File("lecturer.txt");
			File c=new File("Report1.txt");	
			File r=new File("Report2.txt");	
			File u=new File("Report3.txt");	

			// if file does not exists, then create it
			if (!c.exists()) {
				c.createNewFile();
			}
			if (!r.exists()) {
				c.createNewFile();
			}
			if (!u.exists()) {
				c.createNewFile();
			}
			hc=new Scanner(f);
			bc=new Scanner(d);
			String[]arr={};
			String[]arr2={};
			List<String> arr3= new ArrayList<String>();
			String line="";
			String line2="";	
			/*line separator that can be used instead \n */
			String nl = System.getProperty("line.separator");							
			System.out.println("Generate Report: [a] ECSC410");
			System.out.println("               : [b] ECSC412");
			System.out.println("               : [c] ECSC413\n\n");
			System.out.print("            Enter a or b or c: ");
			String answer=sc.next();
			if (answer.equalsIgnoreCase("a")){			
				Scanner a=null;
				Scanner b=null;
				Scanner h=null;
				File p=new File("./ReportGenerateFiles/ECSC410.txt");			
				a=new Scanner(p);
				while (a.hasNextLine()){
					String s=a.nextLine();
					arr3.add(s);
				}
				a.close();
				File q=new File("./ReportGenerateFiles/dat.txt");			
				b=new Scanner(q);
				String ans=b.next();
				b.close();
				File y=new File("./ReportGenerateFiles/attendance.txt");			
				h=new Scanner(y);
				while (h.hasNextLine()){
					String str=h.nextLine();
					arr4.add(str);
				}
				//reading from lecturer.txt
				while (hc.hasNextLine()){ 
					line=hc.nextLine();					
					arr=line.split("\t");					
					if (arr[0].equals("ECSC410")){
						break;
					}
				}
				//reading from attendancelog.txt
				while (bc.hasNextLine()){ 
					line2=bc.nextLine();			
					arr2=line2.split("\t");					
					if (arr2[2].equals("ECSC410")){						
						break;
					}
				}		
				//Storing variables to report
				String week=arr2[5];
				String date=arr2[4];
				double divid=Integer.parseInt(arr[5]);
				double size=arr4.size();
				double percentage=(size/divid)*100;
				FileWriter fw = new FileWriter(c.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Unit          : "+arr[0]+nl+nl
						+"UnitName      : "+arr[1]+nl+nl
						+"Room          : "+arr[2]+nl+nl
						+"Name          : "+arr[3]+nl+nl
						+"Lecturer      : "+arr[4]+nl+nl
						+"Week          : "+week+nl+nl
						+"Date          : "+date+nl+nl+nl
						+"StudNo\tLName\tFName\tPresent"+nl);
				//reading file and getting attendance details
				for (int i=0;i<arr3.size();i++){
					bw.write(arr3.get(i)+nl);
				}
				bw.write(nl+"Lecturer confirmed attendance : "+ans+nl+nl
						+"Students enrolled             : "+arr[5]+nl+nl
						+"Attendance:                   : "+size+nl+nl
						+"Room Capacity                 : "+arr[5]+nl+nl
						+"Percentage Occupancy          : "+(int)percentage+"%");
				bw.close();
				System.out.println("Report Generated Successfully at main folder(Report1.txt)");	
				h.close();
			}
			if (answer.equalsIgnoreCase("b")){			
				Scanner a=null;
				Scanner b=null;
				Scanner h=null;
				File p=new File("./ReportGenerateFiles/ECSC412.txt");			
				a=new Scanner(p);
				while (a.hasNextLine()){
					String s=a.nextLine();
					arr3.add(s);
				}
				File q=new File("./ReportGenerateFiles/dat.txt");			
				b=new Scanner(q);
				String ans=b.next();
				File y=new File("./ReportGenerateFiles/attendance.txt");			
				h=new Scanner(y);
				while (h.hasNextLine()){
					String str=h.nextLine();
					arr4.add(str);
				}
				//reading from lecturer.txt
				while (hc.hasNextLine()){
					line=hc.nextLine();					
					arr=line.split("\t");					
					if (arr[0].equals("ECSC412")){
						break;
					}
				}
				//reading from attendancelog.txt
				while (bc.hasNextLine()){
					line2=bc.nextLine();			
					arr2=line2.split("\t");					
					if (arr2[2].equals("ECSC412")){						
						break;
					}
				}			
				//storing variables to report
				String week=arr2[5];
				String date=arr2[4];
				double divid=Integer.parseInt(arr[5]);
				double size=arr4.size();
				double percentage=(size/divid)*100;
				FileWriter fw = new FileWriter(r.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Unit          : "+arr[0]+nl+nl
						+"UnitName      : "+arr[1]+nl+nl
						+"Room          : "+arr[2]+nl+nl
						+"Name          : "+arr[3]+nl+nl
						+"Lecturer      : "+arr[4]+nl+nl
						+"Week          : "+week+nl+nl
						+"Date          : "+date+nl+nl+nl
						+"StudNo\tLName\tFName\tPresent"+nl);
				//reading from file to get attendance details
				for (int i=0;i<arr3.size();i++){
					bw.write(arr3.get(i)+nl);
				}
				bw.write(nl+"Lecturer confirmed attendance : "+ans+nl+nl
						+"Students enrolled             : "+arr[5]+nl+nl
						+"Attendance:                   : "+size+nl+nl
						+"Room Capacity                 : "+arr[5]+nl+nl
						+"Percentage Occupancy          : "+(int)percentage+"%");
				bw.close();
				System.out.println("Report Generated Successfully at main folder(Report2.txt)");	
				a.close();
				b.close();
				h.close();
			}
			if (answer.equalsIgnoreCase("c")){			
				Scanner a=null;
				Scanner b=null;
				Scanner h=null;
				File p=new File("./ReportGenerateFiles/ECSC413.txt");			
				a=new Scanner(p);
				while (a.hasNextLine()){
					String s=a.nextLine();
					arr3.add(s);
				}
				File q=new File("./ReportGenerateFiles/dat.txt");			
				b=new Scanner(q);
				String ans=b.next();
				File y=new File("./ReportGenerateFiles/attendance.txt");			
				h=new Scanner(y);
				while (h.hasNextLine()){
					String str=h.nextLine();
					arr4.add(str);
				}
				//reading from lecturer.txt
				while (hc.hasNextLine()){ 
					line=hc.nextLine();					
					arr=line.split("\t");					
					if (arr[0].equals("ECSC413")){
						break;
					}
				}
				//reading from attendancelog.txt
				while (bc.hasNextLine()){ 
					line2=bc.nextLine();			
					arr2=line2.split("\t");					
					if (arr2[2].equals("ECSC413")){						
						break;
					}
				}	
				//storing variable to report
				String week=arr2[5];
				String date=arr2[4];
				double divid=Integer.parseInt(arr[5]);
				double size=arr4.size();
				double percentage=(size/divid)*100;
				FileWriter fw = new FileWriter(u.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Unit          : "+arr[0]+nl+nl
						+"UnitName      : "+arr[1]+nl+nl
						+"Room          : "+arr[2]+nl+nl
						+"Name          : "+arr[3]+nl+nl
						+"Lecturer      : "+arr[4]+nl+nl
						+"Week          : "+week+nl+nl
						+"Date          : "+date+nl+nl+nl
						+"StudNo\tLName\tFName\tPresent"+nl);
				//reading from file to get attendance details
				for (int i=0;i<arr3.size();i++){
					bw.write(arr3.get(i)+nl);
				}
				bw.write(nl+"Lecturer confirmed attendance : "+ans+nl+nl
						+"Students enrolled             : "+arr[5]+nl+nl
						+"Attendance:                   : "+size+nl+nl
						+"Room Capacity                 : "+arr[5]+nl+nl
						+"Percentage Occupancy          : "+(int)percentage+"%");
				bw.close();
				System.out.println("Report Generated Successfully at main folder(Report3.txt)");	
				a.close();
				b.close();
				h.close();
			} else if (answer.isEmpty()){
				System.out.println("No input has been made, Try Again!!");
			} 			
		}catch(Exception e){
			System.out.println("Sorry, Try Again Please!");

		}

	}
	public static String Menu(){
		//Main Menu to be displayed
		System.out.println("     \n\n\tWelcome to Report Generating        ");
		System.out.println("\tAdd a student record to file   | Type 'a' ");
		System.out.println("\tAdd a lecturer record to file  | Type 'b' ");
		System.out.println("\tEdit a student record to file  | Type 'c' ");
		System.out.println("\tEdit a lecturer record to file | Type 'd' ");
		System.out.println("\tTo Verify and Generate Report  | Type 'e' ");
		System.out.println("\t                      To exit  | Type 'f' ");
		System.out.println("\n");
		System.out.print("\t                   Enter Here | ");
		String ans=sc.nextLine();
		if (ans.equals("")){
			Scanner bg=new Scanner(System.in);
			ans=bg.nextLine();
		}

		return ans;

	}
	public static void Control()throws IOException{
		//calls menu method and stores return value
		String ans=Menu();	
		/*check ans variable and call method accordingly*/
		if (ans.equalsIgnoreCase("a")){
			AddStudentFile();
		}else if (ans.equalsIgnoreCase("b")){
			AddLecturerFile();
		}else if (ans.equalsIgnoreCase("c")){
			EditStudentFile();
		}else if (ans.equalsIgnoreCase("d")){
			EditLecturerFile();
		}else if (ans.equalsIgnoreCase("e")){
			AttendCheck();
			File b=new File("./ReportGenerateFiles/dat.txt");	
			Scanner c=null;
			c=new Scanner(b);
			String validate=c.nextLine();
			if (validate.equals("Yes")){
				System.out.print("Do you want to generate report? Yes or No ");
				String answer=sc.next();
				if (answer.equalsIgnoreCase("Yes")){
					GenerateReport();
				} else 
					Control();
			}else if(validate.equals("No")){
				System.out.println("Please Validate Attendance before Generating Report");
			}
		}else if(ans.equalsIgnoreCase("f")){
			System.exit(0);
		}else if(ans.equalsIgnoreCase("")){
			Control();
		}else if (ans.isEmpty()){
			System.out.println("No input has been made, Try Again!!");
		} else
			System.out.println("Invalid Input");	
	}
	public static void main(String[] args) throws IOException{
		String exit="y";
		//to loop exit
		while (exit.toLowerCase()!="n"){
			Control();
			System.out.print("Do you want to continue ? | 'Y' or 'N' | :  ");
			exit=(sc.next());
			if (exit.isEmpty()){
				System.out.println("No input has been made. Exiting......");
				System.exit(0);
			} else if((!exit.equalsIgnoreCase("y"))||(!exit.equalsIgnoreCase("y"))){
				System.out.println("Invalid Input. Exiting.....");
				System.exit(0);
			}
		}
	}	   
}