//author Siska Pitriani 26/03/2018
package GajiPNSOOP;


public class Pegawai extends PegawaiPNS implements TunjanganYangDipadat, TunjanganBeras, UntukPPH{
	int besarTunjanganLain;
	//constructor override
	Pegawai(String nip, String nama, String jenisKelamin, String golonganUmum, String golonganKhusus,
			String lamaKerja, String status, String jumlahAnak, String jenisPNS, String tunjanganLain, int besarTunjanganLain) {
		// TODO Auto-generated method stub
		super.Pegawai(nip, nama, jenisKelamin, golonganUmum, golonganKhusus, lamaKerja, status, jumlahAnak, jenisPNS,
				tunjanganLain);
		this.besarTunjanganLain = besarTunjanganLain;
	}
	private int gajiPokok, tunjanganyangDipadat, jumlahAnggotaKeluarga=1, jumlahAnakTemp;
	private double tunjanganMenikah, tunjanganAnak, biayaJabatan, iuranPensiun, netto, ptkp, pkp, pphsetahun, pphbulan, iwp, jumlahPotongan, tunjanganBeras;
	
	//------------------- Array
	
	//golongan 1
	int [] gol1A = {1486500, 1486500, 1533400, 1533400, 1581700, 1581700, 1631500, 1631500, 1682900, 1682900, 1735900, 1735900, 1790500, 1790500, 
					1846900, 1846900, 1905100, 1905100, 1965100, 1965100, 2027000, 2027000, 2090800, 2090800, 2156700, 2156700, 2224600, 2224600};
	int [] gol1B = {0, 0, 0, 1623400, 1623400, 1674500, 1674500, 1727300, 1727300, 1781700, 1781700, 1837800, 1837800, 1895700, 1895700, 1955400, 
					1955400, 2016900, 2016900, 2080500, 2080500, 2146000, 2146000, 2213600, 2213600, 2283300, 2283300, 2335200};
	int [] gol1C = {0, 0, 0, 1692100, 1692100, 1745400, 1745400, 1800300, 1800300, 1857000, 1857000, 1915500, 1915500, 1975800, 1975800, 2038100, 
					2038100, 2102300, 2102300, 2168500, 2168500, 2236800, 2236800, 2307200, 2307200, 2379900, 2379900, 2454800};
	int [] gol1D = {0, 0, 0, 1763600, 1763600, 1819200, 1819200, 1876500, 1876500, 1935600, 1935600, 1996500, 1996500, 2059400, 2059400, 2124300, 
					2124300, 2191200, 2191200, 2260200, 2260200, 2331400, 2331400, 2404800, 2404800, 2480500, 2480500, 2558700};

	//golongan 2
	int [] gol2A = {1926000, 1956300, 1956300, 2017900, 2017900, 2081500, 2081500, 2147000, 2147000, 2214700, 2214700, 2284400, 2284400, 2356400, 2356400, 2430600, 2430600, 
					2507100, 2507100, 2586100, 2586100, 2667500, 2667500, 2751600, 2751600, 2838200, 2838200, 2927600, 2927600, 3019800, 3019800, 3114900, 3114900, 3213100};
	int [] gol2B = {0, 0, 0, 2103300, 2103300, 2169500, 2169500, 2237900, 2237900, 2308300, 2308300, 2381100, 2381100, 2456000, 2456000, 2533400, 2533400, 2613200, 2613200, 
					2695500, 2695500, 2780400, 2780400, 2867900, 2867900, 2958300, 2958300, 3051400, 3051400, 3147600, 3147600, 3246700, 3246700, 3348900};
	int [] gol2C = {0, 0, 0, 2192300, 2192300, 2261300, 2261300, 2332500, 2332500, 2406000, 2406000, 2481800, 2481800, 2559900, 2559900, 2640600, 2640600, 2723700, 2723700, 
					2809500, 2809500, 2898000, 2898000, 2989300, 2989300, 3083400, 3083400, 3180500, 3180500, 3280700, 3280700, 3384000, 3384000, 3490600};
	int [] gol2D = {0, 0, 0, 2285000, 2285000, 2357000, 2357000, 2431200, 2431200, 2507800, 2507800, 2586700, 2586700, 2668200, 2668200, 2752300, 2752300, 2838900, 2838900, 
					2928300, 2928300, 3020600, 3020600, 3115700, 3115700, 3213800, 3213800, 3315100, 3315100, 3419500, 3419500, 3527200, 3527200, 3638200};

