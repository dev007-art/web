package cn.AndiOS.web.proxy;

public class Lenove implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"元");
        return "联想";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
