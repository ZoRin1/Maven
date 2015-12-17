package businesslogic.financebl;

public class CostException extends Exception{
    public CostException()  {}                //用来创建无参数对象
    public CostException(String message) {        //用来创建指定参数对象
        super(message);                             //调用超类构造器
    }
}
