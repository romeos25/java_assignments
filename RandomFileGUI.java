import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public  class RandomFileGUI extends JFrame implements ActionListener {
	
   int id; String dept, name; double mid, fin;
   TextField text1,text2, text3, text4, text5;
   Button clear, save, first, next, exit; 
   RandomAccessFile file;

  RandomFileGUI()
  {   openFile();   
      setTitle("Demo RandomAccessFile");
      setLayout(new GridLayout(10,2,10,5));
	  add(new Label("id   "));
      add(text1 = new TextField(" ",20));
      add(new Label("dept  "));
      add(text2 = new TextField(" ",20));
      add(new Label("name   "));
      add(text3 = new TextField(" ",20));
      add(new Label("midterm  "));
      add(text4 = new TextField(" ",20));
      add(new Label("final   "));
      add(text5 = new TextField(" ",20));
 	  add(clear = new Button("Clear"));
	  add(save = new Button("Save"));
      add(first = new Button("first"));
      add(next = new Button("next"));
	  add(exit = new Button("Exit"));
	  clear.addActionListener(this);
      save.addActionListener(this);
      first.addActionListener(this);
	  next.addActionListener(this);
	  exit.addActionListener(this);
  }
 

  public void actionPerformed(ActionEvent e){
      if(e.getSource() == save)
            { id   = Integer.parseInt(text1.getText().trim());
	          dept = text2.getText().trim();
			  name = text3.getText().trim();
		      mid  = Double.parseDouble(text4.getText().trim()); 
		      fin  = Double.parseDouble(text5.getText().trim());
		      prtFile(); 
		      clearText();}
        else if(e.getSource() == clear)
               {clearText();} 
        else if (e.getSource() == first)
	           {readFile(0);}			  
		else if (e.getSource() == next)
	           {readFile(1);}			 
        else if(e.getSource() == exit) 
			   {closeFile(); System.exit(0);}  
   } 
  public void clearText(){
	          text1.setText("");
		      text2.setText("");
		      text3.setText("");
			  text4.setText("");
		      text5.setText("");     }
	  
  public void readFile(int s){
         try{  switch (s)
			    { case 0 : {file.seek(0); break;}
                  case 1 : { long p  = file.getFilePointer();
					         if(p >=  file.length()) file.seek(0);
							 else file.seek(p);
							 break;}
                }

		        text1.setText(String.valueOf(file.readInt()));
                text2.setText(file.readUTF());
			    text3.setText(file.readUTF());
			    text4.setText(String.valueOf(file.readDouble()));
			    text5.setText(String.valueOf(file.readDouble()));
		    }
        catch (IOException e)
		{System.out.println("Error Writeing to file ");System.exit(1);} 
  }
  public void prtFile() {
    try{ file.seek(file.length());
	     file.writeInt(id);
		 file.writeUTF(formText(dept,6));
		 file.writeUTF(formText(name,20));
		 file.writeDouble(mid);
		 file.writeDouble(fin);
	    }
	catch (IOException e)
		{System.out.println("Error Writeing to file ");System.exit(1);} 
	  }

  public void openFile()
	{ boolean success=false ;
      do{try
		     {String filename = JOptionPane.showInputDialog("enter filename");  
		      file = new RandomAccessFile(filename,"rw");
			  success = true;   }
          catch (IOException e)
		     {System.out.println("File cannot Open");
		      success = false;}
       }while (!success);
 	}
  public void closeFile()
	  { try { file.close();}
	    catch(IOException e) 
		   {System.out.println("error closing file");System.exit(1);} 
	  }
  public static String formText(String x, int k)
	{int p = x.length();
	 for (int i = p+1;i <= k ;i++ )
	     x = x+" ";
	 return x;  
	 } 
	 
  public static void main(String[] args) throws IOException{
	  RandomFileGUI f = new RandomFileGUI(); 
	  f.setVisible(true);  
      f.setSize(100,400);
	  f.setLocation(30,20);            
      f.addWindowListener(new windowListener());
	}
}
