package com.bridgelab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

public class EmployeePayRollFileIOService {

	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	public void writeData(List<EmployeePayRoll> employeePayrollDataList) {
		final StringBuffer empBuffer = new StringBuffer();
		employeePayrollDataList.forEach(new Consumer<EmployeePayRoll>() {
			@Override
			public void accept(EmployeePayRoll employee) {
				String employeeDataString = employee.toString().concat("\n");
				empBuffer.append(employeeDataString);
			}
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
