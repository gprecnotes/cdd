import java.util.*;
public class Exp3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of productions:");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] p = new String[num];
        System.out.println("Enter the grammar as E->E-A:");
        for (int i = 0; i < num; i++) {
            p[i] = scanner.nextLine();
        }
        for (int j = 0; j < num; j++) {
            System.out.println("\nGRAMMAR:" + p[j]);
             char ch1= p[j].charAt(0);
             String lp=p[j].substring(3);
             String spl[] =lp.split("\\|+");
             List<String> beta=new ArrayList<>();
             List<String> alpha=new ArrayList<>();
             for(int i=0;i<spl.length;i++)
             {
            	 if(spl[i].charAt(0)==ch1)
            	 {
            		 alpha.add(spl[i].substring(1));
            	 }
            	 else
            		 beta.add(spl[i]);
             }
             if(alpha.size()==0)
             {
            	 System.out.println(p[j]+" has no left recursion");
            	 continue;
             }
             System.out.println("After removing of left recursion ");
             System.out.print(ch1+"->");
             for(int i=0;i<beta.size();i++)
             {
            	 System.out.print(beta.get(i)+""+ch1+"\'");
            	 if(i<beta.size()-1)
            		 System.out.print("|");
             }
             System.out.println();
             System.out.print(ch1+"\'->");
             for(int i=0;i<alpha.size();i++)
             {
            	 System.out.print(alpha.get(i)+""+ch1+"\'|");
             }
             System.out.println("ε");
             }
    }
}