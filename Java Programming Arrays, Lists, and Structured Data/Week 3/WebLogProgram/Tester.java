
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAll();
    }
    
    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println("Unique IP's : "+la.countUniqueIPs());
    }
        
    public void testStausCodeGreatherThan(){
        int num = 400;
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println("LogEntrys that have a status code greater than "+ num);
        la.printAllHigherThanNum(num);
    }
    
            
    public void testDateGetter(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        // System.out.println(la.uniqueIPVisitsOnDay("Sep 14"));
        // System.out.println(la.uniqueIPVisitsOnDay("Sep 30"));
        System.out.println(la.uniqueIPVisitsOnDay("Mar 24").size());
        System.out.println(la.uniqueIPVisitsOnDay("Mar 17").size());
    }
    
                
    public void testcountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println(la.countUniqueIPsInRange(200,299));
        //System.out.println(la.countUniqueIPsInRange(300,399));
        
    }
}
