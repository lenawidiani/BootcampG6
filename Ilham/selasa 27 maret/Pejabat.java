// Ilham 26-03-2018

public class Pejabat extends Karyawan {
	private final String namaTunjanganJabatan = "Tunjangan Struktural";
	private final double tunjanganJabatan = 1000000;
	
	// Construct
	public Pejabat(String nama, String nip, String jenisKelamin, int golongan, String kodeGolongan,
			int masaKerjaDalamTahun, String statusMenikah, int jumlahAnak, boolean tunjanganLainnya) {
		super(nama, nip, jenisKelamin, golongan, kodeGolongan, masaKerjaDalamTahun, statusMenikah, jumlahAnak, tunjanganLainnya);
	}

	// Construct
	// overloading
	public Pejabat(String nama, String nip, String jenisKelamin, int golongan, String kodeGolongan,	int masaKerjaDalamTahun, String statusMenikah,
			int jumlahAnak, boolean tunjanganLainnya, String namaTunjanganLainnya, double besarTunjanganLainnya) {
		super(nama, nip, jenisKelamin, golongan, kodeGolongan, masaKerjaDalamTahun, statusMenikah, jumlahAnak, tunjanganLainnya, namaTunjanganLainnya, besarTunjanganLainnya);
	}

	// Tunjangan Jabatan
	public double getTunjanganJabatan() {
		return tunjanganJabatan;
	}
	public String getNamaTunjanganJabatan() {
		return namaTunjanganJabatan;
	}

	@Override
	protected void setGajiKotor() {
		setGajiKotor(getGajiPokok() + getTunjanganIstri() + getTunjanganAnak() + getTunjanganBeras() + tunjanganJabatan + (isTunjanganLainnya() ? getBesarTunjanganLainnya() : 0));
	}
	@Override
	protected void setGajiKotor(double gajiKotor ,double pph) {
		setGajiKotor(gajiKotor + pph);	
	}

}
