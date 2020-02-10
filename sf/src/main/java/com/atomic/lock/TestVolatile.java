package com.atomic.lock;

public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("-------------------可见");
                break;
            }
        }
    }
}
class ValObject{
    boolean flag = false;
}

class ThreadDemo implements Runnable {
    private     ValObject object = new ValObject();
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        object.flag = true;
        System.out.print("flag = " + isFlag());
    }
    public boolean isFlag() {
        return object.flag;
    }
    public void setFlag(boolean flag) {
        this.object.flag = flag;
    }
}