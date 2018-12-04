package chocan;

import static chocan.Terminal.ReadMember;
import static chocan.Terminal.ReadProviders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateReport {

	/*
	 * Generate desired member report and calls print member report
	 */
	public static void generateMember() throws FileNotFoundException, IOException{
		ArrayList<MemberAccounts> members = ReadMember();

		for (MemberAccounts ma : members) {
			printMemberReport(ma, ma.getName());

		}

		System.out.println("The member does not exist");
		return;
	}

	public static void generateIndividualMember(int number) throws FileNotFoundException, IOException{
		ArrayList<MemberAccounts> members = ReadMember();

		for (MemberAccounts ma : members) {
			if (ma.getNumber() == number) {
				printMemberReport(ma, ma.getName());
				return;
			}

		}

		System.out.println("The member does not exist");
		return;
	}
	/*
	 * Generate desired provider report and calls print provider report
	 */
	public static void generateProvider() throws FileNotFoundException, IOException{
		ArrayList<ProviderAccounts> providers = ReadProviders();

		for (ProviderAccounts pa : providers) {

			printProviderReport(pa, pa.getName());

		}

		System.out.println("The provider does not exist");
		return;
	}

	public static void generateIndividualProvider(int number) throws FileNotFoundException, IOException{
		ArrayList<ProviderAccounts> providers = ReadProviders();

		for (ProviderAccounts pa : providers) {
			if (pa.getNumber() == number) {
				printProviderReport(pa, pa.getName());
				return;
			}
		}

		System.out.println("The provider does not exist");
		return;
	}

	/*
	 * Prints the summary report (used by Manager)
	 */
	public static void printSummaryReport(String name) throws FileNotFoundException,IOException{
		ArrayList<ProviderAccounts> providers = ReadProviders();

		String filename = "writtenFiles/ServiceRecords/"+name+".txt";
		double totalFee = 0;
		int totalConsults = 0;

		File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
		try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
			for (ProviderAccounts pa : providers) {
				ArrayList<ServiceRecord> sr = pa.getServicesProvided();
				input.write(pa.getName()+",");
				if(sr == null) {
					input.write("0"+","+"0\n");
				}
				else {
					input.write(pa.getNumberServices()+",");
					input.write(pa.getTotalFees(sr)+"\n");
					totalConsults = totalConsults + pa.getNumberServices();
					totalFee = totalFee + pa.getTotalFees(sr);
				}
			}
			input.write("Total number of providers: "+providers.size()+"\n");
			input.write("Total number of consultations: "+totalConsults+"\n");
			input.write("Total number of fees: $"+totalFee+"\n");
			input.close();
		}

		System.out.print("\n"+"The summary report was successfully generated and stored in "+name+".txt"+"\n");

		return;
	}

	/*
	 * Prints the member report (used by Manager)
	 */
	public static void printMemberReport(MemberAccounts member, String name) throws FileNotFoundException, IOException{

		String filename = "writtenFiles/MemberReports/"+name+".txt";

		File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
		try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
			input.write(member.getName()+"\n"+member.getNumber()+"\n"+member.getAddress()+"\n"+member.getCity()+"\n"+member.getState()+"\n"+member.getZipCode()+"\n");

			ArrayList<ServiceRecord> sr = member.getServicesProvided();
			if (sr != null) {
				for(ServiceRecord service : sr) {
					input.write(service.getDateOfService()+"\n"+service.getProviderName(service.getProviderNumber())+"\n"+service.getServiceName(service.getServiceCode())+"\n");
				}
			}

			input.close();
		}

		System.out.print("\n"+"The member report was successfully generated and stored in "+name+".txt"+"\n");
	}


	/*
	 * Prints the provider report (used by Manager)
	 */
	public static void printProviderReport(ProviderAccounts provider, String name) throws FileNotFoundException, IOException{
		//ArrayList<ProviderAccounts> pa = ReadProviders();

		double totalFee = 0;
		String filename = "writtenFiles/ProviderReports/"+name+".txt";

		File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
		try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
			input.write(provider.getName()+"\n"+provider.getNumber()+"\n"+provider.getAddress()+"\n"+provider.getCity()+"\n"+provider.getState()+"\n"+provider.getZipCode()+"\n");

			ArrayList<ServiceRecord> sr = provider.getServicesProvided();
			if (sr != null) {
				for(ServiceRecord service : sr) {
					input.write(service.getDateOfService()+"\n"+service.getCurrentDateTime()+"\n"+service.getMemberName(service.getMemberNumber())+"\n"+service.getMemberNumber()+"\n"+service.getServiceCode()+"\n"+service.getServiceFee(service.getServiceCode())+"\n");
					totalFee = totalFee + service.getServiceFee(service.getServiceCode());
				}
				input.write("Total number of consultations with members: "+sr.size()+"\n");
				input.write("Total fees for the week: $"+totalFee+"\n");
			}
			else {
				input.write("Total number of consultations with members: 0\n");
				input.write("Total fees for the week: $0\n");
			}
			input.close();
		}

		System.out.print("\n"+"The provider report was successfully generated and stored in "+name+".txt"+"\n");
	}
}
