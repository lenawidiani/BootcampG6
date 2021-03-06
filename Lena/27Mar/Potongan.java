/* @author : lenawidiani
 * @dibuat : 26 Maret 2018
 * 
 */

public interface Potongan {
	double PERSEN_BIAYA_JABATAN = 0.05;
	double MAX_BIAYA_JABATAN = 500000;
	double PERSEN_IURAN_PENSIUN = 0.0475;
	
	int MAX_JUMLAH_ANAK_PTKP = 3;
	double PTKP_DEFAULT = 36000000;
	double PTKP_PENAMBAHAN = 3000000;
	
	double PKP_RANGE_LAPIS_PERTAMA = 50000000;
	double PKP_RANGE_LAPIS_KEDUA = 200000000;
	double PKP_RANGE_LAPIS_KETIGA = 250000000;
	
	double PERSEN_PKP_KURANG_DARI_50JUTA = 0.05;
	double PERSEN_PKP_RANGE_250JUTA = 0.15;
	double PERSEN_PKP_RANGE_500JUTA = 0.25;
	double PERSEN_PKP_LEBIH_DARI_500JUTA = 0.3;
	
	double PERSEN_IWP = 0.1;
	int[] POTONGAN_TAPERUM = {3000, 5000, 7000, 10000};
}
