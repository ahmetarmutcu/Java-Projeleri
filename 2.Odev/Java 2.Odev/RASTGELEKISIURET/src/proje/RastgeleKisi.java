package proje;

import java.io.BufferedWriter;
import java.io.FileWriter;

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
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author PC
 */
public class RastgeleKisi {

    Kisi kisi = new Kisi();
    Random r = new Random();
    IMEINo imeno = new IMEINo();

    public String RastgeleKisiUret() throws IOException {
        kisi.kimlikno = new KimlikNo();
        kisi.telefon = new Telefon();
        return kisi.kimlikno.KimlikNoUret(r) + "  " + kisi.KisiUret(r) + "  " + kisi.telefon.TelefonUret(r) + "  (" + imeno.ImeNoUret(r) + ")";
    }

    public void DosyaYaz(String kisi) throws IOException {
        FileWriter dosya = new FileWriter("Kisiler.txt", true);
        try (BufferedWriter yaz = new BufferedWriter(dosya)) {
            yaz.write(kisi);
            yaz.newLine();
            yaz.close();

        }

    }

}
