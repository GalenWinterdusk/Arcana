package me.galenwinterdusk.arcana;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ArcanaCharacterList {
	
	public Arcana plugin;
	private static final Logger log = Logger.getLogger("Minecraft");
	
	public ArcanaCharacterList(Arcana instance){
		this.plugin = instance;
	}
	
	public static final String Directory = "plugins" + File.separator + "Arcana" + File.separator + "Data";

	public static ArrayList<ArcanaCharacter> getArcanaCharacterList(){
		File file = new File(Directory);
		if (!file.exists() || !file.isDirectory()){
			file.mkdirs();
			}

		ArrayList<ArcanaCharacter> arcanacharacters = new ArrayList<ArcanaCharacter>();
	    File txtFile = new File(Directory, "arcanacharacters.txt");
	    if (!txtFile.exists()){
	      try {
	        txtFile.createNewFile();
	      } catch (Exception e){
	        e.printStackTrace();
	      }
	    }
	    try {
	      BufferedReader br = new BufferedReader(new FileReader(txtFile));
	      String curLine;
	     
	      while ((curLine = br.readLine()) != null){
	        String[] split = curLine.split(":");
	        ArcanaCharacter character = new ArcanaCharacter(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4]);
	        arcanacharacters.add(character);
	      }
	      br.close();
	    } catch (IOException e){
	      e.printStackTrace();
	    }

	    return arcanacharacters;
	  }
	
	  
	  public static void addArcanaCharacter(ArcanaCharacter c){
	    File file = new File(Directory);
	    if (!file.exists() || !file.isDirectory()){
	      file.mkdirs();
	    }

	    File txtFile = new File(Directory, "arcanacharacters.txt");
	    if (!txtFile.exists()){
	      try {
	        txtFile.createNewFile();
	      } catch (Exception e){
	        e.printStackTrace();
	      }
	    }

	    try {
	      BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile, true));
	      bw.write(c.getPlayer() +  ":" + c.getCharacterName() + ":" + c.getcasterType() + ":" + c.getcasterLevel() + ":" + c.getspellbookList());
	      bw.newLine();
	      bw.flush();
	      bw.close();
	    } catch (IOException e){
	      e.printStackTrace();
	    }
	  }

	  public static void deleteArcanaCharacter(ArcanaCharacter c){
	    File file = new File(Directory);
	    if (!file.exists() || !file.isDirectory()){
	      file.mkdirs();
	    }

	    File txtFile = new File(Directory, "arcanacharacters.txt");
	    if (!txtFile.exists()){
	      try {
	        txtFile.createNewFile();
	      } catch (Exception e){
	        e.printStackTrace();
	      }
	    }

	    try {
	      BufferedReader br = new BufferedReader(new FileReader(txtFile));
	      String curLine;
	      StringBuilder toKeep = new StringBuilder();
	      while ((curLine = br.readLine()) != null){
	        String split[] = curLine.split(":");
	        if (!split[0].equalsIgnoreCase(c.getPlayer()) 
	            && !split[1].equalsIgnoreCase(c.getCharacterName()) 
	            && !split[2].equalsIgnoreCase(c.getcasterType()) 
	            && !split[3].equalsIgnoreCase(String.valueOf(c.getcasterLevel()))){
	          toKeep.append(curLine).append("\r\n");
	        }
	      }
	      br.close();
	      BufferedWriter bw = new BufferedWriter(new FileWriter(new File(Directory, "arcanacharacters.txt")));
	      bw.write(toKeep.toString());
	      bw.close();

	    } catch (Exception e){
	      log.warning("[Arcana] Error while deleting a character from ArcanaCharacterList.");
	      e.printStackTrace();
	    }
	  }

	  public static void updateArcanaCharacter(ArcanaCharacter c){
	    deleteArcanaCharacter(c);
	    addArcanaCharacter(c);
	  }

}
