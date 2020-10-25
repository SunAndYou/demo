package study_end;

public class Student {
    public int num;//学号
    public String name;//姓名
    public String course;//学科
    public int grade;//成绩
    public Student(int num,String name,int grade,String course ) {
        this.num = num;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }
}