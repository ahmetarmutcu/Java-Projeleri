/** *
 * @Ahmet Armutcu ahmetarmutcuogr@sakarya.edu.tr
 * @31/03/2018
 * <p>
 * Projem nesneye dayalı olup kişin adı soyad,yas,tc kimlik ,telefo,ime no
 * algoritmalarını rastgele olarak doğru biçimde oluşturup kontrol etmeye
 * yarayan bir programdır.
 * </p>
 */
package proje;

import java.util.Random;

/**
 *
 * @author PC
 */
public class IMEINo {

    public String ImeNoUret(Random r) {
        int[] imeNo = new int[14];
        String cifthane = "";
        String ilkondorthane = "";
        String sonhane = "";
        int tekhane = 0;
        int ciftrakamlar = 0;

        for (int i = 0; i < 14; i++) {
            imeNo[i] = r.nextInt(9) + 1;
            if (i % 2 == 0) {
                tekhane += imeNo[i];
            }
            if (i % 2 == 1) {
                cifthane += imeNo[i] * 2;
            }
        }
        for (int c = 0; c < cifthane.length(); c++) {
            int gecici = Integer.valueOf(cifthane.substring(c, c + 1));
            ciftrakamlar += gecici;
        }
        for (int i = 0; i < 14; i++) {
            ilkondorthane += imeNo[i];
        }
        int rakamlar_toplami = 0;
        rakamlar_toplami = tekhane + ciftrakamlar;
        int sonrakam = 0;
        for (int k = 0; k < rakamlar_toplami;) {
            k = k + 10;
            if (k < rakamlar_toplami) {
                sonrakam = (k + 10) - rakamlar_toplami;
            }
        }
        sonhane += sonrakam + "";
        return ilkondorthane + "" + sonhane;
    }

    public String ImeKontrol(String ime) {
        int cifthaneToplami = 0, tekler = 0, rakamlar_Toplami = 0;
        String ciftler = "", sonhane = "";
        if (ime.length() == 15) {
            for (int i = 0; i < 14; i++) {
                int rakamlar = Integer.valueOf(ime.substring(i, i + 1));
                if (i % 2 == 0) {
                    tekler += rakamlar;
                }
                if (i % 2 == 1) {
                    ciftler += rakamlar * 2;
                }

            }
            for (int k = 0; k < ciftler.length(); k++) {
                int ciftsayilar = Integer.valueOf(ciftler.substring(k, k + 1));
                cifthaneToplami += ciftsayilar;
            }
            rakamlar_Toplami = tekler + cifthaneToplami;
            int sonrakam = 0;
            for (int basamak = 0; basamak < rakamlar_Toplami;) {
                basamak = basamak + 10;
                if (basamak < rakamlar_Toplami) {
                    sonrakam = (basamak + 10) - rakamlar_Toplami;
                }
            }
            sonhane = sonrakam + "";
            if (sonhane.equals(ime.substring(14, 15))) {
                return "Geçerli";
            }

        }
        return "Geçersiz";
    }
}
