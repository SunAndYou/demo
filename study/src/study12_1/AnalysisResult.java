package study12_1;

import java.io.*;

public class AnalysisResult {
    public static void main(String args[]) {
        File fRead = new File("H:\\Users\\1\\IdeaProjects\\ssp_basic01\\study\\score.txt");
        File fWrite = new File("socreAnalysis.txt");
        try{ Writer out = new FileWriter(fWrite,true);//以尾加方式创建指向文件 fWrite 的 out 流
            BufferedWriter bufferWrite = new BufferedWriter(out);//创建指向 out 的 bufferWrite 流
            Reader in = new FileReader(fRead);//创建指向文件 fRead 的 in 流
            BufferedReader bufferRead =new BufferedReader(in);//创建指向 in 的 bufferRead 流
            String str = null;
            while((str=bufferRead.readLine())!=null) {
                double totalScore=Fenxi.getTotalScore(str);
                str = str+"总成绩:"+totalScore;
                System.out.println(str);
                bufferWrite.write(str);
                bufferWrite.newLine();
            }
            bufferRead.close();
            bufferWrite.close();
        }
        catch(IOException e) {
            System.out.println(e.toString());
        }
    }
}