import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Enchanted 
{
    final static String os = System.getProperty("os.name");

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException 
    {
        Scanner scan = new Scanner(System.in);

        final String path = "C:\\Users\\Greggy\\OneDrive\\Desktop\\ENCHANTED.WAV";
        File enchanted = new File(path);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(enchanted);
        Clip music = AudioSystem.getClip();
        music.open(audioStream);

        cls();

        System.out.print("Enter 'p' to play: ");
        String response = scan.next();

        if (response.equalsIgnoreCase("p")) music.start();
        scan.close();

        final String[] lyrics = 
        {
            "This", "is", "me", "praying", "that", "-",
            "This", "was", "the", "very", "first", "page", "-",
            "Not", "where", "the", "story", "line", "ends", "-",
            "My", "thoughts", "will", "echo", "your", "name,", "until", "I", "see", "you", "again", "-",
            "These", "are", "the", "words", "I", "held", "back,", "as", "I", "was", "leaving", "too", "soon", "-",
            "I", "was", "enchanted", "to", "meet", "you", "-",
            "Please", "don't", "be", "in", "love", "with", "someone", "else", "-",
            "Please", "don't", "have", "somebody", "waiting", "on", "you :(" 
        };

        // Edit the delay for each words according to your likings
        int[] milisec = 
        {
            380, 400, 400, 800, 400, 800,
            380, 350, 350, 420, 350, 350, 400,
            390, 400, 400, 450, 450, 400, 400,
            390, 400, 390, 410, 390, 900, 490, 420, 430, 430, 480, 400,
            390, 390, 390, 390, 390, 390, 900, 400, 400, 400, 400, 400, 400, 400,
            390, 390, 610, 400, 500, 2400, 400,
            500, 800, 500, 400, 400, 400, 1500, 1300, 200,
            500, 800, 400, 700, 700, 390, 5000,
        };

        cls();

        // Intro
        Thread.sleep(2100);

        // Lyrics
        for (int i = 0; i < lyrics.length; i++) 
        {
            if (lyrics[i].equals("-")) cls();
            else System.out.print(lyrics[i] + " ");
            
            Thread.sleep(milisec[i]);
        }
    }
    
    /* Use this 'cls' method if you run this in command prompt */
    private static void cls()
    {
        if (os.contains("Windows"))
        {
            try 
            { 
                new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor(); 
            } 
            catch (Exception e) 
            { 
                e.printStackTrace(); 
            }   
        }
    }

    /* Use this 'cls' method if you run this in IDE */
    // private static void cls()
    // {
    //     System.out.print("\033[H\033[2J");
    //     System.out.flush();  
    // }
}
