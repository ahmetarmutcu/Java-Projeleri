/** *  * @author Ahmet Armutcu ahmetarmutcu@ogr.sakarya.edu.tr
 * @since 4/05/2018
 * <p>
 * Thread Kullanrak paralel hatalı çarpma hesaplaması yapan ve seri hatalı
 * çarpma işlemi yapan bir programdır. * </p>
 */
package hesaplama;

import java.math.BigInteger;

/**
 *
 * @author PC
 */
public class CarpmaIslemi implements Runnable { //Thread kullandım

    private Sayilar sayi2; //Sayılar sınıfında nesne oluşturulmuş
    private Sayilar sonuc;
    private BigInteger sayi1;

    public CarpmaIslemi(Sayilar sayi2, Sayilar sonuc, BigInteger sayi1) { //constroctur

        this.sayi2 = sayi2;
        this.sayi1 = sayi1;
        this.sonuc = sonuc;
    }

    @Override
    public void run() { //Çalışcak metod
        for (int i = 0; i < sayi2.dizi.length-1; i++) {
            sonuc.dizi[i] = sayi1.multiply(sayi2.dizi[i]); //Sayilar sınıfı içindeki diziye sayı1 ile* sayi2.dizi[i] elemanı çarptırdım ve sonuc.dizisine yazdırdım.
            //System.out.println(sonuc.dizi[i]);
        }
    }
}
