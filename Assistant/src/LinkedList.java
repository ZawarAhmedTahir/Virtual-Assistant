/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.speech.freetts.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Hp
 */
public class LinkedList {
    	
   public static String EditeventName;
   public static String Editdate;
   public static String Editmonth;
   public static String Edityear;
   public static String Edithour;
   public static String Editminute;
   public static String Editedate;
   public static String Editemonth;
   public static String Editeyear;
   public static String EditvenueName;
   public static boolean Editpriority;
   
   

    /* pointer of head node */
    /* pointer of tail node */
    private Node head;
    private Node tail;
    private int size;

    /* Constructors with No Arguments */
    public LinkedList()
    {
        size = 0;
        /* Initialize the head and tail node */
        head = tail = null;
    }
    /* Constructors with a given value of a list node */
    public LinkedList(int val){}
    /* Destructor */
    //~LinkedList(void){}

    /*insert a single node in the linked list at its tail*/
    public void insertAtTail(int _data){
        System.out.print("in functio");
    Node node=new Node ();
    if(head == null){
        head = node;
        tail = head;
    }
    else{
        tail.next=node;
        node.prev=tail;
        tail=node;
    }
     tail.next = null;
    }
    public void insertAtHead(Node node){
    node.next=head;
    head.prev=node;
    head=node;
    node.prev=null;
}

    public void traverse_and_print_tail( /* Voice voce */ ){
     Node p=tail;
    while(p!=null){
        System.out.print(p.eventName+", ");
        System.out.print(p.date+"/");
        System.out.print(p.month+"/");
        System.out.print(p.year+"  ");
        System.out.print(p.hour+": ");
        System.out.print(p.minute+"  ");
        System.out.print(p.edate+"/");
        System.out.print(p.emonth+"/");
        System.out.print(p.eyear+"  ");
        System.out.print(p.venueName+"  ");
        System.out.print(p.priority+"\n");
        p=p.prev;
    }
    System.out.println();
    }
    
    
    
    public void traverse_and_print_head(){
    Node p=head;
    System.out.println("From head");
    while(p!=null){
        System.out.print(p.eventName+" ");
        System.out.print(p.date+"/");
        System.out.print(p.month+"/");
        System.out.print(p.year+"  ");
        System.out.print(p.hour+":");
        System.out.print(p.minute+"  ");
        System.out.print(p.edate+"/");
        System.out.print(p.emonth+"/");
        System.out.print(p.eyear+"  ");
        System.out.print(p.venueName+"  ");
        System.out.print(p.priority+"\n");
        p=p.next;
    }
    System.out.println();
}
       public void deleteEvent_byName(String name){
        System.out.println("Ready to delete "+name);
        int i=0;
        Node p=head;
        String temp=" ";
        
    while(p!=null){
        if(p.eventName.equalsIgnoreCase(name)){
            //System.out.print(p.eventName+", found=======");
            p.prev.next = p.next;
            p.next.prev = p.prev;
            p = null;
            i++;
        }
        else
        {
            p=p.next;
        }
    }
    if (i==0){System.out.println("Event not found");}
}
    
    public void sizeIncrease(){
        size++;
    }
    public int sizeGetter(){
        return size;
    }

    public int searchData(int num){       //Search data
        Node p = head;
        int j=0;
        for(int i=1;i<=size;i++){
            if(p.date==num){
                j = i;
            }
            p = p.next;
       }
       return j;
    }
    
