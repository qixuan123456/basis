package day23;

public abstract class zhongxuesheng implements Student{
    @Override
    public String getName() {
        return "我是中学生";
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getSex() {
        return null;
    }
}
