package HangMan;

public class Hangmna {

	private String answer;
	private int errorCount;
	private String currentState;
	
    final int TOP_PERCENT = 10;
    final int HEAD_PERCENT = 15;
    final int TORSO_PERCENT = 35;
    final int LEGS_PERCENT = 20;
	
	//---Constructors---
	public Hangmna (String ans)	{	
		answer = ans;
		errorCount = 0;
		for(int i = 0; i<=answer.length(); i++)	{
			currentState += " _ ";
		}
	}
	
	//---Getters and Setter---
	public String getAnswer() {
		return answer;
	}

	public String getCurrentState() {
		return currentState;
		
	}
	
	public String getErrorCount() {
		
		return answer;
		
	}
	
	//---Methods---
	public boolean testChar(char letter)	{
		boolean retur = false;
		for(int i = 1; i <= answer.length(); i++)	{
			if (answer.charAt(i) == letter)	{
				currentState =  currentState.substring(0, i) + letter + currentState.substring(i+2);
				retur = true;
			}

		}
		
		return retur;
		
	}
	
}
