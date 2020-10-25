package MianJi;

public class Cicle {
    double banjing,zhouchang,area;
    Cicle(double r){
        banjing = r;
    }
    double area(){
        zhouchang = 2*Math.PI*banjing;
        area = Math.PI*banjing*banjing;
        System.out.println("圆的周长为："+ zhouchang);
        System.out.println("圆的面积为：" + area);
        return area;
    }
}
