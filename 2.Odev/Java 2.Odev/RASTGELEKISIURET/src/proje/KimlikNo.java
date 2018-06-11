/**  *
 * @Ahmet Armutcu ahmetarmutcuogr@sakarya.edu.tr
 * @31/03/2018
 * <p>
 *  Projem nesneye dayalı olup kişin adı soyad,yas,tc kimlik ,telefo,ime no algoritmalarını rastgele olarak doğru biçimde oluşturup kontrol etmeye yarayan bir programdır. 
 * </p> 
 */
package proje;


import java.util.Random;


/**
 *
 * @author PC
 */
public class KimlikNo {

    
    public String KimlikNoUret(Random r) {
        int tckimlik_No[] = new int[11];
        String ilk = "";
        String sonraki = "";
        String on = "";
        String onbir = "";
        int teksayilar = 0, ciftsayilar = 0;
        int onbirincihane = 0;
        if (tckimlik_No.length == 11) {
            for (int i = 1; i < 10; i++) {
                tckimlik_No[i] = r.nextInt(9) + 1;
                if (tckimlik_No[1] == 0) 
                    ilk = "" + r.nextInt(9) + 1;
                if (i % 2 == 1) 
                    teksayilar += tckimlik_No[i];
                 else if (i % 2 == 0) 
                    ciftsayilar += tckimlik_No[i];
                onbirincihane += tckimlik_No[i];
            }
            int onuncuhane = (((teksayilar * 7) - ciftsayilar) % 10);
            for (int i = 1; i < 10; i++) 
                sonraki += (tckimlik_No[i]);
            on = ((onuncuhane) % 10) + "";
            onbir = ((onuncuhane + onbirincihane) % 10 + " ");
        }
        return ilk + "" + sonraki + "" + on + "" + onbir;
    }
    public String TcKimlikKontrol(String tc) {
       
            if (tc.length() == 11) {
                int tek = 0;
                int cift = 0;
                for (int i = 0; i < 9; i++) {
                    int ilkdokuzrakam = Integer.valueOf(tc.substring(i, i + 1));

                    if (i % 2 == 0) {
                        tek += ilkdokuzrakam;
                    } else {
                        cift += ilkdokuzrakam;
                    }
                }
                int toplam = tek + cift + Integer.valueOf(tc.substring(9, 10));
                int sonrakam = toplam % 10;
                if (tc.substring(10).equals(String.valueOf(sonrakam))) {
                    int son = (tek * 7 - cift) % 10;
                    if (tc.substring(9, 10).equals(String.valueOf(son))) 
                        return "Geçerli";
                }
            }
        return "Geçersiz";
    }
}
