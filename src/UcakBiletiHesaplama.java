import java.util.Scanner;
public class UcakBiletiHesaplama {
    public static void main(String[] args) {

        Scanner dogukan = new Scanner(System.in);
        int mesafe , yas , yolculukTipi;
        double birimFiyat = 0.10;
        double toplamFiyat , indirimOrani = 0;

        System.out.print("Mesafe (KM): ");
        mesafe = dogukan.nextInt();

        System.out.print("Yaşınız: ");
        yas = dogukan.nextInt();

        System.out.print("Yolculuk Tipi (1: Tek Yön, 2: Gidiş-Dönüş): ");
        yolculukTipi = dogukan.nextInt();

        dogukan.close();


        // Geçerli verilerin kontrolü
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        }

        // Toplam fiyat hesaplama
        toplamFiyat = mesafe * birimFiyat;

        // Yaşa göre indirim uygulama
        if (yas < 12) {
            indirimOrani = 0.5;
        } else if (yas >= 12 && yas <= 24) {
            indirimOrani = 0.1;
        } else if (yas >= 65) {
            indirimOrani = 0.3;
        }

        // Yolculuk tipine göre indirim uygulama
        if (yolculukTipi == 2) {
            indirimOrani += 0.2;
        }

        // Indirim hesaplama ve son fiyatı yazdırma
        double indirimMiktari = toplamFiyat * indirimOrani;
        double odenecekFiyat = toplamFiyat - indirimMiktari;

        System.out.printf("Toplam Fiyat: %.2f TL\n", toplamFiyat);
        System.out.printf("İndirim Tutarı: %.2f TL\n", indirimMiktari);
        System.out.printf("Ödenecek Fiyat: %.2f TL\n", odenecekFiyat);


    }
}
