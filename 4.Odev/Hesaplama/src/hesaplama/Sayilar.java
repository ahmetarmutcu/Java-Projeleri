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
public class Sayilar {
    public BigInteger[] dizi; //Çok büyük sayılar ile işlem yapmak için
    public Sayilar(String basamaksayisi) { //constroctur tanımladım.
        dizi = new BigInteger[basamaksayisi.length()];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = new BigInteger(basamaksayisi.substring(i,i+1));//Rakamları parçaladım.
        }
    }
    public Sayilar(int basamaksayisi) {
        dizi = new BigInteger[basamaksayisi];
    }
}