	//golongan 3
	int [] gol3A = {2456700, 2456700, 2534000, 2534000, 2613800, 2613800, 2696200, 2696200, 2781100, 2781100, 2868700, 2868700, 2959000, 2959000, 3052200, 3052200, 3148300, 
					3148300, 3247500, 3247500, 3349800, 3349800, 3455300, 3455300, 3564100, 3564100, 3676400, 3676400, 3792100, 3792100, 3911600, 3911600, 4034800};
	int [] gol3B = {2560600, 2560600, 2641200, 2641200, 2724400, 2724400, 2810200, 2810200, 2898700, 2898700, 2990000, 2990000, 3084200, 3084200, 3181300, 3181300, 3281500, 
					3281500, 3384900, 3384900, 3491500, 3491500, 3601400, 3601400, 3714900, 3714900, 3831900, 3831900, 3952600, 3952600, 4007000, 4007000, 4205400};
	int [] gol3C = {2668900, 2668900, 2752900, 2752900, 2839700, 2839700, 2929100, 2929100, 3021300, 3021300, 3116500, 3116500, 3214700, 3214700, 3315900, 3315900, 3420300, 
					3420300, 3528100, 3528100, 3639200, 3639200, 3753800, 3753800, 3872000, 3872000, 3994200, 3994200, 4119700, 4119700, 4249500, 4249500, 4383300};
	int [] gol3D = {2781800, 2781800, 2869400, 2869400, 2959800, 2959800, 3053000, 3053000, 3149100, 3149100, 3248300, 3248300, 3350600, 3350600, 3456200, 3456200, 3565000, 
					3565000, 3677300, 3677300, 3912600, 3912600, 3912600, 3912600, 4035800, 4035800, 4162900, 4162900, 4294000, 4294000, 4429300, 4429300, 4568800};

	//golongan 4
	int [] gol4A = {2899500, 2899500, 2990800, 2990800, 3085000, 3085000, 3182100, 3182100, 3282400, 3282400, 3385700, 3385700, 3492400, 3492400, 3602400, 3602400, 3715800, 
					3715800, 3832800, 3832800, 3953600, 3593600, 4078100, 4078100, 4206500, 4206500, 4339000, 4339000, 4475700, 4475700, 4616600, 4616600, 4762000};
	int [] gol4B = {3022100, 3022100, 3117300, 3117300, 3215500, 3215500, 3316700, 3316700, 3421200, 3421200, 3258900, 3258900, 3640100, 3640100, 3754700, 3754700, 3873000, 
					3873000, 3995000, 3995000, 4120800, 4120800, 4250600, 4250600, 4384400, 4384400, 4522500, 4522500, 4665000, 4665000, 4811900, 4811900, 4963400};
	int [] gol4C = {3149900, 3149900, 3249100, 3249100, 3351500, 3351500, 3457000, 3457000, 3565900, 3565900, 3678200, 3678200, 3794100, 3794100, 3913600, 3913600, 4036800, 
					4036800, 4164000, 4164000, 4295100, 4295100, 4430400, 4430400, 4569900, 4569900, 4713800, 4713800, 4862300, 4862300, 5015400, 5015400, 5173400};
	int [] gol4D = {3283200, 3283200, 3386600, 3386600, 3493200, 3493200, 3603300, 3603300, 3716700, 3716700, 3833800, 3833800, 3954600, 3954600, 4079100, 4079100, 4207600, 
					4207600, 4340100, 4340100, 4476800, 4476800, 4617800, 4617800, 4763200, 4763200, 4913200, 4193200, 5068000, 5068000, 5227600, 5227600, 5392200};
	int [] gol4E = {3422100, 3422100, 3529800, 3529800, 3641000, 3641000, 3755700, 3755700, 3874000, 3874000, 3996000, 3996000, 4121800, 4121800, 4251600, 4251600, 4385600, 
					4385600, 4523700, 4523700, 4666100, 4666100, 4813100, 4813100, 4964700, 4964700, 5121100, 5121100, 5282300, 5282300, 5448700, 5448700, 5620300};
	
