/**  *
 * @Ahmet Armutcu ahmetarmutcuogr@sakarya.edu.tr
 * @31/03/2018
 * <p>
 *  Projem nesneye dayalı olup kişin adı soyad,yas,tc kimlik ,telefo,ime no algoritmalarını rastgele olarak doğru biçimde oluşturup kontrol etmeye yarayan bir programdır. 
 * </p> 
 */
package calistir;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import proje.IMEINo;
import proje.KimlikNo;
import proje.RastgeleKisi;

/**
 *
 * @author PC
 */
public class Test {

    RastgeleKisi rastgele_kisi = new RastgeleKisi();
    IMEINo imeNo=new IMEINo();
    KimlikNo kimlik=new KimlikNo();
    public void DosyaKontrol() throws FileNotFoundException, IOException
    {
       
        String kisioku = "Kisiler.txt";
        FileReader file = new FileReader(kisioku);
        BufferedReader oku = new BufferedReader(file);
        String satir;
        String[] kisibilgi = null;
        int tcsayac=0;
        int satirsayac=0;
        int imesayac=0;
        int bosluk=0;
        String kelime="";
        while ((satir = oku.readLine()) != null) {
             kisibilgi = satir.split("  ");
             kelime+=satir+"\n";
            if(kimlik.TcKimlikKontrol(kisibilgi[0]).equals("Geçerli"))
            {
                if(kisibilgi[0].equals(""))
                   bosluk++;
                tcsayac++;
            }
        }
         Pattern fonksiyon = Pattern.compile("([(]+(\\S)+[)?])|([(]+(\\s)*+(\\S)+(\\s)*+[)?])");
         //Kisiler.txt imeno aramak için 
        Matcher uye_fonksiyon = fonksiyon.matcher(kelime);//istenilen ifadeyi eşleşmesini sağladım.
        while (uye_fonksiyon.find())//Döngü içinde bu eşleşmeleri aradım ve ekrana sayısını döndürdüm.
        {
            if(imeNo.ImeKontrol(uye_fonksiyon.group().trim().substring(1,uye_fonksiyon.group().length()-1).trim()).equals("Geçerli"))
            imesayac++;
          satirsayac++;
        }
        System.out.println("Tc Kimlik Kontrol");
        System.out.println(tcsayac-bosluk+"  Geçerli");
        System.out.println(satirsayac-tcsayac+"  Geçersiz");
        System.out.println("--------------------------");
         System.out.println("IMEI  Kontrol ");
       System.out.println(imesayac+"  Geçerli");
        System.out.println(satirsayac-imesayac+"  Geçersiz");
        
    }
    public void TestCalistir() throws IOException {

        int secim;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1.Rastgele Kişi Üret");
            System.out.println("2.Üretilmiş Dosya Kontrol Et");
            System.out.println("3.Çıkiş");

            secim = input.nextInt();
            switch (secim) {
                case 1:
                    System.out.println("Kaç adet isim gireceksiniz: ");
                    int kisisayisi=input.nextInt();
                    for(int i=0;i<kisisayisi;i++)
                     rastgele_kisi.DosyaYaz(rastgele_kisi.RastgeleKisiUret());
                    System.out.println("Dosyaya başarıyla kayıt edildi");
                    break;
                case 2:
                     DosyaKontrol();
                    break;
            }

        } while (secim != 3);
        System.out.println("Çıkış yaptınız:");
    }

}
