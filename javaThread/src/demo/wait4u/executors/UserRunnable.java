package demo.wait4u.executors;

/**
 * 
 * @author beeworkshop
 *
 *         扩展接口，定义新的抽象方法，以获得在其上的多态效果。
 */
public interface UserRunnable extends Runnable {
	void setSelf(Thread self);

	Thread getSelf();
}
