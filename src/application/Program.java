package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyPayer;
import entities.IndividualPayer;
import entities.Payer;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Payer> list = new ArrayList<Payer>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditure = sc.nextDouble();
				list.add(new IndividualPayer(name, anualIncome, healthExpenditure));
			} else if(ch == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new CompanyPayer(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double totalTaxes = 0.0;
		for(Payer payer : list) {
			System.out.println(payer.getName() + ": $" + String.format("%.2f", payer.taxPayment()));
			totalTaxes += payer.taxPayment();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + totalTaxes);
		
		sc.close();
		
	}
}
