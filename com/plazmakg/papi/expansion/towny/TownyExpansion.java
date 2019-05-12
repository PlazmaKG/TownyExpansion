package com.plazmakg.papi.expansion.towny;

import com.palmergames.bukkit.towny.db.TownyDataSource;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownyUniverse;
import java.util.ArrayList;
import java.util.List;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class TownyExpansion
  extends PlaceholderExpansion
{
  public boolean canRegister()
  {
    return Bukkit.getPluginManager().getPlugin(getPlugin()) != null;
  }
  
  public String getAuthor()
  {
    return "PlazmaKG";
  }
  
  public String getIdentifier()
  {
    return "towny";
  }
  
  public String getPlugin()
  {
    return "Towny";
  }
  
  public String getVersion()
  {
    return "1.0";
  }
  
  public String onPlaceholderRequest(Player p, String identifier)
  {
    if (p == null) {
      return "";
    }
    if (identifier.equals("surname")) {
      return getPlayersSurname(p);
    }
    if (identifier.equals("town_rank")) {
      return getTownRank(p);
    }
    if (identifier.equals("nation_rank")) {
      return getNationRank(p);
    }
    if (identifier.equals("town_size")) {
      return getTownSize(p);
    }
    if (identifier.equals("nation_size")) {
      return getNationSize(p);
    }
    if (identifier.equals("town_mayor")) {
      return getTownMayor(p);
    }
    if (identifier.equals("nation_king")) {
      return getNationKing(p);
    }
    if (identifier.equals("town")) {
      return getPlayersTown(p);
    }
    if (identifier.equals("nation")) {
      return getPlayersNation(p);
    }
    if (identifier.equals("town_balance")) {
      return getTownBalance(p);
    }
    if (identifier.equals("nation_balance")) {
      return getNationBalance(p);
    }
    if (identifier.equals("town_tag")) {
      return getTownTag(p);
    }
    if (identifier.equals("nation_tag")) {
      return getNationTag(p);
    }
    if (identifier.equals("friends")) {
      return getPlayersFriends(p);
    }
    if (identifier.equals("title")) {
      return getPlayersTownyTitle(p);
    }
    if (identifier.equals("town_residents")) {
      return getTownResidents(p);
    }
    if (identifier.equals("nation_residents")) {
      return getNationResidents(p);
    }
    if (identifier.equals("nation_towns")) {
      return getNationTowns(p);
    }
    return null;
  }
  
  private String getPlayersSurname(Player p)
  {
    String title = "";
    try
    {
      title = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getSurname());
    }
    catch (Exception e)
    {
      return "";
    }
    return title;
  }
  
  private String getTownRank(Player p)
  {
    String rank = "";
    try
    {
      List<String> ranks = TownyUniverse.getDataSource().getResident(p.getName()).getTownRanks();
      if ((ranks != null) && (!ranks.isEmpty())) {
        for (String r : ranks) {
          if (TownyUniverse.getDataSource().getResident(p.getName()).hasTownRank(r))
          {
            rank = r;
            break;
          }
        }
      }
    }
    catch (Exception e)
    {
      return "";
    }
    return rank;
  }
  
  private String getNationRank(Player p)
  {
    String rank = "";
    try
    {
      List<String> ranks = TownyUniverse.getDataSource().getResident(p.getName()).getNationRanks();
      if ((ranks != null) && (!ranks.isEmpty())) {
        for (String r : ranks) {
          if (TownyUniverse.getDataSource().getResident(p.getName()).hasNationRank(r))
          {
            rank = r;
            break;
          }
        }
      }
    }
    catch (Exception e)
    {
      return "";
    }
    return rank;
  }
  
  private String getTownSize(Player p)
  {
    String size = "";
    try
    {
      size = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getTotalBlocks());
    }
    catch (Exception e)
    {
      return "";
    }
    return size;
  }
  
  private String getNationSize(Player p)
  {
    List<Town> Size = new ArrayList();
    int intsize = 0;
    try
    {
      Size = TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getTowns();
      for (int i = 0; i < Size.size(); i++) {
        intsize += ((Town)Size.get(i)).getTotalBlocks();
      }
    }
    catch (Exception e)
    {
      return "";
    }
    return Integer.toString(intsize);
  }
  
  private String getTownMayor(Player p)
  {
    String mayor = "";
    try
    {
      mayor = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getMayor().getName());
    }
    catch (Exception e)
    {
      return "";
    }
    return mayor;
  }
  
  private String getNationKing(Player p)
  {
    String king = "";
    try
    {
      king = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getCapital().getMayor().getName());
    }
    catch (Exception e)
    {
      return "";
    }
    return king;
  }
  
  private String getPlayersTown(Player p)
  {
    String town = "";
    try
    {
      town = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getName());
    }
    catch (Exception localException) {}
    return town;
  }
  
  private String getPlayersNation(Player p)
  {
    String nation = "";
    try
    {
      nation = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getName());
    }
    catch (Exception e)
    {
      return "";
    }
    return nation;
  }
  
  private String getTownBalance(Player p)
  {
    String balance = "";
    try
    {
      balance = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getHoldingBalance());
    }
    catch (Exception e)
    {
      return "";
    }
    return balance;
  }
  
  private String getNationBalance(Player p)
  {
    String balance = "";
    try
    {
      balance = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getHoldingBalance());
    }
    catch (Exception e)
    {
      return "";
    }
    return balance;
  }
  
  private String getTownTag(Player p)
  {
    String tag = "";
    try
    {
      tag = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getTag());
    }
    catch (Exception e)
    {
      return "";
    }
    return tag;
  }
  
  private String getNationTag(Player p)
  {
    String tag = "";
    try
    {
      tag = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getTag());
    }
    catch (Exception e)
    {
      return "";
    }
    return tag;
  }
  
  private String getPlayersFriends(Player p)
  {
    String res = "";
    try
    {
      res = String.valueOf(TownyUniverse.getDataSource()
        .getResident(p.getName()).getFriends().size());
    }
    catch (Exception e)
    {
      return "";
    }
    return res;
  }
  
  private String getPlayersTownyTitle(Player p)
  {
    String title = "";
    try
    {
      title = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTitle());
    }
    catch (Exception e)
    {
      return "";
    }
    return title;
  }
  
  private String getTownResidents(Player p)
  {
    String res = "";
    try
    {
      res = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNumResidents());
    }
    catch (Exception e)
    {
      return "";
    }
    return res;
  }
  
  private String getNationResidents(Player p)
  {
    String res = "";
    try
    {
      res = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getNumResidents());
    }
    catch (Exception e)
    {
      return "";
    }
    return res;
  }
  
  private String getNationTowns(Player p)
  {
    String towns = "";
    try
    {
      towns = String.valueOf(TownyUniverse.getDataSource().getResident(p.getName()).getTown().getNation().getNumTowns());
    }
    catch (Exception e)
    {
      return "";
    }
    return towns;
  }
}
