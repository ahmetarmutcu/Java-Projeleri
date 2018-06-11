/**
 *
 * @Ahmet Armutc ahmetarmutcuogr@sakarya.edu.tr
 * @08.03.2018 ve 10.03.2018 arası
 * <p>
 * Projem belirtilen kaynak dosyasındaki bilgileri okuyorak bu veriler üzerinde
 * regex sayesinede işlem yapılarak ekrana yazılan bir programdır.
 * </p>
 */
package projeodevi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DosyaOku {//Yeni bir sınıf oluşturdum adı Dosya Okuma

    public String SinifAdiBul(String kelime, String[] kelimebol)//SınıfAdiBul fonksiyonun iki parametresi vardır.
    {
        Pattern sinifadi = Pattern.compile("public+(\\s)*+class+(\\s)*+(\\S)+(\\s)*\\{");//Regex ile sinif adı özel bir komutunu yazdım.public başlıyorsa class ismi geçiyorsa ve parantez açıksa sınıftır dedim.
        Matcher sinif = sinifadi.matcher(kelime);//Matcher ile bunun kelime string eşleşmesini sağladım.
        while (sinif.find())//while ile eşleşen bu kelime döngü içinde arattım.
        {

            kelimebol = sinif.group().split(" ");//eşleşen kelimeler için bir grup oluşturdum ve split ile boşluk olarak ayırdım.

        }
        return "Sınıf Adı:" + kelimebol[2].trim();//Sonra parametrede tanımladığım dizinin ikinci elemanın ekrana classismi diye döndürdüm.
    }

    public void AltEleman(String kelime, String[] kelimebol)//Alt eleman diye bir metod tanımladım
    {
        int alteleman_sayac = 0;//eleman sayısını saymak için bir sayac tanımladım.
        Pattern elemanlar = Pattern.compile("(public|private)+(\\s)*(int|boolean|String|double)+(\\s)*+(\\S)+(\\s)*;");//public ve private ile başlıyor ve boşluk var sonra int,string veya boolean gibi dğereger en sonundada noktalı virgül ile bitiyorsa alt elemandır.dedim
        Matcher altelemanlar = elemanlar.matcher(kelime);//İstenilenin eşleşmesini sağladım.
        while (altelemanlar.find()) {//Döngü içinde eşleşenleri aradım.
            kelimebol = altelemanlar.group().split(" ");//boşluk olarak ayırdım
            System.out.println(kelimebol[2].trim() + "-" + kelimebol[1].trim());//on ve arkadaki boslukları silip ekrana istenile verileri yazdırdım.
            alteleman_sayac++;//sayacı bir bir artırdım
        }

        System.out.println("Alt Elemanlar: " + alteleman_sayac + " adet");//group da kaç adet eleman varsa onun sayısını ekrana yazdırdım.
    }

    public int UyeFonksiyonSayisi(String kelime)//Uye fonksiyon için bir metod tanımladım.
    {
        int uyefonksiyon_sayac = 0;//sayac tanımladım
        Pattern fonksiyon = Pattern.compile("((public|private)+(\\s)*+(int|String|boolean|void|Double)+(\\s)*+(\\S)+(\\s)*+(([(]....+?[)])|([(]+?[)])))|(public+(\\s)*+(\\S)+(\\s)*+(([(]....+?[)])|([(]+?[)])))");
        //Uye fonsiyonlar için regexte public veya private başlıyorsa int string boolean geliyor sonra metod ismi geliyor parantez metod isminden hemen sonra veya bir boşluk sonra ise metoddur dedim.
        Matcher uye_fonksiyon = fonksiyon.matcher(kelime);//istenilen ifadeyi eşleşmesini sağladım.
        while (uye_fonksiyon.find())//Döngü içinde bu eşleşmeleri aradım ve ekrana sayısını döndürdüm.
        {
            uyefonksiyon_sayac++;
        }
        return uyefonksiyon_sayac;//sayac sayısını geri döndürdüm.
    }

    public void parametresayisi(String kelime, String[] kelimebol)//parametre sayısını öğrenmek için metod tanımladım.
    {

        Pattern sadecepublic = Pattern.compile("(public|private)+(\\s)*+(\\S)+ (\\s)*+[(]+(\\s)*+(int|String|boolean|double)+(\\s)*.+?[)]|((public|private)+(\\s)*+(\\S)+(\\s)*+[(]+(\\s)*+(int|String|boolean|double)+(\\s)*.+?[)])");
        //sadece public private yani constroctor diye düşündüm parantez için parametrelerden biri int veya double ile başlaması lazım be parantezin kapanması lazımdırq
        Matcher s_public = sadecepublic.matcher(kelime);//eşleşmesini sağlıyoruz
        Pattern parametreadi = Pattern.compile("[(]+(\\s)*+(int|String|boolean|double).+?[)]");//parantez içindeki değişlenleri yazdırmak içinde bir regex tanımlıyoruz.
        Matcher p_adi = parametreadi.matcher(kelime);//eşleşmesini sağlıyoruz.
        String[] parametre;
        String[] kelimeparcala;
        while (s_public.find() && p_adi.find())//Döngüde iki eşleşmeyi aratıyoruz ve eşleşenleri group oluşturuyoruz.
        {

            kelimebol = s_public.group().split(",");//parametreleri virgül sayısına göre bölüyoruz
            kelimeparcala = s_public.group().split(" ");

            System.out.println(kelimeparcala[1].trim());//ilk olarak boşlul sayısına göre metodun ismini yazdırıyoruz.
            System.out.println("Dönüş Türü: Yok ");//public veya private ile başlayıp direk metod ismi gerliyorsa dönüştürü yok diyoruz
            System.out.println("Aldığı parametre sayisi: " + kelimebol.length); //aldığı parametre sayısını ise virgül sayısını bölerek hesaplıyoruz.
            parametre = p_adi.group().split(",");//yazdırmak içinde virgül sayısına kadara olanları 
            for (String parametre1 : parametre) //döngü içinde aratarak yazdırıyoruz.
            {
                System.out.print(parametre1 + "\n");
            }
            System.out.println("------------------------------------");

        }
        Pattern donustipiolanparametre = Pattern.compile("(public|private)+(\\s)*+(void|int|String|double|boolean)+(\\s)*+(\\S)+ (\\s)*+[(]+(int|String|boolean|double).+?[)]|((public|private)+(\\s)*+(void|int|String|double|boolean)+(\\s)*+(\\S)+(\\s)*+[(]+(int|String|boolean|double).+?[)])");
        //Eğer public başlayıp Donustipi olan metolar için regex tanımladık
        Matcher donusparametre = donustipiolanparametre.matcher(kelime);//eşleme aradık
        while (donusparametre.find() && p_adi.find())//Döngüde iki eşleşmeyi aratıyoruz ve eşleşenleri group oluşturuyoruz.
        {

            kelimebol = donusparametre.group().split(",");//parametreleri virgül sayısına göre bölüyoruz
            kelimeparcala = donusparametre.group().split(" ");//parametreleri boşluğa göre ayarlıyoruz

            System.out.println(kelimeparcala[2].trim());//ilk olarak boşlul sayısına göre metodun ismini yazdırıyoruz.
            System.out.println("Dönüş Türü: " + kelimeparcala[1]);//public veya private ile başlayıp direk metod ismi gerliyorsa dönüştürü yok diyoruz
            System.out.println("Aldığı parametre sayisi: " + kelimebol.length); //aldığı parametre sayısını ise virgül sayısını bölerek hesaplıyoruz.
            parametre = p_adi.group().split(",");//yazdırmak içinde virgül sayısına kadara olanları 
            for (String parametre1 : parametre) //döngü içinde aratarak yazdırıyoruz.
            {
                System.out.print(parametre1 + "\n");
            }
            System.out.println("------------------------------------");

        }

    }

    public void DonusTipiOlmayanFonksiyonlar(String kelime, String[] satirbol) {
        Pattern fonksiyon = Pattern.compile("((public|pravate|protocted)+(\\s)*+(\\S)+(\\s)*+ [(]+[)?])|((public|pravate|protocted)+(\\s)*+(\\S)+(\\s)*+[(]+[)?])");
        //Dönüş tipi olmayan fonsiyon için ise public başlayıp metod ismi geliyor ve sonra parantez aç kapa işlemi oluyor ve hiçbir parametre almıyorsa donustipi olmayan metoddur.
        Matcher fonk = fonksiyon.matcher(kelime);//Match ile eşleşmesini sağlıyoruz
        while (fonk.find())//Döngü içinde bu eşleşmeleri arıyoruz
        {
            satirbol = fonk.group().split(" ");//Satır böl ile kelimeleri boşluğa göre bölüyoruz.
            String methodismi = satirbol[1].trim();//metod ismi 1 indeksdeki kelimedir.

            System.out.println(methodismi.trim());//metod ismini yazdırıyoruz
            System.out.println("Dönüş türü: Yok");//Constroctor olduğu için dönüş tipi yoktur
            System.out.println("Aldığı parametre: " + 0);//Aldığı parametre 0 dır.
            System.out.println("------------------------------------");
        }

    }

    public void DonusTipiOlanFonksiyonlar(String kelime, String[] kelimebol) {
        Pattern fonksiyon = Pattern.compile("(public|private)+(\\s)*+(int|String|boolean|void)+(\\s)*+(\\S)+ (\\s)*+([(]+[)])|((public|private)+(\\s)*+(int|String|boolean|void)+(\\s)*+(\\S)+ ([(]+[)]))");
        //Metod ismi public ile başlayıp string void boolean gibi dönüş türü geliyor ve sonra metod ismi gelip parantez aç kapa oluyorsa dönüş tipi olan metotdur diyoruz.
        Matcher donustipiolan_fonk = fonksiyon.matcher(kelime);//match ile fonksiyon eşleşmesini sağlıyoruz.

        while (donustipiolan_fonk.find())//Döngü içinde bir eşleşme var ise bunları group oluşturuyoruz
        {

            kelimebol = donustipiolan_fonk.group().split(" ");//Boşluk sayısına göre ayırıyoruz.
            String methodismi = kelimebol[2];//metod ismi 0 saymaya başlayınca 2 kelime
            String donusturu = kelimebol[1];//donusturu ise 1 kelimedir
            System.out.println(methodismi.trim());//metod ismini yazdırıyoruz
            System.out.println("Dönüş türü: " + donusturu.trim());//Dönüştürünü yazdırıyoruz
            System.out.println("Aldığı parametre Sayısı: " + 0);//Metod ismi sonra hiç bir parametre almadığı için 0 kabul ediyoruz.
            System.out.println("------------------------------------");

        }

    }

    public void DosyaOku(String dosya_yolu) {
        Scanner input = new Scanner(System.in);//Kullanıcının giriş yapmasına sağlıyoruz
        try {
            FileReader file = new FileReader(dosya_yolu);
            BufferedReader oku = new BufferedReader(file);//Dosya yolunu okuyor dosyayı okuyoruz.
            String metin;
            String kelime = "";

            while ((metin = oku.readLine()) != null)//metin nin sonu null olana kadar okuyoruz null oldumu çıkıyoruz
            {
                kelime += metin + "\n";//sonra metinin satırlarını kelimeye atıyoruz.

            }
            System.out.println("Kaynak dosya başarıyla okundu");
            System.out.println("");
            System.out.println(kelime);//Kelimeyi ekrana yazdırıyoruz. 
            String kaydet = kelime.replaceAll("   ", " ");//iki veya daha fazla boşluk varsa tek boşluk
            String noktalıvirgul = kelime.replaceAll(";", " ;");//noktalı virgül birleşikse boşluk bırakıp ayırıyoruz.
            String parantez = kelime.replace("(", " (");//parantez var önüne boşluk bırak ayırıyoruz.

            System.out.println("");
            System.out.println("-------------------------------------------------------------------------");

            oku.close();//okuma işlemini kapatıyoruz.

            String[] kelimebolme = null;//kelime adında string bir dizi tanımlıyoruz.

            System.out.println(SinifAdiBul(kelime, kelimebolme));//Sınıf bul metodunu çağırıyoruz.
            AltEleman(noktalıvirgul, kelimebolme);//Alt eleman ile alt eleman metodunu çağırıyoruz
            System.out.println("Üye Fonksiyonları: " + UyeFonksiyonSayisi(kelime));//Üye Fonksiyonları metodunun çağırıyoruz
            System.out.println("------------------------------------");
            parametresayisi(parantez, kelimebolme);

            DonusTipiOlanFonksiyonlar(parantez, kelimebolme);//Donus tipi olan metodu çağırıyoruz
            DonusTipiOlmayanFonksiyonlar(parantez, kelimebolme);//Donustipi Olmayan metodu çağırıyoruz

        } catch (IOException ex) {
            System.out.println("Hata: " + ex);//Dosya okumada bir yanlış olursa verilecek hata
        }

    }

}
