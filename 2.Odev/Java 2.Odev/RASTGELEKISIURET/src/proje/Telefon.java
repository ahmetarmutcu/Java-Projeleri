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
public class Telefon {

    public String TelefonUret(Random r) {
        String ilkrakam = "", ikincirakam = "", diger_rakamlar = "";
        int[] telefon = new int[11];
        if (telefon.length == 11) {
            ilkrakam = "0";
            ikincirakam = "5";
            for (int i = 2; i < 11; i++) {
                telefon[i] = r.nextInt(9);
            }
            for (int i = 2; i < 11; i++) {
                diger_rakamlar += telefon[i];
            }
        }
        return ilkrakam + "" + ikincirakam + "" + diger_rakamlar;
    }

}
