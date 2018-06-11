package proje;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * *
 * @Ahmet Armutcu ahmetarmutcuogr@sakarya.edu.tr
 * @31/03/2018
 * <p>
 * Projem nesneye dayalı olup kişin adı soyad,yas,tc kimlik ,telefo,ime no
 * algoritmalarını rastgele olarak doğru biçimde oluşturup kontrol etmeye
 * yarayan bir programdır.
 * </p>
 */
public class Kisi {

    public String[] isimler;
    public KimlikNo kimlikno;
    public int yas;
    public Telefon telefon;

    public String[] DosyaOkuma() throws FileNotFoundException, IOException {
        String kisioku = "isimler.txt";
        FileReader file = new FileReader(kisioku);
        BufferedReader oku = new BufferedReader(file);
        String satir;
        String isim = "";
        while ((satir = oku.readLine()) != null) {
            isim += satir + "  ";
        }
        isimler = isim.split("  ");
        return isimler;
    }

    public String KisiUret(Random r) throws IOException {
        String[] kisiselbilgi = DosyaOkuma();
        int adi = r.nextInt(300) + 1;
        yas = r.nextInt(100) + 1;
        return kisiselbilgi[adi] + " " + yas;
    }

}
