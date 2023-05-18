import java.util.Scanner;
import java.time.LocalDate;

class Manusia {
    private String nama;
    private boolean jenisKelamin;
    private String nik;
    private boolean menikah;

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean getJenisKelamin() {
        return this.jenisKelamin;
    }

    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNik() {
        return this.nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public boolean getMenikah() {
        return this.menikah;
    }

    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }

    public double getTunjangan() {
        if (getMenikah()) {
            if (getJenisKelamin())
                return 25;
            else
                return 20;
        } else {
            return 15;
        }
    }

    public String toString() {
        return getNama() + ", " + getNik() + ", " + (getJenisKelamin() ? "Laki-laki" : "Perempuan") + ", "
                + (getMenikah() ? "Menikah" : "Belum menikah");
    }
}

class Mahasiswa extends Manusia {
    private String nim;
    private double ipk;

    public String getNim() {
        return this.nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIpk() {
        return this.ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getStatus() {
        String prodi = "";
        switch (getNim().charAt(6)) {
            case '2':
                prodi = "Teknik Informatika";
                break;
            case '3':
                prodi = "Teknik Komputer";
                break;
            case '4':
                prodi = "Sistem Informasi";
                break;
            case '6':
                prodi = "Pendidikan Teknologi Informasi";
                break;
            case '7':
                prodi = "Teknologi Informasi";
                break;
            default:
        }
        return prodi + ", 20" + getNim().charAt(0) + getNim().charAt(1);
    }

    public double getBeasiswa() {
        if (getIpk() >= 3.0 && getIpk() <= 3.5)
            return 50;
        else if (getIpk() >= 3.5 && getIpk() <= 4)
            return 75;
        else
            return 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", "
                + nim + ", " + Double.toString(ipk) + ", " + Double.toString(getBeasiswa()) + ", " + getStatus();
    }

}

class Pekerja extends Manusia {
    LocalDate localDate = LocalDate.now();
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public double getGaji() {
        return this.gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setTahunMasuk(LocalDate tahunMasuk){
        this.tahunMasuk = tahunMasuk;
    }

    public int getJumlahAnak() {
        return this.jumlahAnak;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaKerja = tahunMasuk.getYear() - localDate.getYear();
        if (lamaKerja <= 5)
            return 1.05 * gaji;
        else if (lamaKerja <= 10)
            return 1.1 * gaji;
        else
            return 1.15 * gaji;
    }

    public double getTunjangan() {
        return super.getTunjangan() + (20 * jumlahAnak);
    }

    public String toString() {
        return super.toString() + ", " + (localDate.getYear()-tahunMasuk.getYear()) + ", " + jumlahAnak + ", Tunj :" + getTunjangan() + ", Bonus :" + getBonus() + ", "+ gaji;
    }
}

class Manager extends Pekerja {
    private String departemen;

    public String getDepartemen() {
        return this.departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public double getTunjangan() {
        return super.getTunjangan() * 1.10;
    }

    public String toString() {
        return super.toString() + ", " + departemen;
    }
}

public class Latihan {
    public static void main(String[] args) {
        Manusia manusia1 = new Manusia();
        Manusia manusia2 = new Manusia();
        Manusia manusia3 = new Manusia();

        manusia1.setNama("Udin");
        manusia1.setNik("6251");
        manusia1.setJenisKelamin(true);
        manusia1.setMenikah(true);
        System.out.println(manusia1.toString());

        manusia2.setNama("Fionna");
        manusia2.setNik("6252");
        manusia2.setJenisKelamin(false);
        manusia2.setMenikah(true);
        System.out.println(manusia2.toString());

        manusia3.setNama("Putra");
        manusia3.setNik("6253");
        manusia3.setJenisKelamin(true);
        manusia3.setMenikah(false);
        System.out.println(manusia3.toString());

        System.out.println("");

        Mahasiswa mahasiswa1 = new Mahasiswa();
        Mahasiswa mahasiswa2 = new Mahasiswa();
        Mahasiswa mahasiswa3 = new Mahasiswa();

        mahasiswa1.setNama("Rizal");
        mahasiswa1.setNik("6254");
        mahasiswa1.setJenisKelamin(true);
        mahasiswa1.setMenikah(false);
        mahasiswa1.setIpk(2.9);
        mahasiswa1.setNim("2044442");
        System.out.println(mahasiswa1.toString());

        mahasiswa2.setNama("Elfinda");
        mahasiswa2.setNik("6255");
        mahasiswa2.setJenisKelamin(false);
        mahasiswa2.setMenikah(false);
        mahasiswa2.setIpk(3.3);
        mahasiswa2.setNim("2044443");
        System.out.println(mahasiswa2.toString());

        mahasiswa3.setNama("Sonia");
        mahasiswa3.setNik("6256");
        mahasiswa3.setJenisKelamin(false);
        mahasiswa3.setMenikah(false);
        mahasiswa3.setIpk(3.9);
        mahasiswa3.setNim("2144447");
        System.out.println(mahasiswa3.toString());

        System.out.println("");

        Pekerja pekerja1 = new Pekerja();
        Pekerja pekerja2 = new Pekerja();
        Pekerja pekerja3 = new Pekerja();

        pekerja1.setNama("Bu Ajeng");
        pekerja1.setNik("6257");
        pekerja1.setJenisKelamin(false);
        pekerja1.setMenikah(true);
        pekerja1.setGaji(50);
        pekerja1.setTahunMasuk(LocalDate.of(2021, 1, 1));
        pekerja1.setJumlahAnak(2);
        System.out.println(pekerja1.toString());

        pekerja2.setNama("Pak Arif");
        pekerja2.setNik("6258");
        pekerja2.setJenisKelamin(true);
        pekerja2.setMenikah(false);
        pekerja2.setGaji(100);
        pekerja2.setTahunMasuk(LocalDate.of(2014, 1, 1));
        pekerja2.setJumlahAnak(0);
        System.out.println(pekerja2.toString());

        pekerja3.setNama("Pak Yusuf");
        pekerja3.setNik("6259");
        pekerja3.setJenisKelamin(true);
        pekerja3.setMenikah(true);
        pekerja3.setGaji(100);
        pekerja3.setTahunMasuk(LocalDate.of(2003, 1, 1));
        pekerja3.setJumlahAnak(10);
        System.out.println(pekerja3.toString());

        System.out.println("");

        Manager manager1 = new Manager();
        manager1.setNama("Pak Mashadi");
        manager1.setNik("6260");
        manager1.setJenisKelamin(true);
        manager1.setMenikah(false);
        manager1.setGaji(7500);
        manager1.setTahunMasuk(LocalDate.of(2008, 1, 1));
        manager1.setJumlahAnak(0);
        manager1.setDepartemen("Departement Badak");
        System.out.println(manager1.toString());
    }
}