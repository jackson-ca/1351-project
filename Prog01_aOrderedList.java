/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prog01_aOrderedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.io.PrintWriter;
import static prog01_aOrderedList.aOrderedList.aOrderedListObject;
/**
 *
 * @author jacka
 */
/**
* <getters and constructor for car class, compares car objects based on year and price>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/2024>
*
*/
class car implements Comparable<car> 
{
    private String Make;
    private int Year;
    private int Price;
/**
* <constructor for car class>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public car (String make, int year, int price)
    {
        Make=make;
        Year=year;
        Price=price;
    }
/**
* <returns make of car>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public String getMake()
    {
        return Make;
    }
/**
* <returns year of car>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public int getYear()
    {
        return Year;
    }
/**
* <returns price of car>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public int getPrice()
    {
        return Price;
    }
    /**
* <compares car objects based on year, then price>
*
* CSC 1351 Programming Project No <1>
* Section <2>>
*
* @author <jackson Adams>
* @since <3/17/24>
*
*/
    public int compareTo(car other)
    {
        
        if (Year>other.Year)
        {
            return 1;
        }
        else if (Year<other.Year)
        {
            return -1;
        }
        else if (Year==other.Year)
        {
            if (Price>other.Price)
            {
                return 1;
            }
            else if (Price<other.Price)
            {
                return -1;
            }
                    
        }
        return 0;
    }
/**
* <prints make year and price of car>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public String toString()
    {
        return "Make: "+Make+", Year: "+Year+", Price " +";";
    }
                    
}
/**
* <Prog01_aOrderedList get inputs file, reads input file, rewrites content to output file and prints the output file>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/16/2024>
*
*/
public class Prog01_aOrderedList 
{
/**
* <main method, calls methods below to read input file and rewrite to output file>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public static void main(String[] args) throws FileNotFoundException 
    {
        aOrderedListObject = new aOrderedList();
        Scanner scan = GetInputFile("Y");
        readInputFile(scan);
        PrintWriter pw = GetOutputFile("Y");
        printOutputFile(pw);

    }
/**
* <uses recursion for input validation, returns scanner "in">
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException
    {
        Scanner in= new Scanner(System.in);
        File inputFile;
        String filename;
        String answer;
        
        if(UserPrompt.equals("Y"))
        {
            System.out.print("Enter input filename: ");
            filename= in.nextLine();
            inputFile =new File(filename);
            if(!inputFile.exists())
            {
                System.out.println("File specified <"+filename+"> does not exist.");
                System.out.print("Do you want to continue? Y/N");
                answer=in.next();
                GetInputFile(answer);
            }
            else
            {
                in= new Scanner(new File(filename));
                return in;
            }
                    
        }
        else
        {
            throw new FileNotFoundException();
        }
        return null;
    }
/**
* <prompts user for output file using recursion>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public static PrintWriter GetOutputFile(String userPrompt) throws FileNotFoundException 
    {
        Scanner scan = new Scanner(System.in);
        File outputFile;
        String fileName;
        String response;
        PrintWriter pw;
        
        if (userPrompt.equals("Y")) 
        {
            System.out.println("Enter output fileName:");
            fileName =scan.next();
            outputFile =new File(fileName);
            if (!outputFile.exists()) 
            {
                System.out.println("File specified <"+fileName+"> does not exist. ");
                System.out.println("Would you like to continue ? <Y/N>");
                response =scan.next();
                GetOutputFile(response);
                response =scan.next();
                GetOutputFile(response);
            } 
            else 
            {
                pw = new PrintWriter(new File(fileName));
                return pw;
            }
        } 
        else
        {
            throw new FileNotFoundException();
        }
        return null;
    }
/**
* <either adds or deletes car object based on first letter of every line of input file>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public static void readInputFile(Scanner scan) throws FileNotFoundException 
    {
        scan = scan.useDelimiter("\\,");
        String firstLetter;
        String make;
        int year;
        int price;
        int delete;
        firstLetter =scan.next();
        do 
        {
            if (firstLetter.equals('A')) 
            {
                make =scan.next();
                year =scan.nextInt();
                price =scan.nextInt();
                car newCar = new car(make, year, price);
                aOrderedListObject.add(newCar);
                scan.nextLine();

            }
            if (firstLetter.equals("D")) 
            {
                delete =scan.nextInt();
                aOrderedListObject.remove(delete);
            }
        } 
        while (scan.hasNextLine());
    }
/**
* <prints size of new output file and make, year and price of every car object in output file>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public static void printOutputFile(PrintWriter pw) 
    {
        pw.println("number of cars : " + aOrderedListObject.size());
        for (int i = 0; i < aOrderedListObject.size(); i++) 
        {
            pw.println("Make :" + aOrderedListObject.get(i).getMake());         //error started showing after Step 8
            pw.println("Year :" + aOrderedListObject.get(i).getYear());
            pw.println("Price :" + aOrderedListObject.get(i).getPrice());
            pw.println();
        }

    }

}
/**
* <aOrderedList is used to add/delete/reaarange car objects in an ordered list>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/16/2024>
*
*/
class aOrderedList
{
    static aOrderedList aOrderedListObject;
    
    
    private final int SIZE_INCREMENTS=20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr;
/**
* <constructor of aOrderedList class>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public aOrderedList()
    {
        numObjects=0;
        listSize=SIZE_INCREMENTS;
        oList= new Comparable[listSize];
    }
/**
* <adds a car object, makes room if needed>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public void add(Comparable newCar)
    {
        oList[numObjects]= newCar;
        numObjects++;
        if (numObjects==oList.length)
        {
               Comparable[] list2= Arrays.copyOf(oList, 2*oList.length);
               oList=list2;
        }
        sortList();
    }
    /**
* <returns make year and price of car enclosed by brackets>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public String tostring() 
    {
        if (oList.length >0) 
        {
            for (int i =0; i <oList.length; i++) 
            {
                return "[" +oList[i].toString()+ "]";
            }
        }
        return null;
    }
/**
* <returns the size of list>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public int size() 
    {
        return numObjects;
    }
    /**
* <returns true if list is empty>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public boolean isEmpty() 
    {
        if (numObjects ==0) 
        {
            return true;
        }
        return false;
    }
/**
* <deletes car at certain index while maintaining list order>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public void remove(int carNumber) 
    {
        if (carNumber<=numObjects) 
        {
            for (int i =carNumber; i <numObjects; i++) 
            {
                oList[i] =oList[i +1];
            }
            oList[numObjects] =null;
            numObjects--;
        }
    }
/**
* <maintains sorted order of array>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public void sortList() 
    {
        for (int x =0; x <oList.length- 1; x++) 
        {
            for (int i= x+1; i <oList.length; i++) 
            {
                if (oList[x].compareTo(oList[i])> 1) 
                {
                    Comparable temp_car =oList[x];
                    oList[x] =oList[i];
                    oList[i] =temp_car;
                }
            }
        }
    }
    /**
* <reads an object and adds it to the list>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    private void add(Comparable newObject, int index)
    { 
	for(int i = numObjects; i > index; i--)
        {
            oList[i] = oList[i-1];
	}
        oList[index] = newObject;
	numObjects++;
    }
/**
* <returns object at position "index">
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    Comparable get(int index) 
    {
        return oList[index];
    }
/**
* <resets iterator so next element is first element>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public void reset()
    {                              
        curr = 0;
    }
/**
* <returns next element of array>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
    public Comparable next()
    {       
        curr++;
        return oList[curr];
    }
/**
* <returns true if there are still car objects in the array>
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
     public boolean hasNext()
    {         
        return curr + 1 < numObjects;
    }
/**
* <removes element of array at "curr">
*
* CSC 1351 Programming Project No <1>
* Section <2>
*
* @author <Jackson Adams>
* @since <3/17/24>
*
*/
     public void remove()
    {              
	this.remove(curr);
	curr = 0;
    }
    
}


            
    

    

    
        

