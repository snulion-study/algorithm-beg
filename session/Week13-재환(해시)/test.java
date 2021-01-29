public class test {
    public static void main(String[] args) {
        String str1 = new String("study end");
        String str2 = new String("study end");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
    }

}
