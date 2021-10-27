package com.bridgelab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EmployeePayRollServiceTest {
	private Assertions Assert;

	@Test
	public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		EmployeePayRoll[] arrayOfEmps = { new EmployeePayRoll(1, "Jeff Bezos", 100000.0),
				new EmployeePayRoll(2, "Bill Gates", 200000.0), new EmployeePayRoll(3, "Mark Zuckerberg", 300000.0) };
		EmployeePayRollService employeePayrollService;
		employeePayrollService = new EmployeePayRollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(EmployeePayRollService.IOService.FILE_IO);
		long entries = employeePayrollService.count(EmployeePayRollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}

	@Test
	public void given3Employees_WhenWrittenToFile_ShouldPrintEmployeeEntries() {
		EmployeePayRoll[] arrayOfEmps = { new EmployeePayRoll(1, "Jeff Bezos", 100000.0),
				new EmployeePayRoll(2, "Bill Gates", 200000.0), new EmployeePayRoll(3, "Mark Zuckerberg", 300000.0) };
		EmployeePayRollService employeePayrollService;
		employeePayrollService = new EmployeePayRollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(EmployeePayRollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayRollService.IOService.FILE_IO);
		long entries = employeePayrollService.count(EmployeePayRollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}

	@Test
	public void givenFile_onReadingFromFile_shouldMatchEmployeeCount() {
		EmployeePayRollService employeePayrollService = new EmployeePayRollService();
		employeePayrollService.readDataFromFile(EmployeePayRollService.IOService.FILE_IO);
		long entries = employeePayrollService.count(EmployeePayRollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
}