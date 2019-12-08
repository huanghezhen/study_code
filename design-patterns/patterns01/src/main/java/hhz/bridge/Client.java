package hhz.bridge;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/8 22:19
 */
public class Client {
    public static void main(String[] args) throws Exception {
        FoldedPhone foldedPhone = new FoldedPhone(new XiaoMi());

        foldedPhone.call();
    }
}
