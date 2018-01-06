package jva8trials;




public class Anonymuscheck {
	
	
	public static void main(String[] args) {
		
	
//	trialInterface trial = new trialInterface() {
//		
//		@Override
//		public int method1(int l, int b) {
//			// TODO Auto-generated method stub
//			int sum=l+b;
//			return sum;
//		}
//	};
	
	trialInterface trial = (l,b) -> {int sum=l+b;return sum;};
	
	System.out.println(trial.method1(4,3));}

}
