package com.Lockers.pvt.ltd;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class LockedMe {
	static File folder = new File("J:\\Java Project\\Lockers");

	public static void retreiveFiles() {
		File[] listoffiles = folder.listFiles();
		System.out.println("Retreiving Files...\n");
		for (File myFiles : listoffiles) {
			System.out.println(myFiles.getName());
		}
		System.out.println();
	}

	public static void createNewFile(Scanner scannerCreate) {
		FileWriter writer = null;
		try {
			System.out.println("Enter File Name");
			String filename = scannerCreate.nextLine() + ".txt";

			File newfile = new File(folder, filename);
			writer = new FileWriter(newfile);
			System.out.println("Add data in your file");
			writer.write(scannerCreate.nextLine());
			writer.close();
			System.out.println("File Created Successfully\n");
		} catch (Exception e) {
			System.out.println("Oops Something Goes Wrong...\n");
		}
	}

	public static void addExistingFile(Scanner scannerAdd) {
		try {
			System.out.println("Enter File Path");
			String filePath = scannerAdd.nextLine();

			File source_file = new File(filePath);
			File destination_file = new File(folder, source_file.getName());

			Files.copy(source_file.toPath(), destination_file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File copied successfully.\n");

		} catch (Exception e) {
			System.out.println("Enter Valid Path\n");
		}
	}

	public static void searchFile(Scanner scannerSearch) {
		try {
			System.out.println("Enter Name of Required File");
			String filename = scannerSearch.nextLine();

			File filelist = new File(folder,filename);
			if(filelist.exists()) {
				System.out.println("File Exists "+filelist.getAbsolutePath()+"\n");
			}else {
				System.out.println("File does not exist\n");
			}

		} catch (Exception e) {
			System.out.println("Error in serching the file\n");
		}
	}

	public static void deleteFile(Scanner scannerDelete) {
		try {
			System.out.println("Enter file name to delete");
			String name = scannerDelete.nextLine();
			File file = new File(folder, name);

			if (file.delete()) {
				System.out.println("File deleted successfully.\n");
			} else {
				System.out.println("Failed to delete the file.\n");
			}

		} catch (Exception e) {
			System.out.println("There was an error\n");
		}
	}

	public static void main(String[] args) {
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("        Welcome to LockedMe");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("Developed by   \"Amit Kumar Thathera\"\n");
		System.out.println("Starting Application.......\n");

		Scanner scanner = new Scanner(System.in);
		Integer choice = 0;
		while (choice != 3) {
			System.out.println("1: Retrieve all Files");
			System.out.println("2: Handling Operations");
			System.out.println("3: Exit\n");

			try {
				System.out.println("Enter Your Choice");
				choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:
					retreiveFiles();
					break;

				case 2:
					Integer choice_1 = 0;
					while (choice_1 != 4) {
						System.out.println("1: Add Files");
						System.out.println("2: Search Files");
						System.out.println("3: Delete Files");
						System.out.println("4: Return to Main Menu\n");

						try {
							System.out.println("Enter Your Choice");
							choice_1 = Integer.parseInt(scanner.nextLine());

							switch (choice_1) {
							case 1:
								System.out.println("a: Create New File ");
								System.out.println("b: Add Existing File\n ");

								try {
									System.out.println("Enter Your Choice");
									String choice_2 = scanner.nextLine();

									switch (choice_2) {
									case "a":
										createNewFile(scanner);
										break;

									case "b":
										addExistingFile(scanner);
										break;

									default:
										System.out.println("Enter a Valid Input\n");
									}

								} catch (Exception e) {
									System.out.println("Enter a Valid Input\n");
								}
								break;

							case 2:
								searchFile(scanner);
								break;

							case 3:
								deleteFile(scanner);
								break;

							case 4:
								System.out.println("Returning to main menu...\n");
								break;

							default:
								System.out.println("Enter a Valid Input\n");
							}

						} catch (NumberFormatException e) {
							System.out.println("Please Input a Number\n");
						}
					}
				case 3:
					break;

				default:
					System.out.println("Enter a Valid Input\n");

				}
			} catch (NumberFormatException e) {
				System.out.println("Please Input a Number\n");
			}

		}
		System.out.println("Process finished with exit code 0");
	}

}
