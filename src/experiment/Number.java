package experiment;

import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Number {
	ArrayList<User> users = new ArrayList<User>();
	User u1 = new User("花花");
	User u2 = new User("花花1");
	User u3 = new User("花花2");
	User u4 = new User("花花3");
	User u5 = new User("花花4");
	int[] num = new int[4];
	
	public Number() {
		// TODO Auto-generated constructor stub
		u5.setScore(4);
		u1.setScore(4);
		u2.setScore(5);
		u3.setScore(2);
		u4.setScore(1);
		
		users.add(u5);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
	}
	
	public int[] getNumber() {
		
		
		num[0] = (int) (Math.random()*10);
		
		while(true) {
			num[1] = (int) (Math.random()*10);
			if(num[1] != num[0])break;
		}
		
		while(true) {
			num[2] = (int) (Math.random()*10);
			if(num[2] != num[0] && num[2] != num[1])break;
		}
		
		while(true) {
			num[3] = (int) (Math.random()*10);
			if(num[3] != num[0] && num[3] != num[1] && num[3] != num[2])break;
		}
		
		return num;
	}
	
	public int[] tip(int[] value) {
		int n = 0;
		int m = 0;
		for(int i = 0;i<4; i++) {
			if(value[i] == num[i]) {
				n++;
			}else {
				for(int j = 0;j<4 && j!=i ;j++) {
					if(value[i] == num[j]) {
						 m++;
						 break;
					}
				}
			}
		}
		int[] arr = {n, m};
		return arr;		
	}
	
	public int[] getAnswer() {
		return this.num;
	}
	
	public boolean judge(User u) {
		for(User item:users) {
			if(item.getName().equals(u.getName()))return false;
		}
		return true;
	}
	
	public boolean add(User u) {
		for(User item:users) {
			if(item.getName() == u.getName())return false;
		}
		users.add(u);
		return true;
	}
	
	public boolean saveScore(User u) {
		for(User item:users) {
			if(item.getName() == u.getName()) {
				item.setScore(u.getScore());
				return true;
			}
		}
		return false;
	}
	
	public void setScore(User u) {
		for(User item: users) {
			if(item.getName() == u.getName()) {
				item.setScore(u.getScore());
				break;
			}
		}
	}
	
	public String[] getRank() {
		User[] rank = new User[users.size()];
		int p = 0;
		for(User item:users) {
			if(p == 0) {
				rank[p] = item;
			}else{
				for(int i = 0;i<p;i++) {
//					System.out.println(item.getScore()  + "   " + rank[i].getScore() + (item.getScore() < rank[i].getScore()));
					if(item.getScore() < rank[i].getScore()) {
						for(int j = p;j>i;j--) {
							System.out.println(rank[j-1].getScore());
							rank[j] = rank[j-1];
						}
						rank[i] = item;
//						System.out.println("break?");
						break;
					}
					if(rank[p] == null) {
						rank[p] = item;
					}
				}
			}
			p++;
//			System.out.println("已经加入的了:" + p);
		}
		String[] Rank = new String[users.size()];
		int m = 0;
		for(User item:rank) {
			Rank[m] = m+1 + "   " + item.getName() + "----次数：" + item.getScore() + "    ";
			m++;
		}
		return Rank;
	}
	


}
