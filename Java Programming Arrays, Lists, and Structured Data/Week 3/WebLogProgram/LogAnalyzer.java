
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
    
     // public void returnDate () {
     
     // String _dates = "Sep 14";
     // String _dates1 = "Sep 14";
     // for (LogEntry le : records) {
         // Date dates = le.getAccessTime();
         // String dateToCheck = dates.toString().substring(4,7)+" "+dates.toString().substring(8,10);
         // //System.out.println("Date pulled from list: "+dateToCheck +" Hardcoded: "+_dates);
         // if (dateToCheck.equals(_dates)){
             // System.out.println(le.toString());
            // }
        // // else System.out.println("Didnt work mate");
         
     // }
     
    // }
    
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
   

}