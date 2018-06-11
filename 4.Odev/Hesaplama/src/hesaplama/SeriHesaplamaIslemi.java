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
public class SeriHesaplamaIslemi {

    long baslangic = System.nanoTime(); //süreyi başlatma 
    public void Carpma(BigInteger carpilacaksayi1, BigInteger carpilacaksayi2) {//Sıra ile çarpma işlemenin yapılması sağlanıyor.
        String sayi_uzunluk = carpilacaksayi2.toString();
        BigInteger islem[] = new BigInteger[sayi_uzunluk.length()*2];
        BigInteger deger;
        BigInteger carpim;
        for (int i = 0; i < sayi_uzunluk.length()-1; i++) {
            deger = new BigInteger(sayi_uzunluk.substring(i, i + 1));
            carpim = carpilacaksayi1.multiply(deger);
            islem[i] = carpim;
        }
        BigInteger topla;
        for (int i = 0; i < sayi_uzunluk.length()-1; i++) {
            topla = islem[i].add(islem[i + 1]);
            break;
        }
        double sure = 0;
        long bitis = System.nanoTime();//hesaplama bitiyor 
        sure = (bitis - baslangic) / 1000000.0;
        System.out.println("Seri Hesaplanma Süresi " + String.format("%.2f", sure) + " milisaniye.");
    }

   
}
