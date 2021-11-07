/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author ha
 */
public class Tp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        
        String str ;
        String   str1=null;
        
        
        int s=0;
       
       
        
          
        System.out.println("entrer ton code:");
        Scanner sc =new Scanner (System.in);
        str = sc.nextLine();
         //  lire le txte chiffre en entre (maximum 6ligne): 
        while (sc.hasNext()){
            s++ ;
            str1=sc.nextLine();
             
              
        str =str+str1;
        if (s>=5)break ;
        
   
        }     
        
        
         
      
        int d=inter (str);                                           //appel à la  méthode inter 
        int dec=Decalage(d) ;                                        //compter le décalage
        System.out.println("la clé est :"+dec);                       //affichage de la clé
        String lm=convert(str,dec);                                    // le déchiffrement 
        System.out.println("le txte dechiffrer est :\n"+lm);              //affichage du texte déchiffré
        
    }
    
    public static int inter( String ss){             // méthode  qu'on va la donné notre texte chiffé et qui va trouver 
                                                     //la lettre la plus repeté et retourner sa position dans l'alphqbet 
                                                        //français 
        
        
        
        String alphabet="abcdefghijklmnopqrstuvwxyz";    //chaine de caractere qui contient toute l'alphabet en ordre 
                                                       // pour connaitre la position de chaque lettre dans l'alphabet 
        
        int c=0;                                        
        int d=0;
        char e=0 ;
        for (int j=0;j<25;j++){                          // calculer l'occurence de chaque lettre de  l'alphabet 
            
           int b ;
            b = compteOccurences(ss,alphabet.charAt(j));     //fonction qui calcule le nombre d'occurence d'une lettre dans une chaine 
          if (b>=c){
          c=b;                                             //contient toujours le nombre d'occurence de la la lettre la plus fréquente
          e=alphabet.charAt(j);                            //garder la lettre la plus frequente 
          d=j;                                            //garder la position de la lettre la plus fréquente
          }
          
        
        
    }
        return d;
    }
    public static int Decalage(int m){                      //d'apres le tableau de fréquence de lettres on sait que la lettre la plus 
                                                                //fréquente dans le français c'est le "e", donc on va compter le déclage entre 
                                                             //la lettre la plus repeter et le "e" dans cette methode
          
        
        if (m>=4)return m-4 ;                           // on cas la lettre situeé apres le "e" dans l'alphabet
              return(26-4+m);                           //on cas la lettre situeé avant le "e"
        
          
         
    }
    public static String convert(String s,int decl){   //methode qui dechiffre notre texte lettre par lettre a l'aide d'un tableau 
                                                       //de 26 caracteres (l'alphabet francaise) a travers d'un décalage calculer par 
                                                       //la methode decalge()
        String alphabet1="abcdefghijklmnopqrstuvwxyz";
        s=s.toLowerCase();                    
        char []alph=alphabet1.toCharArray();            //convertion des chaines de caracteres en tableau de caracteres pour
        char []s1 =s.toCharArray();                      //avoir modifier dans les cases du tableau
        
        
        
        for (int i=0;i<s.length();i++){                 //traiter notre texte caractere par caractere 
        
            for (int j=0;j<25;j++){
       while ( s.charAt(i)==alphabet1.charAt(j)){       //boucle pour faire connaitre la position de chaque lettre dans l'alphabet
         
          if(j>=decl) 
          s1[i]=alph[j-decl];else s1[i]=alph[26-(decl-j)];                  //faire le décalage (retourner en arrire dans l'alphabet)
          break;
       }
                }
        
        }
        s=String.valueOf(s1);                                             //reconvertion de texte dechiffré en chaine de caracteres 
        return s;
    }
    public static int compteOccurences(String maChaine,char recherche) {  //definition de la fonction compte occurence utilise en haut
       
    maChaine=maChaine.toLowerCase();
    int nb=0;
    for (int i=0;i<maChaine.length();i++){
        if (maChaine.charAt(i)==recherche )
            nb++;
    
    }
    return nb;
    }
    
}
