/** *  * @author Ahmet Armutcu ahmetarmutcu@ogr.sakarya.edu.tr
 * @since 4/05/2018
 * <p>
 * Thread Kullanrak paralel hatalı çarpma hesaplaması yapan ve seri hatalı
 * çarpma işlemi yapan bir programdır. * </p>
 */
package hesaplama;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ToplamaIslemi implements Runnable { //2.Thread

    private Sayilar sonuc; //Sayilar sınıfında sonuc adında bir nesne oluşturdum
    private String sonuc_Yazdir = ""; //Metin belgesine kaydetmek için string değer oluşturdum.

    public ToplamaIslemi(Sayilar sonuc) { //Constroctor
        this.sonuc = sonuc;
    }

    @Override
    public void run() { //Çalışacak Metod
        BigInteger topla;

        for (int i = 0; i < sonuc.dizi.length-1 ; i++) {
            if (sonuc.dizi[i] == null) { //Önemli örneğin birinci rakamla birinci sayıyı çarptı sonra 2.atladı 3.rakam ile birinciyi çarptı.atlamasını ve sonra null olmayana kadar işlemi yapmasını sağlıyor.
                continue;
            }
            topla = sonuc.dizi[i].add(sonuc.dizi[i + 1]); //Topla ile bigInteger özel formatın toplayarak ekler.
            sonuc_Yazdir = topla.toString();//Çarpsın ve eklesin sonrada metin belgesine yazdırsın ve döngüden çıkmasını sağladım.
            break;
        }
        FileWriter dosya = null; //Dosyaya yazdırma bölümü
        try {
            dosya = new FileWriter("Sonuc.txt", false);
        } catch (IOException ex) {
            Logger.getLogger(ToplamaIslemi.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter yaz = new BufferedWriter(dosya);
        try {
            yaz.write(sonuc_Yazdir);
        } catch (IOException ex) {
            Logger.getLogger(ToplamaIslemi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            yaz.close();
        } catch (IOException ex) {
            Logger.getLogger(ToplamaIslemi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
