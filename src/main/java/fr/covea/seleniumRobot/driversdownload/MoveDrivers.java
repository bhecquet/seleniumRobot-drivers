package fr.covea.seleniumRobot.driversdownload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

public class MoveDrivers {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String root = args[0]; // /someRoot/drivers/
		String os = args[1];
		String skipCleanDriver = args[2];
		
		String extension = "";
		if (os.equals("windows")) {
			extension = ".exe";
		}
		
		// delete old drivers
		if ("false".equals(skipCleanDriver)) {
			for (String driverDir: new File(root + os).list()) {
				File file = Paths.get(root, os, driverDir).toFile();
				if (!file.isDirectory()) {
					System.out.println("deleting driver " + file);
					FileUtils.forceDelete(file);
				}
			}
		}
		
		for (String driverDir: new File(root + os).list()) {
			if (driverDir.contains("chromedriver") && Paths.get(root, os, driverDir).toFile().isDirectory()) {
				System.out.println("moving driver " + driverDir);
				Files.copy(Paths.get(root, os, driverDir, "chromedriver" + extension), 
							Paths.get(root, os, driverDir.replace("dir_", "") + extension), 
							StandardCopyOption.REPLACE_EXISTING);
				FileUtils.deleteDirectory(Paths.get(root, os, driverDir).toFile());
			}
			else if (driverDir.contains("geckodriver") && Paths.get(root, os, driverDir).toFile().isDirectory()) {
				System.out.println("moving driver " + driverDir);
				Files.copy(Paths.get(root, os, driverDir, "geckodriver" + extension), 
						Paths.get(root, os, driverDir.replace("dir_", "") + extension), 
						StandardCopyOption.REPLACE_EXISTING);
				FileUtils.deleteDirectory(Paths.get(root, os, driverDir).toFile());
			}
			else if (driverDir.contains("IEDriverServer") && Paths.get(root, os, driverDir).toFile().isDirectory()) {
				System.out.println("moving driver " + driverDir);
				Files.copy(Paths.get(root, os, driverDir, "IEDriverServer" + extension), 
						Paths.get(root, os, driverDir.replace("dir_", "") + extension), 
						StandardCopyOption.REPLACE_EXISTING);
				FileUtils.deleteDirectory(Paths.get(root, os, driverDir).toFile());
			}
			else if (driverDir.contains("edgedriver") && Paths.get(root, os, driverDir).toFile().isDirectory()) {
				System.out.println("moving driver " + driverDir);
				Files.copy(Paths.get(root, os, driverDir, "msedgedriver" + extension), 
						Paths.get(root, os, driverDir.replace("dir_", "") + extension), 
						StandardCopyOption.REPLACE_EXISTING);
				FileUtils.deleteDirectory(Paths.get(root, os, driverDir).toFile());
			}
		}
	}

}