	int [] golTemp = new int[0];
//-----------------batas Array	
	// abstract Methode @Override Gaji Pokok 
	//berdasarkan golongan dan lama kerja
	int getGajiPokok() {
			switch(golonganKhusus){
				case "1A" : case "1a" : golTemp = gol1A; break;
				case "1B" : case "1b" : golTemp = gol1B; break;
				case "1C" : case "1c" : golTemp = gol1C; break;
				case "1D" : case "1d" : golTemp = gol1D; break;
				case "2A" : case "2a" : golTemp = gol2A; break;
				case "2B" : case "2b" : golTemp = gol2B; break;
				case "2C" : case "2c" : golTemp = gol2C; break;
				case "2D" : case "2d" : golTemp = gol2D; break;
				case "3A" : case "3a" : golTemp = gol3A; break;
				case "3B" : case "3b" : golTemp = gol3B; break;
				case "3C" : case "3c" : golTemp = gol3C; break;
				case "3D" : case "3d" : golTemp = gol3D; break;
				case "4A" : case "4a" : golTemp = gol4A; break;
				case "4B" : case "4b" : golTemp = gol4B; break;
				case "4C" : case "4c" : golTemp = gol4C; break;
				case "4D" : case "4d" : golTemp = gol4D; break;
				case "4E" : case "4e" : golTemp = gol4E; break;
			}
			if (Integer.parseInt(lamaKerja) > golTemp.length-1){
				lamaKerja = String.valueOf(golTemp.length-1);
			}
			gajiPokok = golTemp[Integer.parseInt(lamaKerja)];
			return gajiPokok;
			
	}
	// getter & setter Besar Tunjangan Lain
	public int getBesarTunjanganLain() {
		return besarTunjanganLain;
	}

