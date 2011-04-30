package me.galenwinterdusk.arcana;

public class ArcanaCharacter {
	
	  private String player = null;
	  private String characterName = null;
	  private String casterType = null;
	  private int casterLevel = -1;
	  private String spellbookList = null;

	  public ArcanaCharacter(String player, String characterName, String casterType, int casterLevel, String spellbookList) {
	    super();
	    this.player = player;
	    this.characterName = characterName;
	    this.casterType = casterType;
	    this.casterLevel = casterLevel;
	    this.spellbookList = spellbookList;
	  }


	  public String getPlayer() {
	    return player;
	  }

	  public void setPlayer(String player) {
	    this.player = player;
	  }

	  public String getCharacterName() {
	    return characterName;
	  }

	  public void setCharacterName(String characterName) {
	    this.characterName = characterName;
	  }

	  public String getcasterType() {
		    return casterType;
		  }

		  public void setcasterType(String casterType) {
		    this.casterType = casterType;
		  }
	  
	  public int getcasterLevel() {
	    return casterLevel;
	  }
	  
	  public void setcasterLevel(int casterLevel) {
	    this.casterLevel = casterLevel;
	  }
	  
	  public String getspellbookList() {
		    return spellbookList;
		  }
	  
}
