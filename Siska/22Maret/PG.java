
public class PG extends Karyawan implements Lembur, TunjanganKeluarga, BPJS, PPH{
	int bonusPG;
	public PG(String namaK, String noNIK, String penempatanKerja, String pekerjaan, String kategoripegawai,
			int lamakerja, String status, int bonusPG) {
		super(namaK, noNIK, penempatanKerja, pekerjaan, kategoripegawai, lamakerja, status, lamakerja);
	this.bonusPG = bonusPG;
	}

	final int BONUSFIXINGBUG = 20000;
	double tunjanganKeluarga, pkp;
	int ptkp;
	
	public double setGajiPokok() {
		double gaPok=0;
			if (kategoripegawai.equalsIgnoreCase("Junior")) {
				if (lamakerja >=0 && lamakerja  <=1) {
					gaPok = 1;
				}
				else if (lamakerja >=2 && lamakerja <= 3 ) {
					gaPok = 1.2;
				}
				else if (lamakerja > 3) {
					gaPok = 1.5;
				}
			}
			if (kategoripegawai.equalsIgnoreCase("Middle")) {
				if (lamakerja >= 0 && lamakerja <=2 ) {
					gaPok = 1.7;
				}
				else if (lamakerja >=3 && lamakerja <=4 ) {
					gaPok = 1.8;
				}
				else if (lamakerja > 4) {
					gaPok = 2.1;
				}
			}
			if (kategoripegawai.equalsIgnoreCase("Senior")) {
				if (lamakerja >= 0 && lamakerja <= 2) {
					gaPok = 2.5;
				}
				else if (lamakerja >= 3 && lamakerja <= 4) {
					gaPok = 2.7;
				}
				else if (lamakerja > 4) {
					gaPok = 2.8;
					}
				}
			return gaPok; 	
		}
		double getgaji () {
			return setGajiPokok()*getumk();
		}
		double getgajiBulanan() {
			return getgaji()+gettunjanganPegawai();
		}
		double getgajilembur() {
			return lembur*getgajiBulanan();
		}
		//status
		double getstatus () {
			if (status.equalsIgnoreCase("Y")) {
				tunjanganKeluarga = besartunjangankeluarga* getgajiBulanan();
			}
			else if  (status.equalsIgnoreCase("N")) {
				tunjanganKeluarga = 0;
			}
			return tunjanganKeluarga;
		}
		
		int getbonusPG() {
			return BONUSFIXINGBUG*bonusPG;
		}
		
		double getbruto () {
			return getgajiBulanan() + getgajilembur() + gettunjanganTransport() + getstatus() + getbonusPG();
		}
		double getbpjskes() {
			return potonganBPJSKesehatan*getbruto();
		}
		double getbpjsket() {
			return potonganBPJSKetenagakerjaan*getbruto();
		}
		double getbJabatan() {
			return biayaJabatan*getbruto();
		}
		double getnetto() {
			return getbruto()-getbJabatan();
		}
		double getnettosetahun() {
			return getnetto()*12;
		}
		int getptkp () {
			if (status.equalsIgnoreCase("Y")){
				ptkp = ptkpmenikah;
			}
			else if (status.equalsIgnoreCase("N")) {
				ptkp = ptkplajang;
			}
			return ptkp;
		}
		double getpkp() {
			return pkp = getnettosetahun()-getptkp();
		}
		double getpph() {
			double pphsetahun=0;
			
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
		double getpphSebulan () {
			return getpph()/12;
		}
		double gettakeHomepay() {
			return getbruto()- getbpjskes() - getbpjsket() - getpphSebulan();
		}
		
	}
	

		
			
			
	
