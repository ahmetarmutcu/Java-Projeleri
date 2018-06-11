package projeodevi;

import java.util.Scanner;

/**
 *
 * @Ahmet Armutc ahmetarmutcuogr@sakarya.edu.tr
 * @08.03.2018 ve 10.03.2018 arası
 * <p>
 * Projem belirtilen kaynak dosyasındaki bilgileri okuyorak bu veriler üzerinde
 * regex sayesinede işlem yapılarak ekrana yazılan bir programdır.
 * </p>
 */
public class ProjeOdevi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Okunacak Dosyayı giriniz: ");
        String dosya = input.next();//Kullanıcıdan dosyanın ismini girmesini sağlıyoruz.(Sayi.java)
        DosyaOku oku = new DosyaOku();//Dosya Oku sınıfı ile heapte yeni bir nesne üretiyoruz.
        oku.DosyaOku(dosya);//Nesne işlemi dosyayı okutarak diğer işlemleri yaptırıyoruz

    }

}
