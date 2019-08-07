package model;


import java.io.*;
import java.util.*;
/**
 * Class LeaderBoard creates a leader board for storing player's scores by establishing a read
 * write relationship with the "inventory.dat" file. The data structure of the leader board is an 
 * ArrayList. Class LeaderBoard contains functionality to store scores from games as well as return those
 * scores to UI. 
 * 
 * @author RR2
 * @version 1.0
 *
 */
public class memberInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	ArrayList <Customer> list = null;
	/**
	 * Default constructor establishes the relationship between the current order and the "memberInfo.properties" file
	 */

	public memberInfo()
	{
		this.list = readFromFile(); 
	}
	/**
	 * 
	 * @return the current leader board
	 */
	public ArrayList<Customer> displayMembersInfo()
	{
		return this.list;
	}
	/**
	 * Adds the score of the current game to the leader board
	 * @param game - the score of the current game that is added to the leader board
	 */
	public void storeScore(Customer Customer)
	{
		this.list.add(Customer);
		writeToFile(this.list);
	}
	/**
	 * Establishes the read functionality for the "inventory.dat" file and gets the current contents
	 * @return the list of game scores that has been written to the file
	 */
    @SuppressWarnings("unchecked")
	private static ArrayList <Customer> readFromFile()
    {
        ArrayList <Customer> list = new ArrayList <Customer> ();
        try
        {
            FileInputStream fis = new FileInputStream("inventory.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList <Customer> ) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(FileNotFoundException FNF)
        {
        	return list;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace(); 
            return null;
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * Establishes the write functionality for the "memberInfo.properties" file and adds the latest member's 
     * info to the file.
     * @param list - the current membership info from sign-up that is to be added to the file
     */
    private static void writeToFile(ArrayList <Customer> list)
    {
        try
        {
            FileOutputStream fos= new FileOutputStream("memberInfo.properties");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        oos.writeObject(list);
	        oos.close();
	        fos.close();
        }
        catch(IOException ioe)
        { 
        	ioe.printStackTrace();
        }
    }
}
