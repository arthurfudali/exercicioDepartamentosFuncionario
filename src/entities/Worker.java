package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department deparment;
	private List<HourContract> contracts = new ArrayList<HourContract>(); // cria em forma de lista pois podem existir varios
															// contratos, diferente do
	// departamento

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department deparment) {
		// as listas (contracts) não devem ser criadas no construtor;
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.deparment = deparment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDeparment() {
		return deparment;
	}

	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// public void setContracts(List<HourContract> contracts) {
	// this.contracts = contracts;
	// }

	// esse setContracts não pode existir pois ele troca a lista que esta atribuida
	// ao 'contracts', isso so deve ser modificado por meio dos metodos abaixo

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

}