	public void setBesarTunjanganLain(int besarTunjanganLain) {
		this.besarTunjanganLain = besarTunjanganLain;
	}
	// Menghitung nilai tunjangan yang dipadat berdasarkan jenis PNS
	double getTunjanganyangDidapat() {
		if (jenisPNS.equals("1") || jenisPNS.equalsIgnoreCase("pejabat")) {
			tunjanganyangDipadat = TunjanganStruktural;
			System.out.print("Tunjangan Struktural : " );
		}
		else if (jenisPNS.equals("2") || jenisPNS.equalsIgnoreCase("pelayan masyarakat")) {
			tunjanganyangDipadat = TunjanganFunsional;
			System.out.print("Tunjangan Fungsional : ");
		}
		else if (jenisPNS.equals("3") || jenisPNS.equalsIgnoreCase("Lainnya")) {
			tunjanganyangDipadat = getTunjangUmum();
			System.out.print("Tunjangan Umum : " );
		}
			return tunjanganyangDipadat;
	}
	//Menghitung Tunjangan Menikah
	double getTunjanganMenikah () {
		if (status.equals("1") || status.equalsIgnoreCase("Menikah")) {
			tunjanganMenikah = 0.1*gajiPokok;
			jumlahAnggotaKeluarga++;
		}
		else
			tunjanganMenikah = 0;
		return tunjanganMenikah;
	}
	//Menghitung Tunjangan Anak
	double getTunjanganAnak () {
		jumlahAnakTemp = Integer.parseInt(jumlahAnak);
		if(Integer.parseInt(jumlahAnak) > 2){
			jumlahAnakTemp = 2;
		}
		tunjanganAnak = 0.02 * gajiPokok * jumlahAnakTemp;
		return tunjanganAnak;
	}
	//Menghitung Jumlah Keluarga yang masuk tunjangan
	double getJumlahAnggotaYangDitunjang () {
		return jumlahAnakTemp + jumlahAnggotaKeluarga;
	}
	//Menghitung Tunjangan Beras
	double getTunjanganBeras () {
		return tunjanganBeras= 10*hargaBeras*getJumlahAnggotaYangDitunjang();
	}
	//Menghitung Bruto
	double getbruto () {
		return gajiPokok + tunjanganMenikah + tunjanganAnak + tunjanganBeras + tunjanganyangDipadat + getBesarTunjanganLain();
	}
	//Menghitung Biaya Jabatan 
	double getBiayaJabatan() {
		biayaJabatan = 0.05*getbruto();
		if (biayaJabatan > 500000) {
			biayaJabatan = 500000;
		}
		return biayaJabatan;
	}
	//Menghitung Iuran Pensiun
	double getIuranPensiun() {
		return iuranPensiun = 0.0475* (gajiPokok + tunjanganMenikah + tunjanganAnak);
	}
	//Menghitung Netto
	double getnetto () {
		return netto = (getbruto() - biayaJabatan - iuranPensiun)*12; 
	}
	//Menghitung PTKP
	double getPTKP() {
		jumlahAnakTemp = Integer.parseInt(jumlahAnak);
		if (Integer.parseInt(jumlahAnak) > 3) {
			jumlahAnakTemp = 3;
		}
		ptkp = ptkplajang + (ptkptambahan * (jumlahAnggotaKeluarga - 1 + jumlahAnakTemp));
		return ptkp;
	}
	//Menghitung PKP
	double getPKP() {
		return pkp = netto - ptkp;
	}
	//menghitung pph setahun
	double getpph() {
		
		
		if (pkp >= 0 && pkp <= nilai50) {
			pphsetahun = pkpsampai50*pkp;
		}
		else if (pkp > nilai50 && pkp <= nilai250) {
			pkp = pkp - nilai50;
			pphsetahun = nilai50*pkpsampai50 + pkp*pkpsampai250;
		}
		else if (pkp > nilai250 && pkp <= nilai500) {
			pkp = pkp - nilai50 - nilai250;
			pphsetahun = nilai50*pkpsampai50+ nilai250*pkpsampai250 +pkpsampai500*pkp;
			
		}
		else if (pkp > nilai500) {
			pkp = pkp-nilai50-nilai250-nilai500;
			pphsetahun = nilai250*pkpsampai50 + nilai250*pkpsampai250 + nilai500* pkpsampai500+pkplebih500*pkp;
			
		}
		
		return pphsetahun;
	}
	//menghitung pph sebulan
	double getpphSebulan () {
		pphbulan=getpph()/12;
		return pphbulan;
	}
	//menghitung bruto deg pph
	double getbrutopph() {
		return getbruto() + getpphSebulan();
	}
	//menghitung iwp
	double getiwp () {
		 iwp = (gajiPokok + tunjanganMenikah + tunjanganAnak)*0.1;
		 return iwp;
	}
	//menghitung jumlah potongan
	double getJumlahPotongan () {
		jumlahPotongan = getiwp()+ getpphSebulan()+getTapeRum();
		return jumlahPotongan;
	}
	//menghitung jumlah bersih
	double getJumlahbersih () {
		return getbrutopph() - getJumlahPotongan();
	}
	//methode untuk menampilkan 
	void Print () {
		System.out.println();
		System.out.println("Gaji Pokok            : " + (int)getGajiPokok());
		System.out.println((int)getTunjanganyangDidapat());
		System.out.println("Tunjangan Menikah     : " + (int)getTunjanganMenikah());
		System.out.println("Tunjangan Anak        : " + (int)getTunjanganAnak());
		System.out.println("Tunjangan Beras       : " + (int)getTunjanganBeras());
		System.out.println("Tunjangan Lain        : " + (int)getBesarTunjanganLain());
		System.out.println("PPH                   : " + (int)getpphSebulan());
		System.out.println("Bruto                 : " + (int)getbrutopph());
		System.out.println("Biaya Jabatan         : " + (int)getBiayaJabatan());
		System.out.println("Iuran Pensiun         : " + (int)getIuranPensiun());
		System.out.println("IWP                   : " + (int)getiwp());
		System.out.println("Netto                 : " + (int)getnetto());
		System.out.println("PTKP                  : " + (int)getPTKP());
		System.out.println("PKP                   : " + (int)getPKP());
		System.out.println("Potongan PPH          : " + (int)getpphSebulan());
		System.out.println("Taperum               : " + (int)getTapeRum());
		System.out.println("Take Home Pay         : " + (int)getJumlahbersih());
	}
	
	
}
