package LineEditor;

import junit.framework.TestCase;
import java.io.*;

public class LineEditorTest extends TestCase {
    private File_Buffer FILE = new File_Buffer();
    private String[] file = {"C:\\Users\\����\\�� ����\\LineEditor\\file.txt"};
    private Init_Exit Start_End;
    private Cmd_Driver Run_Command = new Cmd_Driver();
    private UserCmd commandLineTokens;
    boolean done = false;
    
    protected void setUp() throws Exception {
    	 Start_End = new Init_Exit(file,FILE);
    }
    
   // T command ���� (CLN�� �ֻ�ܿ� �ִ��� Ȯ��)
    public void testT() {
    	Run_Command.Cmd_T(FILE);
    	assertEquals(1,FILE.GetCLN());
    	}
    
    // E command ���� (CLN�� ���� ������ line���� �Ǿ����� Ȯ��)
    public void testE() {
    	Run_Command.Cmd_E(FILE);
    	assertEquals(10,FILE.GetCLN());
    	}
    
    // N command ���� (CLN�� �Է��� line �� ��ŭ �Ʒ��� �̵��Ǿ����� Ȯ��)
    public void testN() {
    	Run_Command.Cmd_N(FILE,3);
    	assertEquals(4,FILE.GetCLN());
    	}
    
    // B command ���� (CLN�� �Է��� line �� ��ŭ ���� �̵��Ǿ����� Ȯ��)
    public void testB() {
    	Run_Command.Cmd_E(FILE);
    	int i=FILE.GetCLN();
    	Run_Command.Cmd_B(FILE,4);
    	assertEquals(i-4,FILE.GetCLN());
    	}
    
    // W command ���� (��ġ ��ġ�ϴ��� Ȯ��)
    public void testW() {
    	Run_Command.Cmd_N(FILE,3);
    	int i=FILE.GetCLN();
    	Run_Command.Cmd_W(FILE);
    	assertEquals(i,FILE.GetCLN());
    	}
    
    // L command ����
    public void testL() {
    	Run_Command.Cmd_N(FILE,2);
    	int i=FILE.GetCLN();
    	Run_Command.Cmd_L(FILE,1);
    	assertEquals(i,FILE.GetCLN());
    	}
    
    // D command ���� (�Է��� �� ��ŭ �����Ǵ��� Ȯ��)
    public void testD() {
    	int i=FILE.NumLins();
    	Run_Command.Cmd_D(FILE,3);
    	assertEquals(i-3,FILE.NumLins());
    	}
    
    // Y,P command ���� 
    public void testYP() {
    	int i=FILE.NumLins();
    	Run_Command.Cmd_T(FILE);
    	Run_Command.Cmd_Y(FILE,3);
    	Run_Command.Cmd_P(FILE);
      	assertEquals(i+3,FILE.NumLins());
    	}
    
    // O command ���� 
    public void testO() {
    	String [] test = new String [3];
    	int i=0;
    	Run_Command.Cmd_O(FILE,3);
    	test[0]="one";
    	test[1]="three";
    	test[2]="two";
    	if(test[0].equals(FILE.GetLine(1))&&test[1].equals(FILE.GetLine(2))&&test[2].equals(FILE.GetLine(3))) {
    		i=1;
    	}
    	assertEquals(i,1);
    	}
}