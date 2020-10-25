package MianJi;

public class Ladder {//类
    double shangdi,xiadi,height,area;//声明数据类型
    public Ladder(double shangdi,double xia,double gao){//构造方法
        this.shangdi = shangdi;
        xiadi = xia;
        height = gao;
    }

    public double area(){//方法
        area = (shangdi + xiadi)*height/2;
        System.out.println("梯形面积为：" + area);
        return area;
    }
}
