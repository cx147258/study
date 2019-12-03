package cx.Utils;

import java.util.UUID;

/**
 * UUID 来作为数据库数据表主键是非常不错的选择，保证每次生成的UUID 是唯一的
 * UUID 工具类
 */
public class UuidUtil {
    public UuidUtil(){

    }
    /**
     * 获得一个UUID
     *
     * @return String UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    /**
     * 获得指定数目的UUID
     *
     * @param number int 需要获得的UUID数量
     * @return String[] UUID数组
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}
