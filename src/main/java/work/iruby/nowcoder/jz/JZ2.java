package work.iruby.nowcoder.jz;

public class JZ2 {
    static class Test{
        public static void main(String[] args) {
            JZ2 jz2 = new JZ2();
            System.out.println(jz2.replaceSpace("We Are Happy"));
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}