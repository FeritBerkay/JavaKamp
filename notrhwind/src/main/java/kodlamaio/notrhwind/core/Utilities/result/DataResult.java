package kodlamaio.notrhwind.core.Utilities.result;

public class DataResult<T> extends Result {

	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message); //super base sınıf. Base sınıfa succes ve mesaage ı yolluyor.
		this.data=data;	
		}
	public DataResult(T data, boolean success) {
		super(success);
		this.data=data;	
		}
	public T data(T data) {
		return this.data;
	}

	

}
