package day8;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Bmo
 * @date 2019/11/20 11:02
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> userClass = Class.forName("day8.User");
        String simpleName = userClass.getSimpleName(); //获取类名
        String name = userClass.getName(); //获取全类名
        System.out.println("全类名：" + name);
        System.out.println("类名：" + simpleName);
        System.out.println("================");
        //获取该类中的所有方法（不包括继承的方法）
        Method[] methods = userClass.getDeclaredMethods();
        Method[] methods2 = userClass.getMethods();
        for (Method m : methods2) {
            System.out.println("方法名：" + m.getName() + "返回值类型" + m.getReturnType() + "，参数列表"
                    + Arrays.toString(m.getParameterTypes()));
        }
                                                    //方法名称          参数类型
        Method m1 = userClass.getDeclaredMethod("setUsername", String.class);
        Method m2 = userClass.getDeclaredMethod("testReflect", String.class, int.class, boolean.class);
        //获取父类
        Class<?> superclass = userClass.getSuperclass();
        System.out.println("父类是" + superclass.getSimpleName());
        //获取构造方法
        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("方法名" + c.getName() + "参数列表" + Arrays.toString(c.getParameterTypes()));

        }
        //获取所有属性
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性名 ：" + field.getName() + "   类型：" + field.getType());
        }
//        userClass.getFields()
    }

    @Test
    public void testReflect() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //1.通过反射创建对象  获取class对象
        Class<User> userClass = User.class;
        //2.通过class对象的方法获取  newInstance()  运行时会去调用无参构造
        //如果是私有的才会报错
        User user = userClass.newInstance();
        //通过反射的class对象获取其中一个属性      参数为属性名
        Field field = userClass.getDeclaredField("username");
        //通过反射赋值属性      如果属性是私有的 需要特殊处理
        field.setAccessible(true); //代表允许设置私有属性，如果不是私有的就不用加了
//        field.set(目标对象， 赋值的实际内容);
        field.set(user, "张三123");
        System.out.println(user.getUsername());
        Method m = userClass.getDeclaredMethod("setPw", String.class);
        m.invoke(user, "瘪三123");//调用方法

    }
}
