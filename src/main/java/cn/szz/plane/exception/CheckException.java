package cn.szz.plane.exception;

/**
 * 异常
 *
 * @author Shi Zezhu
 * @date 2018年8月22日 下午4:28:28
 */
public class CheckException extends RuntimeException {

	private static final long serialVersionUID = -4985699956773156367L;

	public CheckException() {
        super();
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }
}
