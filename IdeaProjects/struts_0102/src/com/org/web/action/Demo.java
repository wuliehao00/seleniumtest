package com.org.web.action;

public class Demo {
    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int i=0;i<jsonStr.length();i++){
            char c = jsonStr.charAt(i);
            if(level>0&&'\n'==jsonForMatStr.charAt(jsonForMatStr.length()-1)){
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c+"\n");
                    level++;
                    break;
                case ',':
                    char d = jsonStr.charAt(i-1);
                    if(d == '"' || d == ']'){
                        jsonForMatStr.append(c+"\n");
                    } else {
                        jsonForMatStr.append(c);
                    }
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }

    private static String getLevelStr(int level){
        StringBuffer levelStr = new StringBuffer();
        for(int levelI = 0;levelI<level ; levelI++){
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

    public static void main(String[] args){
        String s = format("{\"name\":\"高级搜索\",\"request\":{\"method\":\"GET\",\"header\":[],\"body\":{\"mode\":\"raw\",\"raw\":\"\"},\"url\":{\"raw\":\"http://localhost:8080/v1/bugs/63c77beb-18f0-464f-90ef-767bb51877da\",\"protocol\":\"http\",\"port\":\"8080\",\"host\":[\"localhost\"],\"path\":[\"v1\",\"id\",\"63c77beb-18f0-464f-90ef-767bb51877da\"]}},\"response\":[]}");
        System.out.println(s);
    }
}
