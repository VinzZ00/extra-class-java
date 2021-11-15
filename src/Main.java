import java.util.Calendar;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner sc = new Scanner(System.in);	
	String Usernamevalid = "";
	
	
	// alt + shift + y
	public Main() {
		String a = "Hello";
		System.out.println(a.equalsIgnoreCase("hELLO"));
		
		// pengunaan do while
//		do {
//			System.out.println("Hellow world");
//		} while (false);
		
		
		for (int i = 0; i <= 10; i++) {
			//break; ? => menberhentikans sebuah iteration (untuk di iteration) menjadi pembatas antar kasus di switch case(switch & case)
			//continue; > => menskip 1 kali iteration dengan yang di kondisikan
			
			System.out.println("ini angka ke" + i);
			if (i == 5) {
				continue;
			}
			System.out.println("test jalan");
		}
		
		// TODO Auto-generated constructor stub
		String nama;
		String DOB;
		
		System.out.println("Selamat datang ke username dan password generator");
		System.out.println("=================================================");
		System.out.print("\nSilahkan masukkan nama anda : ");
		nama = sc.nextLine();
		System.out.println("Silahkan masukkan tanggal lahir anda (ddmmyyyy) : ");
		DOB = sc.nextLine();
		if (!(DOB.length() == 8)) {
			System.out.println("Salah masukan tanggal lahir, harap gunakan bentuk ddmmyyyy");
			System.exit(0);
		}
		int tanggal = 0, bulan = 0, tahun = 0;
		
		
		try {
			tanggal = Integer.valueOf(DOB.substring(0,2));
			bulan = Integer.valueOf(DOB.substring(2,4));
			tahun = Integer.valueOf(DOB.substring(4));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Program tidak bisa mencerna tanggal selain dari angka dengan format ddmmyyyy");
		}
		
		boolean leap = leap(tahun);
		boolean umurvalid = false;
		
		if (leap) {
			if (bulan == 2) {
				if (!(tanggal <= 29 && tanggal > 0) ) {
					System.out.println("hari di bulan " + bulan + " tidak boleh lebih dari 29 dan kurang dari 1");
					System.exit(0);
				}
			} else if (bulan == 1 || bulan == 3 || bulan == 5 || bulan == 7 || bulan == 8 || bulan == 10 || bulan == 12 ) {
				if (!(tanggal <= 31 && tanggal > 0)) {
					System.out.println("hari di bulan " + bulan + " tidak boleh lebih dari 31 dan kurang dari 1");
					System.exit(0);
				}
			} else if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11 ) {
				if (!(tanggal <= 30 && tanggal > 0)) {
					System.out.println("hari di bulan " + bulan + " tidak boleh lebih dari 30 dan kurang dari 1");
					System.exit(0);
				}	
			} else {
				System.out.println("tolong masukan bulan diantara 1 - 12");
			}
				
		} else if (!leap) {
			if (bulan == 2) {
				if (!(tanggal <= 28 && tanggal > 0) ) {
					System.out.println("hari di bulan " + bulan + " tidak boleh lebih dari 28 dan kurang dari 1");
					System.exit(0);
				}
			} else if (bulan == 1 || bulan == 3 || bulan == 5 || bulan == 7 || bulan == 8 || bulan == 10 || bulan == 12 ) {
				if (!(tanggal <= 31 &&tanggal > 0)) {
					System.out.println("hari di bulan " + bulan + " tidak boleh lebih dari 31 dan kurang dari 1");
					System.exit(0);
				}
			} else if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11 ) {
				if (!(tanggal <= 30 && tanggal > 0)) {
					System.out.println("hari di bulan " + bulan + " tidak boleh lebih dari 30 dan kurang dari 1");
					System.exit(0);
				}	
			} else {
				System.out.println("tolong masukan bulan diantara 1 - 12");
			}
		}
		
		int bulanvalid = bulan;
		int tahunvalid = tahun;
		bulanvalid = (tanggal - Calendar.getInstance().get(Calendar.DATE) <= 0) ? (bulan+= 0) : (bulan += 1); 
		tahunvalid = (bulanvalid - (Calendar.getInstance().get(Calendar.MONTH)+1) <= 0) ? (tahunvalid += 0) : (tahunvalid += 1);
		
//		if (bulanvalid - (Calendar.getInstance().get(Calendar.MONTH)+1) <= 0) {
//			tahunvalid += 0;
//		} else {
//			tahunvalid +=1;
//		}
		
		if (Calendar.getInstance().get(Calendar.YEAR) - tahunvalid < 20 || Calendar.getInstance().get(Calendar.YEAR) - tahunvalid > 60) {
			System.out.println("Usia harus di antara 20 - 60 tahun.");
			System.exit(0);
		}
		
		System.out.println("Selamat datang " + nama);
		initusername(nama);
		combination(tanggal, bulan, tahun);
		System.out.println("Username anda adalah " + Usernamevalid);
		System.out.println("Password anda adalah " + DOB);
		
		
		// Cara mensuffle Vector
		
//		Vector<String> pass = new Vector<String>();
//		pass.add(String.valueOf(String.format("%02d", tanggal))); // 0
//		pass.add(String.valueOf(String.format("%02d", bulan))); //1 
//		pass.add(String.valueOf(tahun)); //2
//		
//		Collections.shuffle(pass);
		
//		String password = "";
//		for (int i = 0; i < pass.size(); i++) {
//			password += pass.get(i);
//		}
//		
//		System.out.println(password);
		
		int angka = 3;
		
		
		
//		System.out.println("tanggal nya adalah " + tanggal);
//		System.out.println(bulan);
//		System.out.println(tahun);
	}
	
	private boolean leap(int tahun) {
		// TODO Auto-generated method stub
		boolean valid = false;
		if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
			valid = true;
		}
		
		return valid;

	}
	
	private void initusername(String nama) {
		// TODO Auto-generated method stub
		nama = nama.replace(" ", "");
		Usernamevalid = nama;
		while (Usernamevalid.length() < 8) {
			Usernamevalid += nama;
		}
		Usernamevalid = Usernamevalid.substring(0,8);
	}
	
	
	
	private void combination(int tanggal, int bulan, int tahun) {
		// TODO Auto-generated method stub
		int rand = new Random().nextInt(6);
		switch (rand) {
		case 0:
			Usernamevalid += String.format("%02d", tanggal) + String.format("%02d", bulan);
			break;

		case 1:
			Usernamevalid += String.format("%02d", bulan) + String.format("%02d", tanggal);
			break;
			
		case 2:
			Usernamevalid += String.format("%02d", tanggal) + String.valueOf(tahun).substring(2);
			break;
			
		case 3:
			Usernamevalid += String.valueOf(tahun).substring(2) + String.format("%02d", tanggal);
			break;
			
		case 4:
			Usernamevalid += String.format("%02d", bulan) + String.valueOf(tahun).substring(2) ;
			break;
		case 5:
			Usernamevalid += String.valueOf(tahun).substring(2)  + String.format("%02d", bulan);
			break;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}

}
