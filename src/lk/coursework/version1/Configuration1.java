/*
package lk.coursework.version1;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

import static java.nio.file.Files.write;

public class Configuration1 {
    private int totalTickets;
    private int ticketReleaseAmount;

    public Configuration1(int totalTickets, int ticketReleaseDate){
        this.totalTickets = totalTickets;
        this.ticketReleaseAmount = ticketReleaseAmount;
    }
    
    //getting data and passing it
    public void saveConfig(Configuration1 config){
        Gson gson = new Gson();
        String json = gson.toJson(this);

        try{
            FileWriter file = new FileWriter(config.json);
            file.write(json);
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //read file json
    //write file json


}
*/