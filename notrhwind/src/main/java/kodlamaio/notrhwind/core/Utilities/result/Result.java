package kodlamaio.notrhwind.core.Utilities.result;

public class Result {
	
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success,String message) {
		this(success); //method icindekini this diye dondururuz.
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
