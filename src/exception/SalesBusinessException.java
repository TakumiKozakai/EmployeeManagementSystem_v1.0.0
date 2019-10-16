package exception;

public class SalesBusinessException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 * @param message
	 */
	public SalesBusinessException(String message) {
		super(message);
	}

}
