package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException 
	{
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String	departmentName = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nivel do colaborador: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department (departmentName));
		
		System.out.println("Quantos contratos este trabalhador está associado? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
		{
			System.out.println("Entre com os dados do contrato #" + (i+1));
			System.out.print("Entre com a data do contrato (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valueHour = sc.nextDouble();
			System.out.print("Duração: ");
			int duration = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valueHour, duration);
			worker.addContract(contract);	
		}
		System.out.println();
		System.out.print("Entre com mês e ano (MM/YYYY), para calcular o salário: ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Salário calculado em base de " + monthAndYear + ": R$ " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}


}
