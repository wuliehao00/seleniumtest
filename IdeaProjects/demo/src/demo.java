public class demo {
    public static void main(String[] args){
        demo m = new demo();
        System.out.println(m.getWordLength("My name is jackwuliehao"));
        System.out.println('c');
        int i = 0x100;
        System.out.println(i);
        int z =0;
        System.out.println(z);
        byte a1 = 3;
        byte b2 = 4;
        System.out.println(a1+b2);
        short s1 = 1;
        s1 +=1;
    }
    public int getWordLength(String str){
        String[] s = str.split(" ");
        return s[s.length-1].length();
    }
}
