import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        FileWriter write = new FileWriter("users.txt",true);
        FileReader read = new FileReader("users.txt");

        Scanner sc = new Scanner(System.in);

        System.out.print("Would you like to log your record? (y/n): ");
        String signIn = sc.nextLine();
        System.out.print("Preferred song\n(Insert filename and file must be in csaFinal folder)\nEnter Here:");
        String fileName = sc.nextLine();
        StringBuilder uFile = new StringBuilder();
        int ch;

        while((ch = read.read()) != -1 )
            uFile.append((char) ch);

        if(signIn.equalsIgnoreCase("y")){
            System.out.print("Enter username: ");
            String uName = sc.nextLine();
            System.out.print("Enter Password: ");
            String pWord = sc.nextLine();
            String uInf = uName + pWord;
            System.out.print(uFile);
            if(uFile.toString().contains(uInf) && uName.length() > 0 && pWord.length() > 0){
                System.out.print("Welcome back " + uName + "\nHow much would you like to bet?: ");
                String bet = sc.nextLine();
                blackJackNew user = new blackJackNew(uName,bet);
                user.hit();
                blackJackBGui buttons = new blackJackBGui();
                while(user.getHandVal() < 21 && !(buttons.hitStay())) {
                    if (buttons.hitStay())
                        user.hit();
                    else
                        user.stay();
                }
            }
            else{
            write.write(uInf + "\n");
            System.out.print("User added");
        }}
        write.close();
        read.close();

    }


}