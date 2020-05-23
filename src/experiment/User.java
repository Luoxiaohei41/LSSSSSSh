package experiment;

public class User {
	private String name;
	private int score;
	public User(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.score = 0;
	}
	
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
