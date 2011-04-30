package me.galenwinterdusk.arcana;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class ArcanaCharacterManager {

	public static ArrayList<ArcanaCharacter> characters;
	
	  public static void initialize(){
		    loadCharacters();
		  }

		  public static ArcanaCharacter getCharacterByPlayerName(String name){
		    for (ArcanaCharacter c: characters){
		      if (c.getPlayer().equals(name)){
		        return c;
		      }
		    }

		    return null;

		  }

		  public static void loadCharacters(){
		    characters = ArcanaCharacterList.getArcanaCharacterList();

		  }

		  public static boolean playerHasACharacter(Player player){
		    for (ArcanaCharacter c: characters){
		      if (c.getPlayer().equals(player.getName()))
		        return true;
		    }   
		    return false;
		  }

		  
		  public static boolean nameHasACharacter(String name){
		    for (ArcanaCharacter c: characters){
		      if (c.getPlayer().equals(name)){
		        return true;
		      }
		    } 
		    return false;
		  }
		  
		  public static void saveCharacters(){
		    for(ArcanaCharacter c: characters){
		    	ArcanaCharacterList.updateArcanaCharacter(c);
		    }
		  }

		  public static void addCharacter(ArcanaCharacter character){
		    characters.add(character);
		    ArcanaCharacterList.updateArcanaCharacter(character);
		  }

		  public static boolean characterExistsWithFrontname(String characterName){
		    for (ArcanaCharacter c: characters){
		      if (c.getCharacterName().startsWith(characterName)){
		        return true;
		      }
		    }
		    return false;
		  }

		  public static boolean characterExistsWithName(String characterName){
		    for (ArcanaCharacter c: characters){
		      if (c.getCharacterName().equals(characterName)){
		        return true;
		      }
		    }
		    return false;
		  }

		  public static ArrayList<ArcanaCharacter> getCharacterByCharacterFrontname(String name){
		    ArrayList<ArcanaCharacter> characters = new ArrayList<ArcanaCharacter>();
		    for (ArcanaCharacter c: characters){
		      if (c.getCharacterName().startsWith(name)){
		        characters.add(c);
		      }
		    }
		    return characters;
		  }

		  public static ArcanaCharacter getCharacterByCharacterName(String name){
		    for (ArcanaCharacter c: characters){
		      if (c.getCharacterName().equals(name)){
		        return c;
		      }
		    }
		    return null;
		  }
	
}
