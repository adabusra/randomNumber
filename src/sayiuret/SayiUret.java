
package sayiuret;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class SayiUret {
    
    public static void main(String[] args)  throws FileNotFoundException, IOException {
        
      RandomSayi.Menu();       
      Scanner in=new Scanner(System.in);
      int menuItem;
      boolean quit=false;
      String fileName = "veriler.txt";
      File f = new File(fileName);
      do{
            //System.out.print("Program baslamistir"+"\n");
            menuItem = in.nextInt();
        switch (menuItem) {
            case 1:
                File file = new File(fileName);
                //    File file=new File("veriler.txt");
                    PrintWriter pw=null;
                    try{
                        pw = new PrintWriter(file);
                    } catch (IOException e) {
                        System.out.println("Hata!");
                    }
                    int sayi=RandomSayi.uret();
                    //System.out.println(sayi+" tane random sayi uretilecek"+"\n"+"*****************");
       
                     Integer[]RandomDizi=new Integer[sayi];
       
                    for(int i=1;i<sayi;i++){
           
                    RandomDizi[i]=RandomSayi.turet();
                    }
       
                    for(int j=1; j<RandomDizi.length; j++){
                    //System.out.println(RandomDizi[j]);
                        pw.println(RandomDizi[j]);
                    }
                    pw.close();
                    break;
            case 2:
                
                    if (f.exists()) { 
                        FileReader fr = new FileReader(fileName);
                        BufferedReader br = new BufferedReader(fr);
                        String s;
                            while ((s = br.readLine()) != null) {
                                int sayii = Integer.parseInt(s);
                                System.out.println("Sayi: " + sayii);
                            }
                            fr.close();  
                    }
                    else 
                    {
                        System.out.println("Sayı üretilmemiş önce sayı üretin");
                    }
                    break;
            case 3:
                if (f.exists()) {
                    FileReader fr = new FileReader(fileName);
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine()) != null) {
                        int sayii = Integer.parseInt(s);
                        //İslemler Buraya
                        double x;
                        if(sayii>-1 && sayii<0)
                        {
                            x=sayii+1;
                            System.out.println("Sonuc :  "+x );
                        }
                        else if(sayii>3 && sayii<5)
                        {
                            x=2*sayii-6;
                            System.out.println("Sonuc:  "+x );
                        }
                       else
                        {
                            x=0;
                            System.out.println("Sonuc:  "+x );
                        }
                    }
                    fr.close();  
                }
                else {
                    System.out.println("Sayı üretilmemiş önce sayı üretin");
                }
                    break;
            case 0:
                    quit = true;
                    break;
                  default:
                    System.out.println("Invalid choice.");
                  }
            } while (!quit);
            System.out.println("Bye-bye!");
     
    }
      
       
        
       /*int sayi=RandomSayi.uret();
       System.out.println(sayi+" tane random sayi uretilecek"+"\n"+"*****************");
       
       Integer[]RandomDizi=new Integer[sayi];
       
       for(int i=1;i<sayi;i++){
           
           RandomDizi[i]=RandomSayi.turet();
       }
       
       for(int j=1; j<RandomDizi.length; j++){
           System.out.println(RandomDizi[j]);
       }
       */
       //code smell kötü kokan kokd
        }  
    
    

 class RandomSayi
{
      static void Menu(){
        System.out.println("1- Bulunan sayiları dosyaya kaydet");
        System.out.println("2- Dosyadaki sayıları listele");
        System.out.println("3- Islem sonucunu goster");
     }
    
    public static int uret(){
         return (10+ (int)(Math.random()*89));
    }
    
    public static int turet(){
          return ((-1)+(int)(Math.random()*9));
    }

}

