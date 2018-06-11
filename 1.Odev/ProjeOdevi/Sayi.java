package paket;
/**
 *
 * @Ahmet Armutc ahmetarmutcuogr@sakarya.edu.tr
 * @08.03.2018 ve 10.03.2018 arası
 * <p>
 * Projem belirtilen kaynak dosyasındaki bilgileri okuyorak bu veriler üzerinde
 * regex sayesinede işlem yapılarak ekrana yazılan bir programdır.
 * </p>
 */
public class Sayi {
 private int deger;
 private boolean eksimi;

 public Sayi(int deger){
 this.deger = deger;
 eksimi = deger < 0;
 }
 public void setDeger(int value){
 this.deger = value;
 eksimi = this.deger < 0;
 }
 public boolean Eksimi(){
 return eksimi;
 }
 @Override
 public String toString() {
 return String.valueOf(deger);
 }
}
