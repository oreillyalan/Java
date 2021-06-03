
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import java.io.File;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile() {
         
        FileResource fr = new FileResource();
         for (String s : fr.lines()) {
         LogEntry le = WebLogParser.parseEntry(s);
         records.add(le);
        }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
     public void printAllHigherThanNum (int num) {
     for (LogEntry le : records) {
         //int statusCode = le.getStatusCode();
         if (le.getStatusCode() > num){
             System.out.println(le);
            }
     }
     } 
             
     
    public int countUniqueIPs () {
     
     ArrayList<String> uniqueIPs = new ArrayList<String>();
     
     for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         if (!uniqueIPs.contains(ipAddr)){
             uniqueIPs.add(ipAddr);
            }
     }
     
     return uniqueIPs.size();
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
    ArrayList<String> uniqueIPs = new ArrayList<String>();
    ArrayList<String> uniqueIPsOnDate = new ArrayList<String>();
     for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         Date dates = le.getAccessTime();
         String dateToCheck = dates.toString().substring(4,7)+" "+dates.toString().substring(8,10);
         if (dateToCheck.equals(someday) && !uniqueIPs.contains(ipAddr)){
             uniqueIPsOnDate.add(le.getIpAddress());
             uniqueIPs.add(ipAddr);
             //System.out.println(le.toString());
            }
        
         
     }
    
    return uniqueIPsOnDate;
    }
    
    public ArrayList<String> ipVisitsOnDay(String someday){
    ArrayList<String> uniqueIPs = new ArrayList<String>();
    ArrayList<String> uniqueIPsOnDate = new ArrayList<String>();
     for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         Date dates = le.getAccessTime();
         String dateToCheck = dates.toString().substring(4,7)+" "+dates.toString().substring(8,10);
         if (dateToCheck.equals(someday)){
             uniqueIPsOnDate.add(le.getIpAddress());
             uniqueIPs.add(ipAddr);
             //System.out.println(le.toString());
            }
        
         
     }
    
    return uniqueIPsOnDate;
    }
    
    public int countUniqueIPsInRange(int low, int high){
     int count = 0;
     ArrayList<String> uniqueIPs = new ArrayList<String>();
     for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         if (le.getStatusCode() >= low && le.getStatusCode() <= high){
             
             if (!uniqueIPs.contains(ipAddr)){
                 uniqueIPs.add(ipAddr);
                 count++;
                }
             
            }
        
         
     }   
        
    return count;
   }
   
    public HashMap<String, Integer> countVisitsPerIP(){
     HashMap<String, Integer> count = new HashMap<String, Integer>();
     
     for (LogEntry le : records) {
         String ipAddr = le.getIpAddress();
         if (!count.containsKey(ipAddr)){
                count.put(ipAddr,1);
            }
         else {
            count.put(ipAddr,count.get(ipAddr)+1);
            }
         
         
     }   
        
    return count;
   }

   public int  mostVisitsPerIP(HashMap<String, Integer> count){
    int rollingCount = 0;
    for (Map.Entry<String, Integer> entry : count.entrySet()) {
        if(entry.getValue() > rollingCount){rollingCount = entry.getValue();}
    }
    return rollingCount;
   }
   
   public ArrayList<String> ipsMostVisits(HashMap<String, Integer> count){
    ArrayList<String> mostVistitedIPs = new ArrayList<String>();
    int ipCount = mostVisitsPerIP(count);
    for (Map.Entry<String, Integer> entry : count.entrySet()) {
        if(entry.getValue() == ipCount){mostVistitedIPs.add(entry.getKey());}
    }
    return mostVistitedIPs;
   }

   public HashMap<String, ArrayList<String>> iPsForDays(){
    HashMap<String, ArrayList<String>> ipsForDays = new HashMap<String, ArrayList<String>>();
     for (LogEntry le : records) {
     String ipAddr = le.getIpAddress();
     Date dates = le.getAccessTime();
     String dateToCheck = dates.toString().substring(4,7)+" "+dates.toString().substring(8,10);
     if (!ipsForDays.containsKey(dateToCheck)){
                ipsForDays.put(dateToCheck,ipVisitsOnDay(dateToCheck));
     }
     }
    return ipsForDays;
  }

   public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipsForDays){
    StringBuilder sb = new StringBuilder();
    int size = 0;
    for (Map.Entry<String, ArrayList<String>> entry : ipsForDays.entrySet()) {
        if(size <= entry.getValue().size()){ 
            size = entry.getValue().size();
            sb = new StringBuilder();
            sb.append(entry.getKey());
            
        }
    
    }
    return sb.toString();
  }
  
  public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> ipsForDays, String date){
    ArrayList<String> iPsWithMostVisitsOnDay = ipsForDays.get(date);
    HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();
    for (String ips : iPsWithMostVisitsOnDay) {
         
         if (!ipCounts.containsKey(ips)){
                ipCounts.put(ips,1);
            }
         else {
            ipCounts.put(ips,ipCounts.get(ips)+1);
            }
         
         
     } 

    return ipsMostVisits(ipCounts);
  }
  
}