    void create_Event(String name,int dt,int mnth,int yer,int hr,int min,int edt,int emnth,int eyer,String venName,boolean pri){
    //System.out.print("in function");
    Node node=new Node (name,dt,mnth,yer,hr,min,edt,emnth,eyer,venName,pri);
    if(head == null){
        head = node;
        tail = head;
    }
    else{
        tail.next=node;
        node.prev=tail;
        tail=node;
    }
     tail.next = null;
    }
    
    
    void readFromFile(){
        try {
            String line="";
            String msg="";
            LinkedList list1 = new LinkedList();
            int eventCount=0;
            
            // TODO add your handling code here:
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Hp\\Desktop\\Assistant\\src\\dataBase.txt"));
            
            while((msg = br.readLine()) != null){
                line += msg + "\n";
                eventCount++;
            }
            br.close();
            JOptionPane.showMessageDialog(null," "+line);
        } catch (IOException ex) {
            Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }

    public void writeOnFile(){
        Node p=new Node();
        p=head;
    try {
            // TODO add your handling code here:
            //close();
        LoginForm HF = new LoginForm();
        //System.out.println("FileName : "+HF.FileName);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Hp\\Desktop\\Assistant\\test\\DataFiles\\"+HF.FileName));
        while(p!=null){
        bw.write(p.eventName+" "+p.date+" "+p.month+" "+p.year+" "+p.hour+" "+p.minute+" "+p.edate+" "+p.emonth+" "+p.eyear+" "+p.venueName+" "+p.priority+" "/*+System.lineSeparator()*/);
        p=p.next;
        }
        bw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Unable to open file.","Error!(LinkedList)",JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"No events created yet");
            Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    //p=null;
    }
    
    
  public void sortSinlge(LinkedList list1){
        Node p=list1.head;
        list1.head.prev = null;
        Node q=null;
        Node tmp=null;
        Node sz=list1.head;
   // int listSize=list1.findSize(list1);
        while(sz!=null){
            p=head;         //start and resets from head
            q=head;         //start and resets from head
        while (p.next!=null){
            if(p.eyear > p.next.eyear){
            tmp=p.next;                //swaping
            p.next=p.next.next;
            tmp.next=p;
                if(p==head){
                    head=tmp;           //for first iteration
                    //cout<<"head=teamp"<<endl;
                }
                else{
                q.next=tmp;        //for remaining iterations
                    //cout<<"q->next=tmp"<<endl;
                }
                p=tmp;
               }
            q=p;
            p=p.next;
        }
        sz=sz.next;
    }
       // list1.head->prev=NULL;
}
    
    public void sortDouble(LinkedList list1){
    //cout<<"sortDouble(LinkedList list1)"<<endl;
    list1.sortSinlge(list1);
    list1.head.prev=null;
    Node p=list1.head;
    while(p.next!=null){
            p.next.prev=p;
            p=p.next;

    }
}
    
    public void writeOnfile(){
        Node p=new Node();
        LoginForm HF = new LoginForm();
        p=head;
        Node q=head;
        int size=0;
        while(q!=null){
        size++;
        q=q.next;
        }
        int i=1;
        System.out.println("size====="+size);
        
    try {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Hp\\Desktop\\Assistant\\test\\DataFiles\\"+HF.FileName));
        while(p!=null ){
        if(i<size){
        bw.write(p.eventName+" "+p.date+" "+p.month+" "+p.year+" "+p.hour+" "+p.minute+" "+p.edate+" "+p.emonth+" "+p.eyear+" "+p.venueName+" "+p.priority+" ");
        System.out.println("i====="+i);    
        i++;
        }
        else if(i==size){
        bw.write(p.eventName+" "+p.date+" "+p.month+" "+p.year+" "+p.hour+" "+p.minute+" "+p.edate+" "+p.emonth+" "+p.eyear+" "+p.venueName+" "+p.priority+" "+System.lineSeparator());        
        System.out.println("i====="+i);    
        i++;
        }
        p=p.next;
        }
        
        //bw.write("\n");
        bw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Unable to open file.","Error!(LinkedList)",JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null,"No events created yet");
            Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    //p=null;
    
    
    }
    
    
    
    
    public void deleteEvent_byName2(String  name){
       // name="Event_5";
        System.out.println("Ready to delete "+name);
        int i=0,size=0;
        Node p=head;
        Node temp=head;
        Node tm=head;
        String str=null;
    while(temp!=null)
    {
        size++;
        temp = temp.next;
    }
    while(p!=null){
        String n=p.eventName;
        p.eventName=n;
       // name="Event";
         System.out.println(p.eventName+name+"  "+(n.equals(name)));
        if(n.equals("\n"+name)){
            System.out.println(p.eventName+", found=======");
            
            i++;
            tm=p;
            break;
        }
        else
        {
            p=p.next;
            i++;
        }
    }
    if (i==0){System.out.println("Event not found");    if (i==0){System.out.println("Event not found");}
    }
    else if(i==1){head = head.next;System.out.println("First");}
    else if(i>1 && i<size){
       
        tm.prev.next = tm.next;
        tm.next.prev = tm.prev;
        tm = null;
       
       System.out.println("Mid");
    }
    else if(i==size){
        tail = tail.prev;
        tail.next=null;
        System.out.println("Last");
    }
    else{
        
    }
}

    public void search_byName2(String  name){
       // name="Event_5";
        System.out.println("Ready to delete "+name);
        int i=0,size=0;
        Node p=head;
        Node temp=head;
        Node tm=head;
        String str=null;
    while(temp!=null)
    {
        size++;
        temp = temp.next;
    }
    while(p!=null){
        String n=p.eventName;
        p.eventName=n;
       // name="Event";
         System.out.println(p.eventName+name+"  "+(n.equals(name)));
        if(n.equals("\n"+name)){
            System.out.println(p.eventName+", found=======");
            EditeventName=p.eventName;
            Editdate=Integer.toString(p.date);
            Editmonth=Integer.toString(p.month);
            Edityear=Integer.toString(p.year);
            Edithour=Integer.toString(p.hour);
            Editminute=Integer.toString(p.minute);
            Editedate=Integer.toString(p.edate);
            Editemonth=Integer.toString(p.emonth);
            Editeyear=Integer.toString(p.eyear);
            EditvenueName=p.venueName;
            Editpriority=p.priority;
            i++;
            tm=p;
            break;
        }
        else
        {
            p=p.next;
            i++;
        }
    }
    if (i==0){System.out.println("Event not found");    if (i==0){System.out.println("Event not found");}
    }
    else if(i==1){head = head.next;System.out.println("First");}
    else if(i>1 && i<size){
       
        tm.prev.next = tm.next;
        tm.next.prev = tm.prev;
        tm = null;
       
       System.out.println("Mid");
    }
    else if(i==size){
        tail = tail.prev;
        tail.next=null;
        System.out.println("Last");
    }
    else{
        
    }
}
    











    
    
    
    
    
    

class Node
{
   
   public String eventName;
   public int date;
   public int month;
   public int year;
   public int hour;
   public int minute;
   public int edate;
   public int emonth;
   public int eyear;
   public String venueName;
   public boolean priority;
   
   
    Node next;
    Node prev;


    Node()
    { 
    next=null;
    prev=null;
    }

    Node(String name,int dt,int mnth,int yer,int hr,int min,int edt,int emnth,int eyer,String venName,boolean pri)
    {
    eventName=name;
    date=dt;
    month=mnth;
    year=yer;
    hour=hr;
    minute=min;
    edate=edt;
    emonth=emnth;
    eyear=eyer;
    venueName=venName;
    priority=pri;
    
    next=null;
    prev=null;
    }

    Node(String name,int dt,int mnth,int yer,int hr,int min,int edt,int emnth,int eyer,String venName,boolean pri, Node _pNext, Node _pPrev)
    {
    eventName=name;
    date=dt;
    month=mnth;
    year=yer;
    hour=hr;
    minute=min;
    edate=edt;
    emonth=emnth;
    eyear=eyer;
    venueName=venName;
    priority=pri;
    next=_pNext;
    prev=_pPrev;
    }
    public String getName(){
		return eventName;
	}
    public int getDate(){
		return date;
	}
    public int getMobth(){
		return month;
	}
    public int getYear(){
		return year;
	}
    public int getHour(){
		return hour;
	}
    public int getMinute(){
		return minute;
	}
    public int getEDate(){
		return edate;
	}
    public int getEMobth(){
		return emonth;
	}
    public int getEYear(){
		return eyear;
	}
    public String getvenueName(){
		return venueName;
	}
    public boolean getPriority(){
		return true;
	}

    Node getNext(){
		return next;
	}
	Node getPrev(){
		return prev;
	}
};

}
