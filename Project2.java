package project2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


// главный класс
public class Project2 {

    public static void main  (String[] args) throws FileNotFoundException, IOException {
        String ans;

        FlyData fData = new FlyData();

        fData.base = fData.readBase("flights_small.csv");

        ans = fData.FirstAnswer(fData.base) + "\n"
                + fData.SecondAnswer(fData.base) + "\n"
                + fData.ThirdAnswer(fData.base) + "\n"
                + fData.FourthAnswer(fData.base) + "\n"
                + fData.FivethAnswer(fData.base) + "\n"
                + fData.SixthAnswer(fData.base) + "\n"
                + fData.SeventhAnswer(fData.base) + "\n"
                + fData.EightAnswer(fData.base) + "\n"
                + fData.NinethAnswer(fData.base);

        try (FileOutputStream fos = new FileOutputStream("answers.txt")) {
            byte[] bytes = ans.getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Project2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.io.IOException ex) {
            Logger.getLogger(Project2.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
